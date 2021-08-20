package com.example.myapplication;

public class ak2 {
    String Destination, From,Date,Time,price,randomno;
    public ak2(String Destination) {
        this.Destination = Destination;
    }
    public ak2(String Destination,String From,String Date,String Time,String price,String randomno) {
        this.Destination = Destination;
        this.From = From;
        this.Date=Date;
        this.Time=Time;
        this.randomno=randomno;
        this.price=price;

    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRandomno() {
        return randomno;
    }

    public void setRandomno(String randomno) {
        this.randomno = randomno;
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
