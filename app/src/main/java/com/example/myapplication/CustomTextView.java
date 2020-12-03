package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.annotation.Nullable;

public class CustomTextView extends androidx.appcompat.widget.AppCompatTextView {

    private Paint textPaint;

    public CustomTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void init(){
        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.parseColor("blue"));
        textPaint.setTextSize(60f);
        textPaint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawText("Hello World",  getMeasuredWidth()>>1, getMeasuredHeight()>>1, textPaint);
        canvas.save();

        super.onDraw(canvas);
    }
}
