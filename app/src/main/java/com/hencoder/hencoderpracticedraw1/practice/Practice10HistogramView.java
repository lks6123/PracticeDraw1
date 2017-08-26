package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.HistogramBean;

import java.util.ArrayList;

public class Practice10HistogramView extends View {

    private Paint mPaint;
    private Paint mTextPain;
    private float[] mLines;
    private int mHeight;
    private int mWidth;
    private float mRealHeight;
    private float mRealWidth;
    private int mMaxRectHeight;
    private ArrayList<HistogramBean> mData;
    private float startX;
    private float startY;
    public Practice10HistogramView(Context context) {
        this(context, null);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        mPaint = new Paint();
        mTextPain = new Paint();
        mPaint.setColor(Color.GREEN);
        mTextPain.setColor(Color.WHITE);
        mTextPain.setTextSize(20);
        mTextPain.setTextAlign(Paint.Align.CENTER);
        mPaint.setAntiAlias(true);
        mHeight = getHeight();
        mWidth = getWidth();
        mLines = new float[8];
        setData(null);
        mMaxRectHeight = getMaxRectHeight();
//        Log.d("高度=",String.valueOf(mHeight));
//        Log.d("宽度=",String.valueOf(mWidth));

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mHeight = getHeight();
        mWidth = getWidth();
        setCoordinateSystemPoint();
        canvas.drawLines(mLines, mTextPain);
        mRealHeight = mHeight * 0.8f;

        mRealWidth = mWidth * 0.8f;
        float averageWidth = (float) (mRealWidth * 0.9 / mData.size());
        float averageHeight = (float) (mRealHeight * 0.9 / mMaxRectHeight);
        for (int i = 0; i < mData.size(); i++) {
            if (i==0){
                canvas.drawRect((float) (startX + i * averageWidth + 0.2 * averageWidth),
                        startY-mData.get(i).getItemCount()*averageHeight,
                        (float)(startX + i * averageWidth + 0.9 * averageWidth),
                        startY,mPaint);
                canvas.drawText(mData.get(i).getItemName(),(float)(startX + i * averageWidth + 0.55 * averageWidth),startY+mTextPain.getTextSize(),mTextPain);
            }else {
            canvas.drawRect((float) (startX + i * averageWidth + 0.1 * averageWidth),
                    startY-mData.get(i).getItemCount()*averageHeight,
                    (float)(startX + i * averageWidth + 0.9 * averageWidth),
                    startY,mPaint);
            canvas.drawText(mData.get(i).getItemName(),(float)(startX + i * averageWidth + 0.5 * averageWidth),startY+mTextPain.getTextSize(),mTextPain);
            }
        }

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
    }

    private void setCoordinateSystemPoint() {
        mLines[0] = mWidth * 0.1f;
        mLines[1] = mHeight * 0.1f;
        mLines[2] = mWidth * 0.1f;
        mLines[3] = mHeight * 0.9f;
        mLines[4] = mWidth * 0.1f;
        mLines[5] = mHeight * 0.9f;
        mLines[6] = mWidth * 0.9f;
        mLines[7] = mHeight * 0.9f;
        startX = mLines[2];
        startY = mLines[3];
    }

    public ArrayList<HistogramBean> getData() {
        return mData;
    }

    public void setData(ArrayList<HistogramBean> data) {
        mData = data;
        if (mData == null) {
            mData = new ArrayList<>();
            mData.add(new HistogramBean("Froyo", 1));
            mData.add(new HistogramBean("GB", 4));
            mData.add(new HistogramBean("IC S", 4));
            mData.add(new HistogramBean("JB", 40));
            mData.add(new HistogramBean("KitKat", 70));
            mData.add(new HistogramBean("L", 80));
            mData.add(new HistogramBean("M", 30));
        }
    }

    public int getMaxRectHeight() {
        int m;
        for (int i = 0; i < mData.size(); i++) {
            m = mData.get(i).getItemCount();
            if (m > mMaxRectHeight) mMaxRectHeight = m;
        }
        Log.d("mMaxRectHeight=",String.valueOf(mMaxRectHeight));
        return mMaxRectHeight;
    }
}
