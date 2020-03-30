package com.example.hw131;

import java.util.ArrayList;

public class Vitals {

    static ArrayList<Vitals> v = new ArrayList<>();

    float weight;
    int steps;

    public Vitals(float weight, int steps) {
        this.weight = weight;
        this.steps = steps;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }
}
