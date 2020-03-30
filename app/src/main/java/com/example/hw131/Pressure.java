package com.example.hw131;

import java.util.ArrayList;

public class Pressure {

    static ArrayList<Pressure> p = new ArrayList<>();

    String upper;
    String lower;
    String pulse;
    boolean tachycardia;
    String date;

    public Pressure(String upper, String lower, String pulse, boolean tachycardia, String date) {
        this.upper = upper;
        this.lower = lower;
        this.pulse = pulse;
        this.tachycardia = tachycardia;
        this.date = date;
    }

    public String getUpper() {
        return upper;
    }

    public void setUpper(String upper) {
        this.upper = upper;
    }

    public String getLower() {
        return lower;
    }

    public void setLower(String lower) {
        this.lower = lower;
    }

    public String getPulse() {
        return pulse;
    }

    public void setPulse(String pulse) {
        this.pulse = pulse;
    }
}
