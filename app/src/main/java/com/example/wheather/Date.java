package com.example.wheather;

public class Date {
    private  String weekday;
    private  String date;
    private String month;
    private int status;
    private  int temp;
    private int humidity;

    public Date(String weekday, String date, String month, int status, int temp, int humidity) {
        this.weekday = weekday;
        this.date = date;
        this.month = month;
        this.status = status;
        this.temp = temp;
        this.humidity = humidity;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
}
