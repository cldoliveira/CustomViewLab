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
        redPaintbrush.setStrokeWidth(15);

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

        //canvas.drawCircle(700, 1200, 350, redPaintbrush);

        RectF rectF = new RectF(200, 200, 1300, 1300);
        //canvas.drawRect(rectF, redPaintbrush);
        canvas.drawArc(rectF, -90, currentAngle, false, redPaintbrush);
    }
}
