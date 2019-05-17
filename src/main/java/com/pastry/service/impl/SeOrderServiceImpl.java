package com.pastry.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pastry.mapping.ImDeliveryTrackingMapper;
import com.pastry.mapping.ImProductDOMapper;
import com.pastry.mapping.SeOrderMapper;
import com.pastry.pojo.ImDeliveryTracking;
import com.pastry.pojo.ImProductDO;
import com.pastry.pojo.SeOrder;
import com.pastry.service.SeOrderService;
import com.pastry.utils.ExpCodeEnum;
import com.pastry.utils.HttpConnUtil;
import com.pastry.utils.OrderStatusEnum;
import com.pastry.utils.result.PageResult;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.DateUtils;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wulidan on 19/5/6.
 */
@Service
public class SeOrderServiceImpl implements SeOrderService {

    private static final String URL = "https://www.kuaidi100.com/query" ;
    private static final String TEMP = "0.017490272547496355" ;
    @Resource
    SeOrderMapper seOrderDOMapper;
    @Resource
    private ImProductDOMapper imProductDOMapper;
    @Resource
    private ImDeliveryTrackingMapper deliveryTrackingMapper;

    @Override
    public PageResult<List<SeOrder>> getAllOrder(int page, int limit) {
        PageResult pageResult = new PageResult();
        int startRow = (page - 1) * limit;
        List<SeOrder> orders = seOrderDOMapper.getAll(startRow, limit);
        if(CollectionUtils.isEmpty(orders)) {
            return null;
        }
        List<SeOrder> orderList = new ArrayList<>();
        for(SeOrder order : orders) {
            ImProductDO productDO = imProductDOMapper.getByCode(order.getProductCode());
            order.setProductName(productDO == null ? "" : productDO.getProductName());
            order.setDesc(productDO == null ? "" : OrderStatusEnum.getDesc(order.getOrderStatus()));
            orderList.add(order);
        }
        pageResult.setData(orderList);
        pageResult.setCount(seOrderDOMapper.getCount());
        return pageResult;
    }

    @Override
    public boolean queryTrackByExp(String expCode, String expNum) throws Exception {
        //查询所有已发货待签收的订单信息
        List<SeOrder> orderList = seOrderDOMapper.queryExpCode();
        if(CollectionUtils.isEmpty(orderList)) {
            return true;
        }

        for(SeOrder order : orderList) {
            List<NameValuePair> nameValuePairs =  new ArrayList<>();
            nameValuePairs.add(new BasicNameValuePair("type",ExpCodeEnum.getDesc(order.getExpressName())));
            nameValuePairs.add(new BasicNameValuePair("postid",order.getExpNumber()));
            nameValuePairs.add(new BasicNameValuePair("temp",TEMP));
            String expTrack =  HttpConnUtil.sendGet(URL,nameValuePairs);
            List<ImDeliveryTracking> deliveryTrackings = parserTrack(expTrack);
            if(CollectionUtils.isEmpty(deliveryTrackings)){
                continue;
            }
            deliveryTrackingMapper.insertBatch(deliveryTrackings);
        }
        return true;
    }

    /**
     * 物流跟踪信息解析保存到数据库
     * @param expTrack
     * @return
     */
    private List<ImDeliveryTracking> parserTrack (String expTrack ) {
        JSONObject jsonObject  = JSONObject.parseObject(expTrack);
        if(!"OK".equals(jsonObject.getString("message"))) {
            return null;
        }
        List<ImDeliveryTracking> deliveryTrackings = new ArrayList<>();
        JSONArray expData = jsonObject.getJSONArray("data");
        for (int i = 0; i < expData.size(); i++) {
            JSONObject trackMsg = expData.getJSONObject(i);
            ImDeliveryTracking deliveryTracking = new ImDeliveryTracking();
            deliveryTracking.setReachDetail(trackMsg.getString("context"));
            deliveryTracking.setCreateTime(new Date());
            deliveryTracking.setOperateTime(trackMsg.getString("time"));
            deliveryTracking.setReachCounty(trackMsg.getString("location"));
            deliveryTrackings.add(deliveryTracking);
        }

        return deliveryTrackings;
    }

    @Override
    public PageResult deleteOrderById(List<Integer> ids) {
        seOrderDOMapper.deleteBatch(ids);
        return null;
    }
    
    @Override
    public PageResult save(SeOrder seOrder) {
        seOrderDOMapper.insert(seOrder);
        return new PageResult();
    }
}
