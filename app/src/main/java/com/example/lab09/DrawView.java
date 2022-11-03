package com.example.lab09;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DrawView extends View { //Maybe have leaves falling from the trees and you can control a character to move them around?
    Sprite sprite;
    private Tree tree1;
    private Tree tree2;
    private Tree tree3;
    private Tree tree4;
    private Path path;
    private Point[] points;
    private int height;
    private int width;
    private int delay = 5;
    private int count;
    private ArrayList<Leaf> leaves;
    Paint pathPaint;

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        sprite = new Sprite();
        tree2 = new Tree(700,900,100*9/10,300*9/10,25*9/10, 150*9/10);
        tree1 = new Tree(200,1200,100,300,25, 150);
        tree3 = new Tree(400,500,100*7/10,300*7/10,25*7/10, 150*7/10);
        tree4 = new Tree(800,100,100*4/10,300*4/10,25*4/10, 150*4/10);
        pathPaint = new Paint();
//        pathPaint.setColor(Color.rgb(240,222,192));
        path = new Path();
        count = 0;
        leaves = new ArrayList<Leaf>();
    }

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        sprite.update();
//        sprite.draw(canvas);
        height = getHeight();
        width = getWidth();
        pathPaint.setShader(new LinearGradient(width/3, height, width/3+150, 0, Color.rgb(240,222,192), Color.rgb(155,118,83), Shader.TileMode.MIRROR));
        points = new Point[]{new Point(width/3+150,height),new Point(2*width/3+50,0),new Point(2*width/3,0)};
        path.moveTo(width/3,height);
        for (Point point: points) {
            path.lineTo(point.x,point.y);
        }
        canvas.drawPath(path,pathPaint);
        if (count >= delay) {
            Leaf leaf4 = tree4.update();
            Leaf leaf3 = tree3.update();
            Leaf leaf2 = tree2.update();
            Leaf leaf1 = tree1.update();
            count = 0;
            if (leaf4 != null) {
                leaves.add(leaf4);
                if (leaves.size() > 500) {
                    leaves.remove(0);
                }
            }
            if (leaf3 != null) {
                leaves.add(leaf3);
                if (leaves.size() > 500) {
                    leaves.remove(0);
                }
            }
            if (leaf2 != null) {
                leaves.add(leaf2);
                if (leaves.size() > 500) {
                    leaves.remove(0);
                }
            }
            if (leaf1 != null) {
                leaves.add(leaf1);
                if (leaves.size() > 500) {
                    leaves.remove(0);
                }
            }
        }
        tree4.drawTree(canvas);
        tree3.drawTree(canvas);
        tree2.drawTree(canvas);
        tree1.drawTree(canvas);
        for (Leaf leaf:leaves) {
            leaf.update();
            leaf.draw(canvas);
        }
        count++;
        invalidate();
    }
}
