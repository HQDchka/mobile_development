package com.example.labwork5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class ThirdCustomView extends View {

    private Paint paint;

    public ThirdCustomView(Context context) {
        super(context);
        init();
    }

    public ThirdCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ThirdCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = 1100;
        int height = 3000;

        paint.setColor(Color.GREEN);
        canvas.drawRect(0, height / 2, width, height, paint);

        // Домик
        int houseWidth = 400;
        int houseHeight = 400;
        int houseX = (width - houseWidth) / 2;
        int houseY = height / 2 - houseHeight;
        paint.setColor(Color.rgb(139, 69, 19));
        canvas.drawRect(houseX, houseY, houseX + houseWidth, houseY + houseHeight, paint);

        // Окно
        int windowSize = 125;
        int windowX = houseX + (houseWidth - windowSize) / 2;
        int windowY = houseY + (houseHeight - windowSize) / 2;
        paint.setColor(Color.BLUE);
        canvas.drawRect(windowX, windowY, windowX + windowSize, windowY + windowSize, paint);

        // Крыша
        int roofHeight = 200;
        int roofX1 = houseX;
        int roofY1 = houseY;
        int roofX2 = houseX + houseWidth;
        int roofY2 = houseY;
        int roofX3 = houseX + houseWidth / 2;
        int roofY3 = houseY - roofHeight;
        paint.setColor(Color.RED);
        canvas.drawPath(makeTrianglePath(roofX1, roofY1, roofX2, roofY2, roofX3, roofY3), paint);
    }

    private android.graphics.Path makeTrianglePath(float x1, float y1, float x2, float y2, float x3, float y3) {
        android.graphics.Path path = new android.graphics.Path();
        path.moveTo(x1, y1);
        path.lineTo(x2, y2);
        path.lineTo(x3, y3);
        path.close();
        return path;
    }
}