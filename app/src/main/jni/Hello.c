//
// Created by Administrator on 2017/1/5.
//

#include <com_bruce_chang_testndk_JniKit.h>

JNIEXPORT jstring JNICALL Java_com_bruce_chang_testndk_JniKit_sayHello(JNIEnv *env, jobject jobj) {
    return (*env)->NewStringUTF(env, "Hello from C");
}