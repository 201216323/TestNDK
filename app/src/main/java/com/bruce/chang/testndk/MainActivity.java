package com.bruce.chang.testndk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvNdk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvNdk = (TextView) findViewById(R.id.tvNdk);
        String s = new JniKit().sayHello();
        tvNdk.setText(s);
    }
}
