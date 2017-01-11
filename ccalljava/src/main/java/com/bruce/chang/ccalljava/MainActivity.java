package com.bruce.chang.ccalljava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

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

                break;
            default:
                break;
        }
    }


}
