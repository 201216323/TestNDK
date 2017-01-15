package com.bruce.chang.guolu;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    {
        System.loadLibrary("GuoLu");
    }

    PressureView pressureView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pressureView = new PressureView(MainActivity.this);
        setContentView(pressureView);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    SystemClock.sleep(500);
                    int pressure = Math.abs(getPressure());
                    pressureView.setPressure(pressure);
                    //如果压力大于220
                    if (pressure > 220) {
                        break;
                    }
                }
            }
        }).start();

        //应用卸载时候的监听，没有成功
//        unInstallListener(Build.VERSION.SDK_INT);
    }

    /**
     * native代码
     * 调用C代码中的对应方法
     *
     * @return
     */
    public native int getPressure();

    /**
     * 应用卸载时候调用
     *
     * @param sdkVersion
     */
    public native void unInstallListener(int sdkVersion);
}
