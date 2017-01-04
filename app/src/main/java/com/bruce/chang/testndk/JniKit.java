package com.bruce.chang.testndk;

/**
 * Created by Administrator
 * Date:2017/1/4
 * Time:21:08
 * Author:BruceChang
 * Function:java调用对应C代码的Java类
 */

public class JniKit {

    static {
        System.loadLibrary("Hello");
    }


    /**
     * 定义native方法
     * 调用C代码对应的方法
     * @return
     */
    public native String sayHello();
}
