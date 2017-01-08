package bruce.chang.javacallc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bt_sum, bt_String, bt_array, bt_ps;
    Jni jni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_sum = (Button) findViewById(R.id.bt_sum);
        bt_sum.setOnClickListener(this);
        bt_String = (Button) findViewById(R.id.bt_String);
        bt_String.setOnClickListener(this);
        bt_array = (Button) findViewById(R.id.bt_array);
        bt_array.setOnClickListener(this);
        bt_ps = (Button) findViewById(R.id.bt_ps);
        bt_ps.setOnClickListener(this);

        jni = new Jni();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_sum:
                bt_sum.setText("和：" + jni.sum(99, 1));
                break;
            case R.id.bt_String:
                bt_String.setText(jni.sayHello("I am BruceChang "));
                break;
            case R.id.bt_array:
                int[] a = {1, 2, 3, 4, 5};
                int[] b = jni.increaseArrayEles(a);
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < b.length; i++) {
                    builder.append(b[i] + "\n");
                }
                bt_array.setText(builder.toString());
                break;
            case R.id.bt_ps:
                int result = jni.checkPwd("123456");
                if (result==200)
                bt_ps.setText("成功了："+result);
                if (result==400)
                    bt_ps.setText("失败了："+result);
                break;
            default:
                break;
        }
    }
}
