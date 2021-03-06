//
// Created by Administrator on 2017/1/11.
//

#include <com_bruce_chang_ccalljava_Jni.h>

void Java_com_bruce_chang_ccalljava_Jni_callbackHelloFromJava
        (JNIEnv * env, jobject obj) {

    //1. 加载类得到jclass对象:
    //jclass      (*FindClass)(JNIEnv*, const char*);
    jclass jc = (*env)->FindClass(env, "com/bruce/chang/ccalljava/Jni");
    //2. 得到对应方法的Method对象 : GetMethodId()
    //jmethodID   (*GetMethodID)(JNIEnv*, jclass, const char*, const char*)
    jmethodID method = (*env)->GetMethodID(env, jc, "helloFromJava", "()V");
    //3. 创建类对象
    //jobject     (*AllocObject)(JNIEnv*, jclass);
    jobject obj2 = (*env)->AllocObject(env, jc);
    //4. 调用方法
    (*env)->CallVoidMethod(env, obj2, method);
}

 void  Java_com_bruce_chang_ccalljava_Jni_callbackAdd(JNIEnv * env, jobject obj){
     //1. 加载类得到class对象
     jclass jc = (*env)->FindClass(env, "com/bruce/chang/ccalljava/Jni");
     //2. 得到对应方法的Method对象
     jmethodID method = (*env)->GetMethodID(env, jc, "add", "(II)I");
     //3. 创建类对象
     jobject obj2 = (*env)->AllocObject(env, jc);
     //4. 调用方法
     (*env)->CallIntMethod(env, obj2, method, 3, 4);
 }

void  Java_com_bruce_chang_ccalljava_Jni_callbackPrintString(JNIEnv * env, jobject obj){
    //1. 加载类得到class对象
    jclass jc = (*env)->FindClass(env, "com/bruce/chang/ccalljava/Jni");
    //2. 得到对应方法的Method对象
    jmethodID method = (*env)->GetMethodID(env, jc, "printString", "(Ljava/lang/String;)V");
    //3. 创建类对象
    jobject obj2 = (*env)->AllocObject(env, jc);
    //4. 调用方法
    jstring js = (*env)->NewStringUTF(env, "I from C");
    (*env)->CallVoidMethod(env, obj2, method, js);
}

void  Java_com_bruce_chang_ccalljava_Jni_callbackSayHello(JNIEnv * env, jobject obj){
    //1. 加载类得到class对象
    jclass jc = (*env)->FindClass(env, "com/bruce/chang/ccalljava/Jni");
    //2. 得到对应方法的Method对象
    jmethodID method = (*env)->GetStaticMethodID(env, jc, "sayHello", "(Ljava/lang/String;)V");
    //3. 调用方法
    jstring js = (*env)->NewStringUTF(env, "I from C");
    (*env)->CallStaticVoidMethod(env, jc, method, js);
}

/**
 * 让C代码调用MainActivity中的showToast方法
 * obj  谁调用了当前Java_com_bruce_chang_ccalljava_Jni_callbackShowToast对应的java方法就是就是谁的实例，
 * 该方法如果放在Jni这个类中就是是Jni.this，如果放在MainActivity中就是MainActivity.this
 */
void  Java_com_bruce_chang_ccalljava_MainActivity_callbackShowToast(JNIEnv * env, jobject obj){
    //1. 加载类得到class对象
    jclass jc = (*env)->FindClass(env, "com/bruce/chang/ccalljava/MainActivity");
    //2. 通过方法名和方法签名得到对应方法的Method对象
    jmethodID method = (*env)->GetMethodID(env, jc, "showToast", "()V");
    //3. 创建类对象
   // jobject obj2 = (*env)->AllocObject(env, jc);
    //4. 调用方法
    (*env)->CallVoidMethod(env, obj, method);
}

/**
 * 让C代码调用MainActivity中的showToast方法
 * obj  谁调用了当前Java_com_bruce_chang_ccalljava_Jni_callbackShowToast对应的java方法就是就是谁的实例，
 * 该方法如果放在Jni这个类中就是是Jni.this，如果放在MainActivity中就是MainActivity.this
 */
void  Java_com_bruce_chang_ccalljava_Jni_callbackShowToast(JNIEnv * env, jobject obj){
    //1. 加载类得到class对象
    jclass jc = (*env)->FindClass(env, "com/bruce/chang/ccalljava/MainActivity");
    //2. 通过方法名和方法签名得到对应方法的Method对象
    jmethodID method = (*env)->GetMethodID(env, jc, "showToast", "()V");
    //3. 创建类对象
    jobject obj2 = (*env)->AllocObject(env, jc);
    //4. 调用方法
    (*env)->CallVoidMethod(env, obj2, method);
}