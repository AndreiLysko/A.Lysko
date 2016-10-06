package com.epam.logic;

import com.epam.data.Ball;
import com.epam.data.Basket;
import com.epam.data.Color;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Andrei_Lysko on 9/22/2016.
 */
public class Fill {

    private static final int RANDOM_MULTIPLIER = 50;                                // [0;50)

    public static ArrayList<Ball> dropBalls(int count) {
        ArrayList<Ball> balls = new ArrayList<>();
        Random randomizer = new Random();
        for (int i = 0; i < count; i++) {
            Ball randomBall = new Ball();
            randomBall.setWeight(Math.random() * RANDOM_MULTIPLIER);
            int kek = randomizer.nextInt(Color.values().length);
            randomBall.setColor(Color.values()[kek]);
            balls.add(randomBall);
            System.out.println(randomBall.getWeight() + " " + randomBall.getColor());
        }
        return balls;
    }

    public static void basketIn(Basket recycleBin, ArrayList<Ball> balls) {
        recycleBin.setBalls(balls);
    }

    public static double totalWeight(Basket recycleBin) {
        double weight = 0;
        for (Ball ball : recycleBin.getBalls()) {
            weight = weight + ball.getWeight();
        }
        return weight;
    }

    public static int totalBlues(Basket recycleBin) {
        int blueBalls = 0;
        for (Ball ball : recycleBin.getBalls()) {
            if (ball.getColor() == Color.BLUE) {
                blueBalls++;
            }
        }
        return blueBalls;
    }
}
