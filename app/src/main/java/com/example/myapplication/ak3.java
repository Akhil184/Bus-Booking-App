package com.example.myapplication;

public class ak3 {
    String Destination, From,Date,Time;
    public ak3(String Destination) {
        this.Destination = Destination;
    }
    public ak3(String Destination,String From,String Date,String Time) {
        this.Destination = Destination;
        this.From = From;
        this.Date=Date;
        this.Time=Time;


    }



    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}


