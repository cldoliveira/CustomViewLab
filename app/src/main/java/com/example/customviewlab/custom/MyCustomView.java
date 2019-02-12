package com.example.customviewlab.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class MyCustomView extends View {
    private Paint bluePaintbrush;
    private Paint bluePaintFill;
    private Paint grayPaintbrush;
    //private float currentAngle;

    public MyCustomView(Context context) {
        this(context, null);
    }

    public MyCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(Color.WHITE);

        bluePaintFill = new Paint();
        bluePaintFill.setARGB(255, 8, 232, 222);
        bluePaintFill.setStyle(Paint.Style.FILL);

        bluePaintbrush = new Paint();
        bluePaintbrush.setARGB(255, 8, 232, 222);
        bluePaintbrush.setStyle(Paint.Style.STROKE);
        bluePaintbrush.setStrokeWidth(80);

        grayPaintbrush = new Paint();
        grayPaintbrush.setARGB(255, 230, 230, 230);
        grayPaintbrush.setStyle(Paint.Style.STROKE);
        grayPaintbrush.setStrokeWidth(80);

        setFocusable(true);
    }

    /*public void startAnimating(final float maxAngle) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (currentAngle <= maxAngle) {
                        invalidate();
                        Thread.sleep(5);
                        currentAngle++;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }*/

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int left = 200;
        int top = 200;
        int right = 1300;
        int bottom = 1300;

        int cx = (left + right) / 2;
        int cy = (top + bottom) / 2;
        int radius = (right - left) / 2;

        RectF rectF = new RectF(left, top, right, bottom);
        double x = cx + radius * Math.cos(getRad(90));
        double y = cy - radius * Math.sin(getRad(90));
        double x2 = cx + radius * Math.cos(getRad(220));
        double y2 = cy - radius * Math.sin(getRad(220));

        canvas.drawArc(rectF, -90, 360, false, grayPaintbrush);
        canvas.drawArc(rectF, -90, 230, false, bluePaintbrush);
        canvas.drawCircle((float)x, (float)y, 40, bluePaintFill);
        canvas.drawCircle((float)x2, (float)y2, 40, bluePaintFill);
    }

    private double getRad(int angle) {
        return angle * Math.PI / 180;
    }
}
