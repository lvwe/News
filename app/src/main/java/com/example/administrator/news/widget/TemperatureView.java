package com.example.administrator.news.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.news.bean.PointDate;
import com.example.administrator.news.bean.TempPoint;
import com.example.administrator.news.bean.Temperature;
import com.example.administrator.news.bean.WeatherDate;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/6/13 0013.
 */

public class TemperatureView extends View {
    private static final String TAG = "TemperatureView";

    private ArrayList<Temperature> tempList = new ArrayList<>();
    private ArrayList<TempPoint> temPointsList = new ArrayList<>();
    private Paint mPaint = new Paint();
    private int radio = 10;
    private String url = "http://v.juhe.cn/weather/geo?format=2&key=25833bf64191617c3ab01a9696540f67&lon=116.39277&lat=39.933748";
    private DensityUtil mUtil = new DensityUtil();
    private List<WeatherDate.ResultBean.FutureBean> mFutureBeen = new ArrayList<>();
    private List<String> week = new ArrayList<>();
    private String[] text = {"5", "10", "15", "20", "25", "30", "35", "40", "45", ""};
    private int[] temp = {20, 30, 45, 35, 25, 33, 24};
    private List<PointDate> mPointDates = new ArrayList<>();
    private List<WeatherDate.ResultBean.TodayBean> mTodayBeen = new ArrayList<>();


    public TemperatureView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.d(TAG, "TemperatureView: ");
        initTempList();
        initPointLocation();
        getWeatherDate();
        initWeek();


    }

    private void initWeek() {
        week.add("今天");
        week.add("星期一");
        week.add("星期二");
        week.add("星期三");
        week.add("星期四");
        week.add("星期五");
        week.add("星期六");
    }

    private void getWeatherDate() {
        OkHttpClient client = new OkHttpClient();
        final Request request;
        request = new Request.Builder().url(url).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(getContext(), "获取数据失败", Toast.LENGTH_SHORT).show();
            }


            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                WeatherDate weatherDate = gson.fromJson(response.body().string(), WeatherDate.class);
                mFutureBeen = weatherDate.result.future;
//                mTodayBeen =  weatherDate.result.today;
//                mHandler.sendEmptyMessage(GET_JOKE_DATA);
                Log.d(TAG, "onResponse: ++++++++++++++++" + mFutureBeen.size());

            }
        });
    }

    private void initPointLocation() {
        for (int i = 0; i < tempList.size(); i++) {
            int x = 50 + (i * 50);
            int lowY = (40 - (tempList.get(i).low)) * 10;
            int highY = (40 - (tempList.get(i).hight)) * 10;
            TempPoint tempPoint = new TempPoint(x, lowY, highY);
            temPointsList.add(tempPoint);
        }
    }

    private void initTempList() {
        Temperature t1 = new Temperature(12, 26, new Date(2017, 6, 13));
        Temperature t2 = new Temperature(14, 32, new Date(2017, 6, 13));
        Temperature t3 = new Temperature(16, 25, new Date(2017, 6, 13));
        Temperature t4 = new Temperature(12, 20, new Date(2017, 6, 13));
        Temperature t5 = new Temperature(15, 28, new Date(2017, 6, 13));
        Temperature t6 = new Temperature(13, 26, new Date(2017, 6, 13));
        tempList.add(t1);
        tempList.add(t2);
        tempList.add(t3);
        tempList.add(t4);
        tempList.add(t5);
        tempList.add(t6);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        drawPoints(canvas);
//        drawLines(canvas);
        drawBottomLinews(canvas);
        drawLeftLine(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(10);
        paint.setTextSize(50);

        canvas.drawCircle(0, mUtil.dip2px(getContext(), 300 - (33 * 5 + 40)), radio, mPaint);
        drawText(canvas);
        super.onDraw(canvas);
    }

    private void drawLeftLine(Canvas canvas) {
        int startY = mUtil.dip2px(getContext(), 260);
        int stopY = mUtil.dip2px(getContext(), 20);
        int startX = 50;
        int stopX = 50;
        canvas.drawLine(startX, startY, stopX, stopY, mPaint);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(10);
//        paint.setStyle(Paint.Style.STROKE);
        paint.setTextSize(25);
        int startY2 = mUtil.dip2px(getContext(), 260);
        int stopY2 = mUtil.dip2px(getContext(), 260);
        for (int i = 0; i <= 9; i++) {
            int startX2 = 50;
            int stopX2 = 65;
            canvas.drawLine(startX2, startY2, stopX2, startY2, paint);
            startY2 = startY2 - mUtil.dip2px(getContext(), 25);
            String num = String.valueOf(text[i]);
            canvas.drawText(num, startX - 30, startY2 + 10, paint);
        }

    }

    private void drawBottomLinews(Canvas canvas) {
        int startY = mUtil.dip2px(getContext(), 260);
        int stopY = mUtil.dip2px(getContext(), 260);
        int startX = 50;
        int stopX = 1050;
        canvas.drawLine(startX, startY, stopX, stopY, mPaint);
    }

    private void drawText(Canvas canvas) {
        int floatX = 100;
        int floatY = mUtil.dip2px(getContext(), 280);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(10);
        paint.setTextSize(30);
        for (int i = 0; i < week.size(); i++) {
            canvas.drawText(week.get(i), floatX, floatY, paint);
            floatX = floatX + 140;
        }
    }

    private void drawLines(Canvas canvas) {
        Path lowPath = new Path();
        Path highPath = new Path();
        for (int i = 0; i < temPointsList.size(); i++) {
            TempPoint tp = temPointsList.get(i);
            if (i == 0) {
                lowPath.moveTo(tp.x, tp.lowY);
                highPath.moveTo(tp.x, tp.highY);
            } else {
                lowPath.lineTo(tp.x, tp.lowY);
                highPath.lineTo(tp.x, tp.highY);
            }
        }
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        mPaint.setColor(Color.GREEN);
        canvas.drawPath(highPath, mPaint);
    }

    private void drawPoints(Canvas canvas) {
        int cx = 120;
//        int cy = 0;
        for (int i = 0; i < temp.length; i++) {
            int cy = mUtil.dip2px(getContext(), mUtil.tem2px(temp[i]));
            mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawCircle(cx, cy, radio, mPaint);
            Log.d(TAG, "drawPoints: cx:cy" + cx + ":" + cy);

//            D/TemperatureView: drawPoints: cx:cy120:480
//            D/TemperatureView: drawPoints: cx:cy265:330
//            D/TemperatureView: drawPoints: cx:cy410:105
//            D/TemperatureView: drawPoints: cx:cy555:255
//            D/TemperatureView: drawPoints: cx:cy700:405
//            D/TemperatureView: drawPoints: cx:cy845:285
//            D/TemperatureView: drawPoints: cx:cy990:420
            PointDate p1 = new PointDate(cx, cy);
            mPointDates.add(p1);
            Log.d(TAG, "drawPoints: p1" + mPointDates.size());

            Path path = new Path();

            Paint paint2 = new Paint();
            paint2.setStyle(Paint.Style.FILL_AND_STROKE);
            paint2.setColor(Color.RED);
            paint2.setStrokeWidth(5f);
//            canvas.drawLine(120,480,265,330,paint2);
//            canvas.drawLine(265,330,410,105,paint2);
//            canvas.drawLine(410,105,555,255,paint2);
//            canvas.drawLine(555,255,700,405,paint2);
//            canvas.drawLine(700,405,845,285,paint2);


            cx = cx + 145;

        }
        int stX = 0;
        int stY = 0;
        for (int i = 0; i < mPointDates.size(); i++) {
            if (i + 1 >= 7) {
                return;
            } else {
                stX = mPointDates.get(i).getX();
                int stopX = mPointDates.get(i + 1).getX();
                stY = mPointDates.get(i).getY();
                int stopY = mPointDates.get(i + 1).getY();
                canvas.drawLine(stX, stY, stopX, stopY, mPaint);

            }
            Paint paint2 = new Paint();
//                paint2.setStyle(Paint.Style.FILL_AND_STROKE);
            paint2.setColor(Color.RED);
            paint2.setTextSize(20);
            canvas.drawText(mFutureBeen.get(i).temperature, stX-50, stY + 35, paint2);
        }

        Log.d(TAG, "drawPoints: p111++++" + mPointDates.size());
        Log.d(TAG, "drawPoints: +++++++++++" + mPointDates.toString());
        Log.d(TAG, "drawPoints: 1++++++++" + mPointDates.get(1).getX());
        Log.d(TAG, "drawPoints: 1++++++++" + mPointDates.get(1).getY());
        Log.d(TAG, "drawPoints: 2++++++++" + mPointDates.get(2).getX());
        Log.d(TAG, "drawPoints: 2++++++++" + mPointDates.get(2).getY());
        Log.d(TAG, "drawPoints: 7++++++++" + mPointDates.get(6).getX());
        Log.d(TAG, "drawPoints: 7++++++++" + mPointDates.get(6).getY());

    }
}

class DensityUtil {

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public int tem2px(float tem) {
        return (int) (300 - (tem * 5 + 40));
    }
}

