package com.example.ycfelix.myapplication;

public class Model_Test
{
    String date,day,accurecy,perfullmodel,time,emotionname;

    public Model_Test() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getAccurecy() {
        return accurecy;
    }

    public void setAccurecy(String accurecy) {
        this.accurecy = accurecy;
    }

    public String getPerfullmodel() {
        return perfullmodel;
    }

    public void setPerfullmodel(String perfullmodel) {
        this.perfullmodel = perfullmodel;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEmotionname() {
        return emotionname;
    }

    public void setEmotionname(String emotionname) {
        this.emotionname = emotionname;
    }

    public Model_Test(String date, String day, String accurecy, String perfullmodel, String time, String emotionname) {
        this.date = date;
        this.day = day;
        this.accurecy = accurecy;
        this.perfullmodel = perfullmodel;
        this.time = time;
        this.emotionname = emotionname;
    }
}
