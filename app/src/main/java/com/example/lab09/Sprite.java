package com.example.lab09;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class Sprite extends RectF {
    private int dx,dy,color;
    public Sprite(float left, float top, float right, float bottom, int dx, int dy, int color) {
        super(left, top, right, bottom);
        this.dx = dx;
        this.dy = dy;
        this.color = color;
    }

    public Sprite(float left, float top, float right, float bottom) {
        this(left, top, right, bottom,1,2, Color.MAGENTA);
    }

    public Sprite(int dx, int dy, int color) {
        this(1,1,111,111,dx,dy,color);
    }

    public Sprite() {
        this(2,3,Color.GREEN);
    }
    public void update() {
        offset(dx,dy);
    }
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawCircle(centerX(),centerY(),width()/2,paint);
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
