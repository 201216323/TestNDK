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

//com.bruce.chang.testndk.JniKit
//
//
//        NDK开发流程：
//
//        在java里面写native代码
//
//        在main目录下创建jni目录写C代码，--生成头文件
//
//        配置动态链接库的名称
//
//        加载动态链接库
//
//        使用