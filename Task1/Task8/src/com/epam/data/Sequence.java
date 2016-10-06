package com.epam.data;

/**
 * Created by Andrei_Lysko on 9/22/2016.
 */
public class Sequence {

    private int size;
    private double data[];

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setData(double[] data) {
        this.data = data;
    }

    public double[] getData() {
        return data;
    }
}
