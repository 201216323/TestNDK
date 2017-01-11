package com.bruce.chang.ccalljava;

import android.util.Log;

/**
 * Created by Administrator
 * Date:2017/1/11
 * Time:7:35
 * Author:BruceChang
 * Function:
 */

public class Jni {

    static {
        System.loadLibrary("ccalljava");
    }
    public native void callbackHelloFromJava();

    public native void callbackAdd();

    public native void callbackPrintString();

    public native void callbackSayHello();

    public void helloFromJava() {
        Log.e("TAG", "helloFromJava()");
    }

    public int add(int x, int y) {
        Log.e("TAG", "add() x=" + x + " y=" + y);
        return x + y;
    }

    public void printString(String s) {
        Log.e("TAG", "C中输入的：" + s);
    }

    public static void sayHello(String s) {
        Log.e("TAG", "我是java代码中的JNI."
                + "java中的sayHello(String s)静态方法，我被C调用了:" + s);
    }
}


