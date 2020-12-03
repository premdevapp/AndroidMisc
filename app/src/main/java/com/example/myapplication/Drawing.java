package com.example.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class Drawing extends View {

    private Paint brush, brush2;
    private LinearGradient linearGradient;
    private RadialGradient radialGradient;
    private SweepGradient sweepGradient;
    private Bitmap bitmap;

    public Drawing(Context context) {
        super(context);
        init();
    }



    public void init(){
        brush = new Paint(Paint.ANTI_ALIAS_FLAG);
        brush.setColor(Color.parseColor("red"));

        brush2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        brush2.setStrokeWidth(5f);
        brush2.setColor(Color.parseColor("red"));

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.prem);

       // linearGradient = new LinearGradient(0, 0, 200, 200, Color.WHITE, Color.BLACK, Shader.TileMode.REPEAT);
        //brush.setShader(linearGradient);

       // radialGradient = new RadialGradient(0, 0, 20, Color.GREEN, Color.BLUE, Shader.TileMode.REPEAT);
        //brush.setShader(radialGradient);

        sweepGradient = new SweepGradient(0f,50f, Color.GREEN, Color.BLACK);
        brush.setShader(sweepGradient);
    }

    @Override
    protected void onDraw(Canvas canvas) {



        canvas.drawCircle((getWidth() >> 1), (getHeight() >> 1), 320f, brush);

        canvas.drawLine(50, (getHeight() >> 1)+120, getMeasuredWidth()-50, (getMeasuredHeight()>>1)-120, brush2);

        canvas.drawBitmap( bitmap, (getWidth() >> 1) - (bitmap.getWidth()>>1), (getHeight() >> 1) -(bitmap.getHeight()>>1), null);

        canvas.save();

        super.onDraw(canvas);

    }

    /*public Drawing(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Drawing(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Drawing(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }*/
}
