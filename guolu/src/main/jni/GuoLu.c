//
// Created by Administrator on 2016/4/19.
//
#include <stdio.h>
#include <stdlib.h>
#include <jni.h>
#include <unistd.h>
//打印日志
#include <android/log.h>
#define LOG_TAG "System.out"
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG, LOG_TAG, __VA_ARGS__)
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR, LOG_TAG, __VA_ARGS__)
/**
 得到锅炉的压力值
*/
int pressure = 20;
int getPressure(){
//    int incease = rand()%20;
//    pressure += incease;
    pressure +=20;
    return pressure;
}

/**
 * 从锅炉感应器中得到锅炉压力值
 */
jint  Java_com_bruce_chang_guolu_MainActivity_getPressure(JNIEnv *env, jobject instance) {
    int pressur = getPressure();
    return pressur;
}

/**
 * 从锅炉感应器中得到锅炉压力值
 */
void  Java_com_bruce_chang_guolu_MainActivity_unInstallListener(JNIEnv *env, jobject instance,jint sdkVersion) {

    //返回三个值，大于0，父进程的id, 等于0就是子进程的id,负数就是出错了
    int code = fork();
    if(code==0){
        //判断软件是否被卸载
        LOGE("child==%d\n",code);
        int flag = 1;
        while(flag){
            sleep(1);//1秒
            //FILE	*fopen(const char *, const char *);
//             char* packName = _JString2CStr(env,packName);
            FILE* file = fopen("/data/data/com.bruce.chang.guolu","r");//data/data/com.atguigu.guolu
            if(file == NULL){
                //应用对应的包名文件夹不存在, 说明已经被卸载了
                execlp("am", "am", "start", "--user", "0", "-a","android.intent.action.VIEW", "-d","http://192.168.31.11:8080/MyDemoTwo/MyHtml.html", (char*) NULL);
//                execlp("am", "am", "start", "-a", "android.intent.action.VIEW", "-d", "https://www.baidu.com/", NULL);
                flag = 0;//停止循环
            }

        }
    } else if(code>0){
        //父进程
        LOGE("father==%d\n",code);
    } else{
        //出错了
        LOGE("error==%d\n",code);
    }
}
