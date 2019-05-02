package com.pastry.thread;

/**
 * Created by wulidan on 18/7/24.
 */
public class ThreadLocalTest {

    public void aa(){
        String mm = "mmmm";
        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set(mm);
    }

    public void bb(){

    }
}
