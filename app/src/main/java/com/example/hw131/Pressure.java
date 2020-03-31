package com.example.hw131;

import java.util.ArrayList;

public class Pressure {

    static ArrayList<Pressure> p = new ArrayList<>();

    int upper;
    int lower;
    int pulse;
    boolean tachycardia;
    String date;

    public Pressure(int upper, int lower, int pulse, boolean tachycardia, String date) {
        this.upper = upper;
        this.lower = lower;
        this.pulse = pulse;
        this.tachycardia = tachycardia;
        this.date = date;
    }

    public int getUpper() {
        return upper;
    }

    public void setUpper(int upper) {
        this.upper = upper;
    }

    public int getLower() {
        return lower;
    }

    public void setLower(int lower) {
        this.lower = lower;
    }

    public int getPulse() {
        return pulse;
    }

    public void setPulse(int pulse) {
        this.pulse = pulse;
    }

    public boolean isTachycardia() {
        return tachycardia;
    }

    public void setTachycardia(boolean tachycardia) {
        this.tachycardia = tachycardia;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
