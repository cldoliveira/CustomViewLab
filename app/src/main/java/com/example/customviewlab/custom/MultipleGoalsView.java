package com.example.customviewlab.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class MultipleGoalsView extends View {
    private Paint red;
    private Paint redFill;
    private Paint green;
    private Paint greenFill;
    private Paint blue;
    private Paint blueFill;
    private int strokeWidth;

    public MultipleGoalsView(Context context) {
        this(context, null);
    }

    public MultipleGoalsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(Color.WHITE);
        this.strokeWidth = 120;

        red = new Paint();
        red.setARGB(255, 241, 33, 95);
        red.setStyle(Paint.Style.STROKE);
        red.setStrokeWidth(strokeWidth);

        redFill = new Paint();
        redFill.setARGB(255, 241, 33, 95);
        redFill.setStyle(Paint.Style.FILL);

        green = new Paint();
        green.setARGB(255, 166, 251, 0);
        green.setStyle(Paint.Style.STROKE);
        green.setStrokeWidth(strokeWidth);

        greenFill = new Paint();
        greenFill.setARGB(255, 166, 251, 0);
        greenFill.setStyle(Paint.Style.FILL);

        blue = new Paint();
        blue.setARGB(255, 2, 235, 249);
        blue.setStyle(Paint.Style.STROKE);
        blue.setStrokeWidth(strokeWidth);

        blueFill = new Paint();
        blueFill.setARGB(255, 2, 235, 249);
        blueFill.setStyle(Paint.Style.FILL);

        setFocusable(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int pointRadius = strokeWidth / 2;

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
        double x2 = cx + radius * Math.cos(getRad(210));
        double y2 = cy - radius * Math.sin(getRad(210));

        canvas.drawArc(rectF, -90, 240, false, red);
        canvas.drawCircle((float)x, (float)y, pointRadius, redFill);
        canvas.drawCircle((float)x2, (float)y2, pointRadius, redFill);

        int left2 = left + strokeWidth;
        int top2 = top + strokeWidth;
        int right2 = right - strokeWidth;
        int bottom2 = bottom - strokeWidth;

        cx = (left2 + right2) / 2;
        cy = (top2 + bottom2) / 2;
        radius = (right2 - left2) / 2;

        RectF rectF2 = new RectF(left2, top2, right2, bottom2);
        x = cx + radius * Math.cos(getRad(90));
        y = cy - radius * Math.sin(getRad(90));
        x2 = cx + radius * Math.cos(getRad(160));
        y2 = cy - radius * Math.sin(getRad(160));

        canvas.drawArc(rectF2, -90, 290, false, green);
        canvas.drawCircle((float)x, (float)y, pointRadius, greenFill);
        canvas.drawCircle((float)x2, (float)y2, pointRadius, greenFill);

        int left3 = left2 + strokeWidth;
        int top3 = top2 + strokeWidth;
        int right3 = right2 - strokeWidth;
        int bottom3 = bottom2 - strokeWidth;

        cx = (left3 + right3) / 2;
        cy = (top3 + bottom3) / 2;
        radius = (right3 - left3) / 2;

        RectF rectF3 = new RectF(left3, top3, right3, bottom3);
        x = cx + radius * Math.cos(getRad(90));
        y = cy - radius * Math.sin(getRad(90));
        x2 = cx + radius * Math.cos(getRad(350));
        y2 = cy - radius * Math.sin(getRad(350));

        canvas.drawArc(rectF3, -90, 100, false, blue);
        canvas.drawCircle((float)x, (float)y, pointRadius, blueFill);
        canvas.drawCircle((float)x2, (float)y2, pointRadius, blueFill);

    }

    private double getRad(int angle) {
        return angle * Math.PI / 180;
    }
}
