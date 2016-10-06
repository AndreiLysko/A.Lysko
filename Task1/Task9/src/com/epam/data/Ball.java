package com.epam.data;

/**
 * Created by Andrei_Lysko on 9/22/2016.
 */
public class Ball {
    private double weight;
    private Color color;

    public Ball() {
    }

    public Ball(double weight, Color color) {
        this.weight = weight;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
