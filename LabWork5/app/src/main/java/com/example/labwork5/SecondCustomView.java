package com.example.labwork5;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class SecondCustomView extends View {

    private Paint paint;
    private Path cloudPath;
    private float scale = 1.0f;

    public SecondCustomView(Context context) {
        super(context);
        init();
    }

    public SecondCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SecondCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);

        cloudPath = new Path();

        startAnimation();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(Color.YELLOW);
        canvas.drawCircle(310, 300, 80, paint);
        drawCloud(canvas, 300, 200, scale);
        drawCloud(canvas, 320, 400, scale);
    }

    private void drawCloud(Canvas canvas, int centerX, int centerY, float scale) {
        canvas.save();
        canvas.translate(centerX, centerY);
        canvas.scale(scale, scale);

        cloudPath.reset();
        cloudPath.addCircle(-60, 0, 50, Path.Direction.CW); // Левый круг
        cloudPath.addCircle(0, 0, 60, Path.Direction.CW);   // Центральный круг
        cloudPath.addCircle(50, 0, 40, Path.Direction.CW);  // Правый круг
        paint.setColor(Color.parseColor("#6699CC"));

        canvas.drawPath(cloudPath, paint);
        canvas.restore();
    }

    private void startAnimation() {
        ValueAnimator animator = ValueAnimator.ofFloat(1.4f, 0.9f);
        animator.setDuration(5000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                scale = (float) animation.getAnimatedValue();
                invalidate();
            }
        });
        animator.start();
    }
}