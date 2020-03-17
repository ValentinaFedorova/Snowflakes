package com.example.snowflakes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

public class MyView extends View {

    class Snowflake {
        float x,y,rad,speed;
        public Snowflake(){
            Random r = new Random();
            x = r.nextFloat();
            y = r.nextFloat();
            rad = r.nextFloat()*10;
            speed = r.nextFloat()/130;
        }

        void fall(){
            y+=speed;
            if (y>1){
                Random r = new Random();
                x = r.nextFloat();
                y = y-1;

            }
        }
        void draw(Canvas c, float width, float height){
            p.setColor(Color.WHITE);
            c.drawCircle(x*width,y*height,rad,p);
        }

    }
    Paint p = new Paint();
    //float x = 100, y = 0, radius =100;
    Snowflake[] snowflakes;
    float w, h;


    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        snowflakes = new Snowflake[40];
        // падение снежинок при касании
        for (int i = 0; i < snowflakes.length; i++) {
            snowflakes[i] = new Snowflake();
        }
    }
    public MyView(Context context) {
        super(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        for (int i = 0; i < 40; i++) {
            snowflakes[i].fall();
        }

        invalidate();
        return true;
//        invalidate();
//        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {




        super.onDraw(canvas);
        w = getWidth();
        h = getHeight();
        canvas.drawColor(Color.BLUE);
        canvas.drawRGB(25, 25, 112);
        //p.setColor(Color.parseColor("#FF0000"));
        //canvas.drawCircle(x,y, radius, p);
        for (int i = 0; i < 15; i++) {
            snowflakes[i].draw(canvas,w,h);
        }
    }
}


