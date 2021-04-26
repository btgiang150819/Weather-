package com.example.wheather;

public class Time {
    private int hour;
    private int status;
    private int temp;

    public Time(int hour, int status, int temp) {
        this.hour = hour;
        this.status = status;
        this.temp = temp;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
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
}
