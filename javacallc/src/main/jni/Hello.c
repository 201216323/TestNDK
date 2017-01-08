//
// Created by Administrator on 2017/1/5.
//

#include <bruce_chang_javacallc_Jni.h>

/**
    * 求两个数字的和
    *
    * @param x
    * @param y
    * @return
    */
JNIEXPORT jint JNICALL Java_bruce_chang_javacallc_Jni_sum
        (JNIEnv *env, jobject jobj, jint int1, jint int2) {
    //jint可以直接进行算术运算
    int sum = int1 + int2;
    //可直接将int类型数据作为jint返回
    return sum;
}


/**
 * 工具函数
 * 把一个jstring转换成一个c语言的char* 类型.
 */
char* _JString2CStr(JNIEnv* env, jstring jstr) {

    char* rtn;
    jclass clsstring = (*env)->FindClass(env, "java/lang/String");
    jstring strencode = (*env)->NewStringUTF(env,"GB2312");
    jmethodID mid = (*env)->GetMethodID(env, clsstring, "getBytes", "(Ljava/lang/String;)[B");
    jbyteArray barr = (jbyteArray)(*env)->CallObjectMethod(env, jstr, mid, strencode); // String .getByte("GB2312");
    jsize alen = (*env)->GetArrayLength(env, barr);
    jbyte* ba = (*env)->GetByteArrayElements(env, barr, JNI_FALSE);
    if(alen > 0) {
        rtn = (char*)malloc(alen+1); //"\0"
        memcpy(rtn, ba, alen);
        rtn[alen]=0;
    }
    (*env)->ReleaseByteArrayElements(env, barr, ba,0);
    return rtn;
}


/**
     * 将两个字符串拼接后返回
     *
     * @param s  I am BruceChang
     *        c  I am SWJ
     * @return  I am BruceChang add I am SWJ
     */
JNIEXPORT jstring JNICALL Java_bruce_chang_javacallc_Jni_sayHello
        (JNIEnv * env, jobject jobj, jstring js){
    //将jstring类型的js转换为char*类型数据
    char * fromJava = _JString2CStr(env,js);
    //c
    char * fromC = "add I am SWJ";
    //将拼接两个char*类型字符串拼接在第一个上
    strcat(fromJava, fromC);
    //将结果转换为jstring类型返回
    return (*env)->NewStringUTF(env, fromJava);
}

/**
    * 将数组中的每个元素增加10
    *
    * @param intArray
    * @return
    */
JNIEXPORT jintArray JNICALL Java_bruce_chang_javacallc_Jni_increaseArrayEles
        (JNIEnv * env, jobject jobj, jintArray arr){

    //1. 得到数组的长度
    //jsize       (*GetArrayLength)(JNIEnv*, jarray);
    jsize length = (*env)->GetArrayLength(env, arr);
    //2. 得到数组
    //jint*       (*GetIntArrayElements)(JNIEnv*, jintArray, jboolean*);
    jint* array = (*env)->GetIntArrayElements(env, arr, JNI_FALSE);
    //3. 遍历数组, 并将每个元素+10
    int i;
    for(i=0;i<length;i++) {
        *(array+i) += 10;
    }
    //4. 返回数组
    return arr;
}

/**
 *  应用: 检查密码是否正确, 如果正确返回200, 否则返回400
 "123456"
 * @param pwd
 * @return
 */
JNIEXPORT jint JNICALL Java_bruce_chang_javacallc_Jni_checkPwd
        (JNIEnv * env, jobject jobj, jstring string){
    //1. 将jString转换为char*
    char* cs = _JString2CStr(env, string);
    char* pwd = "123456";
    //2. 比较两个字符串是否相等
    int result = strcmp(cs, pwd);
    //3. 根据比较的结果返回不同的值
    if(result==0) {
        return 200;
    }
    return 400;
}