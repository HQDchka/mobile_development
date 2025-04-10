package com.example.labwork5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class FirstCustomView extends View {

    private Paint paint;

    public FirstCustomView(Context context) {
        super(context);
        init();
    }

    public FirstCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FirstCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Тело Вупсеня 🐛
        int bodyRadius = 150; // Размер кругов

        int bodyX1 = 200;
        int bodyY1 = 400;

        int bodyX2 = 300;
        int bodyY2 = 500;

        int bodyX3 = 400;
        int bodyY3 = 600;

        paint.setColor(Color.RED);
        canvas.drawCircle(bodyX1, bodyY1, bodyRadius, paint);

        paint.setColor(Color.rgb(255, 165, 0));
        canvas.drawCircle(bodyX2, bodyY2, bodyRadius, paint);

        paint.setColor(Color.YELLOW);
        canvas.drawCircle(bodyX3, bodyY3, bodyRadius, paint);

        // ГОЛОВА Вупсеня
        int headRadius = 120;
        int headX = 350;
        int headY = 700;

        paint.setColor(Color.GREEN);
        canvas.drawCircle(headX, headY, headRadius, paint);

        // Глаза Вупсеня
        int eyeRadius = 12;
        int eyeX1 = headX - 60;
        int eyeY1 = headY - 40;

        int eyeX2 = headX + 20;
        int eyeY2 = headY - 40;

        paint.setColor(Color.BLACK);
        canvas.drawCircle(eyeX1, eyeY1, eyeRadius, paint);
        canvas.drawCircle(eyeX2, eyeY2, eyeRadius, paint);

        // Антеннки
        int antennaLength = 100; // Длина антенн
        int antennaBallRadius = 25; // Радиус шариков на концах антенн

        // Левая антеннка
        int leftAntennaStartX = headX - 10;
        int leftAntennaStartY = headY - headRadius;
        int leftAntennaEndX = leftAntennaStartX - 50;
        int leftAntennaEndY = leftAntennaStartY - antennaLength;

        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(5);
        canvas.drawLine(leftAntennaStartX, leftAntennaStartY, leftAntennaEndX, leftAntennaEndY, paint);

        canvas.drawCircle(leftAntennaEndX, leftAntennaEndY, antennaBallRadius, paint);

        // Правая антеннка
        int rightAntennaStartX = headX + 30;
        int rightAntennaStartY = headY - headRadius;
        int rightAntennaEndX = rightAntennaStartX + 50;
        int rightAntennaEndY = rightAntennaStartY - antennaLength;

        paint.setColor(Color.GREEN);
        canvas.drawLine(rightAntennaStartX, rightAntennaStartY, rightAntennaEndX, rightAntennaEndY, paint);

        canvas.drawCircle(rightAntennaEndX, rightAntennaEndY, antennaBallRadius, paint);

        // Рисуем рот 😃
        int mouthX1 = headX - 70;
        int mouthX2 = headX + 30;
        int mouthY = headY + 40;

        paint.setColor(Color.BLACK);
        canvas.drawLine(mouthX1, mouthY, mouthX2, mouthY, paint);
    }
}