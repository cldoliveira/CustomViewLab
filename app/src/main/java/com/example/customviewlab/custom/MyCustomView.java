package com.example.customviewlab.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class MyCustomView extends View {
    private Paint redPaintbrush;
    private Paint blackPaintbrush;
    private Paint bluePaintbrush;
    private Paint redBrushFill;
    private float currentAngle;

    public MyCustomView(Context context) {
        this(context, null);
    }

    public MyCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.currentAngle = 0;
        setBackgroundColor(Color.LTGRAY);
        redPaintbrush = new Paint();
        redPaintbrush.setARGB(255, 255, 0, 0);
        redPaintbrush.setStyle(Paint.Style.STROKE);
        redPaintbrush.setStrokeWidth(100);

        redBrushFill = new Paint();
        redBrushFill.setARGB(255, 255, 0, 0);
        redBrushFill.setStyle(Paint.Style.FILL);

        blackPaintbrush = new Paint();
        blackPaintbrush.setARGB(255, 0, 0, 0);

        bluePaintbrush = new Paint();
        bluePaintbrush.setARGB(255, 0, 0, 255);
        bluePaintbrush.setStyle(Paint.Style.STROKE);
        bluePaintbrush.setStrokeWidth(15);

        setFocusable(true);
    }

    public void startAnimating(final float maxAngle) {
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
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //int cx = 700;
        //int cy = 1200;
        //int radius = 500;

        //canvas.drawCircle(700, 1200, 500, redPaintbrush);

        /*for (int i = 0; i < 360; i = i + 30) {
            double x = cx + radius * Math.cos(getRad(i));
            double y = cy - radius * Math.sin(getRad(i));
            canvas.drawCircle((float)x, (float)y, 50, redPaintbrush);
        }*/

        int left = 200;
        int top = 200;
        int right = 1300;
        int bottom = 1300;

        int cx = (left + right) / 2;
        int cy = (top + bottom) / 2;
        int radius = (right - left) / 2;

        RectF rectF = new RectF(left, top, right, bottom);
        //canvas.drawRect(rectF, redPaintbrush);
        double x = cx + radius * Math.cos(getRad(90));
        double y = cy - radius * Math.sin(getRad(90));
        double x2 = cx + radius * Math.cos(getRad(310));
        double y2 = cy - radius * Math.sin(getRad(310));

        canvas.drawArc(rectF, -90, 140, false, redPaintbrush);
        canvas.drawCircle((float)x, (float)y, 50, redBrushFill);
        canvas.drawCircle((float)x2, (float)y2, 50, redBrushFill);
    }

    private double getRad(int angle) {
        return angle * Math.PI / 180;
    }
}
