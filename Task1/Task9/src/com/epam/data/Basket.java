package com.epam.data;

import java.util.ArrayList;

/**
 * Created by Andrei_Lysko on 9/22/2016.
 */
public class Basket {

    private ArrayList<Ball> balls;
    private double weight;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public ArrayList<Ball> getBalls() {
        return balls;
    }

    public void setBalls(ArrayList<Ball> balls) {
        this.balls = balls;
    }
}
