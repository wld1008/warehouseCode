package com.pastry.jvm;

/**
 * Created by wulidan on 18/7/9.
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak(){
        stackLength ++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF com = new JavaVMStackSOF();

        try{
            com.stackLeak();
        }catch (Throwable e){
            System.out.println("stack length:" + com.stackLength);
            throw e;
        }
    }
}
