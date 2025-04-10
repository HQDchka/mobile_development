package com.example.labwork5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class FourthCustomView extends View {

    private Paint paint;

    public FourthCustomView(Context context) {
        super(context);
        init();
    }

    public FourthCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FourthCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
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

        int width = getWidth();
        int height = getHeight();

        paint.setColor(Color.BLACK);
        canvas.drawRect(0, 0, width, height, paint);

        int squareSize = Math.min(width, height) / 4;
        int squareX = (width - squareSize) / 2;
        int squareY = (height - squareSize) / 2;
        paint.setColor(Color.BLUE);
        canvas.drawRect(squareX, squareY, squareX + squareSize, squareY + squareSize, paint);
    }
}