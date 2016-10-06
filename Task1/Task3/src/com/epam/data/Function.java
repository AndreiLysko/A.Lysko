package com.epam.data;

/**
 * Created by Andrei_Lysko on 9/20/2016.
 */
public class Function {
    private double[] results;

    public double tg(double x){
        return Math.tan(x);
    }

    public void setResults(double[] results) {
        this.results = results;
    }

    public double[] getResults() {
        return results;
    }
}
