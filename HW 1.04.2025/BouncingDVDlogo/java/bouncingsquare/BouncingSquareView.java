package com.example.bouncingsquare;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.util.Random;

public class BouncingSquareView extends SurfaceView implements SurfaceHolder.Callback {
    private SquareThread thread;
    private int x = 200, y = 200;
    private int dx = 35, dy = 35;
    private int size = 200;
    private int screenWidth, screenHeight;
    private Paint paint;
    private Random random;

    public BouncingSquareView(Context context) {
        super(context);
        getHolder().addCallback(this);
        paint = new Paint();
        random = new Random();
        paint.setColor(randomColor());
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        screenWidth = getWidth();
        screenHeight = getHeight();
        thread = new SquareThread(holder);
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        screenWidth = width;
        screenHeight = height;
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        thread.setRunning(false);
        while (retry) {
            try {
                thread.join();
                retry = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class SquareThread extends Thread {
        private SurfaceHolder holder;
        private boolean running;

        public SquareThread(SurfaceHolder holder) {
            this.holder = holder;
        }

        public void setRunning(boolean running) {
            this.running = running;
        }

        @Override
        public void run() {
            while (running) {
                Canvas canvas = null;
                try {
                    canvas = holder.lockCanvas();
                    synchronized (holder) {
                        update();
                        drawCanvas(canvas);
                    }
                } finally {
                    if (canvas != null) {
                        holder.unlockCanvasAndPost(canvas);
                    }
                }
                try {
                    Thread.sleep(16);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void update() {
        x += dx;
        y += dy;
        if (x <= 0 || x + size >= screenWidth) {
            dx = -dx;
            paint.setColor(randomColor());
        }
        if (y <= 0 || y + size >= screenHeight) {
            dy = -dy;
            paint.setColor(randomColor());
        }
    }

    private void drawCanvas(Canvas canvas) {
        if (canvas != null) {
            canvas.drawColor(Color.BLACK);
            canvas.drawRect(x, y, x + size, y + size, paint);
        }
    }

    private int randomColor() {
        return Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }
}
