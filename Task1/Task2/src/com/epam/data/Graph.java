package com.epam.data;

/**
 * Created by Andrei_Lysko on 9/20/2016.
 */
public class Graph {
    private double yPositive;
    private double yNegative;
    private double xWidthTop;
    private double xWidhtBottom;

    public Graph() {
        this.yPositive = 0.0;
        this.yNegative = 0.0;
        this.xWidthTop = 0.0;
        this.xWidhtBottom = 0.0;
    }

    public double getyPositive() {
        return yPositive;
    }

    public void setyPositive(double yPositive) {
        this.yPositive = yPositive;
    }

    public double getyNegative() {
        return yNegative;
    }

    public void setyNegative(double yNegative) {
        this.yNegative = yNegative;
    }

    public double getxWidthTop() {
        return xWidthTop;
    }

    public void setxWidthTop(double xWidthTop) {
        this.xWidthTop = xWidthTop;
    }

    public double getxWidhtBottom() {
        return xWidhtBottom;
    }

    public void setxWidhtBottom(double xWidhtBottom) {
        this.xWidhtBottom = xWidhtBottom;
    }

    public Graph(double yPos, double yNeg, double xTop, double xBottom) {   //Drawing graph with Y positive and negative height and X width
        if (yPos >= 0) {                                                     //Check for valid yPositive input
            this.yPositive = yPos;
        } else {
            System.out.println("Y positive must be >= 0");
            System.exit(99);                                                 //Err code for incorrect input
        }

        if (yNeg <= 0) {                                                     //Check for valid yNegative input
            this.yNegative = yNeg;
        } else {
            System.out.println("Y negative must be <= 0");
            System.exit(99);                                                 //Err code for incorrect input
        }

        if (xTop >= 0) {                                                     //Check for valid xTop width input
            this.xWidthTop = xTop;
        } else {
            System.out.println("X positive width must be >= 0");
            System.exit(99);                                                 //Err code for incorrect input
        }

        if (xBottom >= 0) {                                                  //Check for valid xBottom width input
            this.xWidhtBottom = xBottom;
        } else {
            System.out.println("X negative width must be >= 0");
            System.exit(99);                                                 //Err code for incorrect input
        }
    }


}
