//
// Created by Administrator on 2017/1/4.
//

#include "com_bruce_chang_testndk_JniKit.h"
#include <stdio.h>
#include <stdlib.h>

JNIEXPORT jstring JNICALL Java_com_bruce_chang_testndk_JniKit_sayHello
        (JNIEnv * env, jobject jobj) {
    return (*env)->NewStringUTF(env, "Hello from C");
}