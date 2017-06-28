package com.example.administrator.news.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/18 0018.
 */

public class WeatherDate {


    /**
     * resultcode : 200
     * reason : successed!
     * result : {"sk":{"temp":"31","wind_direction":"西南风","wind_strength":"4级","humidity":"34%","time":"12:43"},"today":{"temperature":"23℃~34℃","weather":"阴转雷阵雨","weather_id":{"fa":"02","fb":"04"},"wind":"南风3-4 级","week":"星期日","city":"北京","date_y":"2017年06月18日","dressing_index":"炎热","dressing_advice":"天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。","uv_index":"弱","comfort_index":"","wash_index":"不宜","travel_index":"较不宜","exercise_index":"较不宜","drying_index":""},"future":[{"temperature":"23℃~34℃","weather":"阴转雷阵雨","weather_id":{"fa":"02","fb":"04"},"wind":"南风3-4 级","week":"星期日","date":"20170618"},{"temperature":"20℃~30℃","weather":"雷阵雨转多云","weather_id":{"fa":"04","fb":"01"},"wind":"南风微风","week":"星期一","date":"20170619"},{"temperature":"22℃~33℃","weather":"多云转阴","weather_id":{"fa":"01","fb":"02"},"wind":"南风微风","week":"星期二","date":"20170620"},{"temperature":"21℃~30℃","weather":"阴转雷阵雨","weather_id":{"fa":"02","fb":"04"},"wind":"南风微风","week":"星期三","date":"20170621"},{"temperature":"20℃~27℃","weather":"雷阵雨转阴","weather_id":{"fa":"04","fb":"02"},"wind":"南风微风","week":"星期四","date":"20170622"},{"temperature":"21℃~30℃","weather":"阴转雷阵雨","weather_id":{"fa":"02","fb":"04"},"wind":"南风微风","week":"星期五","date":"20170623"},{"temperature":"20℃~30℃","weather":"雷阵雨转多云","weather_id":{"fa":"04","fb":"01"},"wind":"南风微风","week":"星期六","date":"20170624"}]}
     * error_code : 0
     */

    public String resultcode;
    public String reason;
    public ResultBean result;
    public int error_code;

    public static WeatherDate objectFromData(String str) {

        return new Gson().fromJson(str, WeatherDate.class);
    }

    public static WeatherDate objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), WeatherDate.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<WeatherDate> arrayWeatherDateFromData(String str) {

        Type listType = new TypeToken<ArrayList<WeatherDate>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<WeatherDate> arrayWeatherDateFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<WeatherDate>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public static class ResultBean {
        /**
         * sk : {"temp":"31","wind_direction":"西南风","wind_strength":"4级","humidity":"34%","time":"12:43"}
         * today : {"temperature":"23℃~34℃","weather":"阴转雷阵雨","weather_id":{"fa":"02","fb":"04"},"wind":"南风3-4 级","week":"星期日","city":"北京","date_y":"2017年06月18日","dressing_index":"炎热","dressing_advice":"天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。","uv_index":"弱","comfort_index":"","wash_index":"不宜","travel_index":"较不宜","exercise_index":"较不宜","drying_index":""}
         * future : [{"temperature":"23℃~34℃","weather":"阴转雷阵雨","weather_id":{"fa":"02","fb":"04"},"wind":"南风3-4 级","week":"星期日","date":"20170618"},{"temperature":"20℃~30℃","weather":"雷阵雨转多云","weather_id":{"fa":"04","fb":"01"},"wind":"南风微风","week":"星期一","date":"20170619"},{"temperature":"22℃~33℃","weather":"多云转阴","weather_id":{"fa":"01","fb":"02"},"wind":"南风微风","week":"星期二","date":"20170620"},{"temperature":"21℃~30℃","weather":"阴转雷阵雨","weather_id":{"fa":"02","fb":"04"},"wind":"南风微风","week":"星期三","date":"20170621"},{"temperature":"20℃~27℃","weather":"雷阵雨转阴","weather_id":{"fa":"04","fb":"02"},"wind":"南风微风","week":"星期四","date":"20170622"},{"temperature":"21℃~30℃","weather":"阴转雷阵雨","weather_id":{"fa":"02","fb":"04"},"wind":"南风微风","week":"星期五","date":"20170623"},{"temperature":"20℃~30℃","weather":"雷阵雨转多云","weather_id":{"fa":"04","fb":"01"},"wind":"南风微风","week":"星期六","date":"20170624"}]
         */

        public SkBean sk;
        public TodayBean today;
        public List<FutureBean> future;

        public static ResultBean objectFromData(String str) {

            return new Gson().fromJson(str, ResultBean.class);
        }

        public static ResultBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), ResultBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<ResultBean> arrayResultBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<ResultBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<ResultBean> arrayResultBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<ResultBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public static class SkBean {
            /**
             * temp : 31
             * wind_direction : 西南风
             * wind_strength : 4级
             * humidity : 34%
             * time : 12:43
             */

            public String temp;
            public String wind_direction;
            public String wind_strength;
            public String humidity;
            public String time;

            public static SkBean objectFromData(String str) {

                return new Gson().fromJson(str, SkBean.class);
            }

            public static SkBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), SkBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<SkBean> arraySkBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<SkBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<SkBean> arraySkBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<SkBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }
        }

        public static class TodayBean {
            /**
             * temperature : 23℃~34℃
             * weather : 阴转雷阵雨
             * weather_id : {"fa":"02","fb":"04"}
             * wind : 南风3-4 级
             * week : 星期日
             * city : 北京
             * date_y : 2017年06月18日
             * dressing_index : 炎热
             * dressing_advice : 天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。
             * uv_index : 弱
             * comfort_index :
             * wash_index : 不宜
             * travel_index : 较不宜
             * exercise_index : 较不宜
             * drying_index :
             */

            public String temperature;
            public String weather;
            public WeatherIdBean weather_id;
            public String wind;
            public String week;
            public String city;
            public String date_y;
            public String dressing_index;
            public String dressing_advice;
            public String uv_index;
            public String comfort_index;
            public String wash_index;
            public String travel_index;
            public String exercise_index;
            public String drying_index;

            public static TodayBean objectFromData(String str) {

                return new Gson().fromJson(str, TodayBean.class);
            }

            public static TodayBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), TodayBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<TodayBean> arrayTodayBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<TodayBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<TodayBean> arrayTodayBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<TodayBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public static class WeatherIdBean {
                /**
                 * fa : 02
                 * fb : 04
                 */

                public String fa;
                public String fb;

                public static WeatherIdBean objectFromData(String str) {

                    return new Gson().fromJson(str, WeatherIdBean.class);
                }

                public static WeatherIdBean objectFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), WeatherIdBean.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }

                public static List<WeatherIdBean> arrayWeatherIdBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<WeatherIdBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public static List<WeatherIdBean> arrayWeatherIdBeanFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);
                        Type listType = new TypeToken<ArrayList<WeatherIdBean>>() {
                        }.getType();

                        return new Gson().fromJson(jsonObject.getString(str), listType);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return new ArrayList();


                }
            }
        }

        public static class FutureBean {
            /**
             * temperature : 23℃~34℃
             * weather : 阴转雷阵雨
             * weather_id : {"fa":"02","fb":"04"}
             * wind : 南风3-4 级
             * week : 星期日
             * date : 20170618
             */

            public String temperature;
            public String weather;
            public TodayBean.WeatherIdBean weather_id;
            public String wind;
            public String week;
            public String date;

            public static FutureBean objectFromData(String str) {

                return new Gson().fromJson(str, FutureBean.class);
            }

            public static FutureBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), FutureBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<FutureBean> arrayFutureBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<FutureBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<FutureBean> arrayFutureBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<FutureBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }
        }
    }
}
