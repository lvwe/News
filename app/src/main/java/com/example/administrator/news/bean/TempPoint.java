package com.example.administrator.news.bean;

/**
 * Created by Administrator on 2017/6/13 0013.
 */

public class TempPoint {
    public int x;
    public int lowY;
    public int highY;

    public TempPoint(int x, int lowY, int highY) {
        this.highY = highY;
        this.lowY = lowY;
        this.x = x;
    }
}
