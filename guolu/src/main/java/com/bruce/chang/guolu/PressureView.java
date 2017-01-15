package com.bruce.chang.guolu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by Administrator
 * Date:2017/1/15
 * Time:15:26
 * Author:BruceChang
 * Function: 锅炉压力显示的自定义View
 */

public class PressureView extends View {
    private int pressure;
    private Paint mPaint;

    public PressureView(Context context) {
        super(context);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(50);
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
//        invalidate();//在主线程中运行
        postInvalidate();//ondraw()执行
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //1：如果压力值大于220，就绘制文本，显示锅炉爆炸了，快跑
        if (pressure > 220) {
            mPaint.setColor(Color.RED);
            canvas.drawText("要爆炸了，快跑炮", 10, getHeight() / 2, mPaint);
        } else {
            //2：正常和提示的情况
            //设置背景颜色为灰色
            mPaint.setColor(Color.GRAY);
            canvas.drawRect(10, 10, 60, 260, mPaint);
            canvas.drawText("pressure=="+pressure, 10, getHeight() / 2, mPaint);
            //2.1  如果是小于200正常显示并且设置画笔颜色绿色
            if (pressure < 200) {
                mPaint.setColor(Color.GREEN);
                canvas.drawRect(10, 260-pressure, 60, 260, mPaint);
            } else if (pressure>200){
                //2.2  如果是大于200警示显示给看护者，并且设置画笔颜色红色
                mPaint.setColor(Color.YELLOW);
                canvas.drawRect(10, 260-pressure, 60, 260, mPaint);
            }
        }
    }
}
