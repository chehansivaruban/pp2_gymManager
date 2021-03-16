
package com.company;

import java.io.Serializable;
import java.util.Scanner;

import static java.time.Year.isLeap;

public class Date implements Serializable {
    private int day;
    private int month;
    private int year;


    //constructor
    public Date(int year, int month, int day) {

        this.year = year;
        this.month = month;
        this.day = day;

    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String toString() {
        StringBuilder toString = new StringBuilder();
        toString.append(this.year);
        toString.append("/");
        if (this.month < 10) toString.append("0");
        toString.append(this.month);
        toString.append("/");
        if (this.day < 10) toString.append("0");
        toString.append(this.day);
        return toString.toString();
    }

}


