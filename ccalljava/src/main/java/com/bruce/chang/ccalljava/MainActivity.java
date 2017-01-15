package com.bruce.chang.ccalljava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bt_para_no, bt_para_int, bt_para_str, bt_para_static, bt_test;
    Jni jni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_para_no = (Button) findViewById(R.id.bt_para_no);
        bt_para_no.setOnClickListener(this);
        bt_para_int = (Button) findViewById(R.id.bt_para_int);
        bt_para_int.setOnClickListener(this);
        bt_para_str = (Button) findViewById(R.id.bt_para_str);
        bt_para_str.setOnClickListener(this);
        bt_para_static = (Button) findViewById(R.id.bt_para_static);
        bt_para_static.setOnClickListener(this);
        bt_test = (Button) findViewById(R.id.bt_test);
        bt_test.setOnClickListener(this);
        jni = new Jni();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_para_no:
                jni.callbackHelloFromJava();
                break;
            case R.id.bt_para_int:
                jni.callbackAdd();
                break;
            case R.id.bt_para_str:
                jni.callbackPrintString();
                break;
            case R.id.bt_para_static:
                jni.callbackSayHello();
                break;
            case R.id.bt_test:
                // jni.callbackShowToast();不能调用jni中的callbackShowToast方法，这样会报空指针错误，因为发射得到的是MainActivity的类，
                // 并不是Activity，在执行showToast方法的时候就出错了
                MainActivity.this.callbackShowToast();
                break;
            default:
                break;
        }
    }

    /**
     * 让C代码调用MainActivity中的showToast方法
     */
    public native void callbackShowToast();

    public void showToast() {
        Toast.makeText(MainActivity.this, "this is a toast!!!", Toast.LENGTH_SHORT).show();
    }
}
