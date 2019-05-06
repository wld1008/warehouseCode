package com.pastry.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Date;

/**
 * Created by wulidan on 19/5/2.
 */
public class GenEntityMysql {

    private String packageOutPath = "com.pastry.iscs.pojo";//指定实体生成所在包的路径
    private String authorName = ""; //作者名字
    private String tablename = ""; //表名
    private String[] colnames; // 列名数组
    private String[] colTypes; //列名类型数组
    private int[] colSizes; //列名大小数组
    private boolean f_util = false; // 是否需要导入包java.util.*
    private boolean f_sql = false; // 是否需要导入包java.sql.*

    //数据库连接
    private String URL = "";
    private String NAME = "" ;//数据库表名称
    private static final String PASS = "wulidan";
    private static final String DRIVER ="com.mysql.jdbc.Driver" ;

    public static enum DATASOURCE {
        BASICDATA("basicdata_user01"), REALITYDATA( "realitydata_user01"), RESOURCEDATA("resourcedata_user01" ),
        TASKDATA("taskdata_user01"), CONTRACTDATA( "contractdata_user01"), EXTERNALDATA("externaldata_user01" );

        public final String userName;

        public String getUserName() {
            return userName;
        }


        DATASOURCE(String userName){
            this. userName = userName;
        }

    }


    /*
     * 构造函数
     */
    public GenEntityMysql(String tablename,String dataSource){
        this.URL= "jdbc:mysql://127.0.0.1:3306/mybase";
        this.tablename = tablename;
        for (DATASOURCE data : DATASOURCE. values()) {
            if(data.name().equals(dataSource)){
                this. NAME = data.userName ;
                break;
            }
        }
        //创建连接
        Connection con;
        //查要生成实体类的表
        String sql = "select * from " + tablename;
        Statement pStemt = null;
        try {
            try {
                Class. forName(DRIVER);
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
            con = DriverManager. getConnection(URL,"root", "wulidan");
            pStemt = (Statement) con.createStatement();
            ResultSet rs = pStemt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int size = rsmd.getColumnCount();   //统计列
            colnames = new String[size];
            colTypes = new String[size];
            colSizes = new int[size];
            for ( int i = 0; i < size; i++) {
                colnames[i] = initcap(rsmd.getColumnName(i + 1));
                colTypes[i] = rsmd.getColumnTypeName(i + 1);

                if( colTypes[i].equalsIgnoreCase( "date") || colTypes[i].equalsIgnoreCase("timestamp" )){
                    f_util = true;
                }
                if( colTypes[i].equalsIgnoreCase( "blob") || colTypes[i].equalsIgnoreCase("char" )){
                    f_sql = true;
                }
                colSizes[i] = rsmd.getColumnDisplaySize(i + 1);
            }

            String content = parse( colnames, colTypes, colSizes);

            try {
                File directory = new File( "/Users/wulidan/Desktop/test");
                System. out.println( "文件存放路径：" +directory.getAbsolutePath());
                String outputPath = directory.getAbsolutePath()+ "/"+initcap(tablename) + ".java" ;
                FileWriter fw = new FileWriter(outputPath);
                PrintWriter pw = new PrintWriter(fw);
                pw.println(content);
                pw.flush();
                pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
        }
    }

    /**
     * 功能：生成实体类主体代码
     * @param colnames
     * @param colTypes
     * @param colSizes
     * @return
     */
    private String parse(String[] colnames, String[] colTypes, int[] colSizes) {
        StringBuffer sb = new StringBuffer();

        //判断是否导入工具包
        if(f_util){
            sb.append( "import java.util.Date;\r\n");
        }
        if(f_sql){
            sb.append( "import java.sql.*;\r\n");
        }
        sb.append( "package " + this. packageOutPath + ";\r\n");
        sb.append( "\r\n");
        //注释部分
        sb.append( "   /**\r\n");
        sb.append( "    * "+tablename +" 实体类\r\n" );
        sb.append( "    * "+new Date()  +this.authorName+"\r\n");
        sb.append( "    */ \r\n");
        //实体部分
        sb.append( "\r\n\r\npublic class " + initcap(tablename ) + "{\r\n");
        processAllAttrs(sb); //属性
        processAllMethod(sb); //get set方法
        sb.append( "}\r\n");

        return sb.toString();
    }

    /**
     * 功能：生成所有属性
     * @param sb
     */
    private void processAllAttrs(StringBuffer sb) {
        sb.append("\t\r\n");
        for (int i = 0; i < colnames. length; i++) {
            sb.append( "\tprivate " + sqlType2JavaType(colTypes [i]) + " " + colnames[i] + ";\r\n" );
        }

    }

    /**
     * 功能：生成所有方法
     * @param sb
     */
    private void processAllMethod(StringBuffer sb) {

        for (int i = 0; i < colnames. length; i++) {
            sb.append( "\t\r\n");
            sb.append( "\tpublic void set" + initFirUpCase(colnames [i]) + "(" + sqlType2JavaType(colTypes [i]) + " " +
                    colnames[i] + "){\r\n");
            sb.append( "\t\tthis." + colnames [i] + " = " + colnames [i] + ";\r\n");
            sb.append( "\t}\r\n");
            sb.append( "\t\r\n");
            sb.append( "\tpublic " + sqlType2JavaType(colTypes [i]) + " get" + initFirUpCase(colnames[i]) + "(){\r\n");
            sb.append( "\t\treturn " + colnames [i] + ";\r\n" );
            sb.append( "\t}\r\n");
        }

    }

    /**
     * 功能：将输入字符串的下划线后面的首字母改成大写
     * @param str
     * @return
     */
    private String initcap(String str) {

        String[] st = str.split( "");
        StringBuffer sbf = new StringBuffer();
        for ( int i = 0; i < st. length; i++) {
            if( "_".equals(st[i])){
                st[i+1] = st[i+1].toUpperCase();
                sbf.append(st[i+1].toUpperCase());
                i++;
            } else{
                sbf.append(st[i].toLowerCase());
            }
        }
        return sbf.toString();
    }


    /**
     * 功能：将输入字符串的首字母改成大写
     * @param str
     * @return
     */
    private String initFirUpCase(String str) {

        char[] ch = str.toCharArray();
        if(ch[0] >= 'a' && ch[0] <= 'z'){
            ch[0] = ( char)(ch[0] - 32);
        }

        return new String(ch);

    }

    /**
     * 功能：获得列的数据类型
     * @param sqlType
     * @return
     */
    private String sqlType2JavaType(String sqlType) {

        if(sqlType.equalsIgnoreCase( "binary_double")){
            return "double";
        } else if(sqlType.equalsIgnoreCase( "binary_float")){
            return "float";
        } else if(sqlType.equalsIgnoreCase( "blob")){
            return "byte[]";
        } else if(sqlType.equalsIgnoreCase( "blob")){
            return "byte[]";
        } else if(sqlType.equalsIgnoreCase( "char") || sqlType.equalsIgnoreCase("nvarchar2" )
                || sqlType.equalsIgnoreCase( "varchar2")){
            return "String";
        } else if(sqlType.equalsIgnoreCase( "date") || sqlType.equalsIgnoreCase("timestamp" )
                || sqlType.equalsIgnoreCase( "timestamp with local time zone")
                || sqlType.equalsIgnoreCase( "timestamp with time zone")){
            return "Date";
        } else if(sqlType.equalsIgnoreCase( "number")){
            return "Long";
        }

        return "String";
    }

    public static void main(String[] args) {
        new GenEntityMysql( "user","mybase" );
    }


}
