package com.example.administrator.news.bean;

import java.util.Date;

/**
 * Created by Administrator on 2017/6/13 0013.
 */

public class Temperature {
    public int low;
    public int hight;
    public Date mDate;

    public Temperature(int low,int high,Date date){
        this.low = low;
        this.hight = high;
        this.mDate = date;
    }
}
