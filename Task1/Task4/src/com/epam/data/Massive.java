package com.epam.data;


/**
 * Created by Andrei_Lysko on 9/21/2016.
 */
public class Massive {

    private int sizeOfMassive;
    private int massive[];
    private int primeIndexes[];

    public void setSizeOfMassive(int sizeOfMassive) {

        this.sizeOfMassive = sizeOfMassive;
    }

    public int getSizeOfMassive() {
        return this.sizeOfMassive;
    }

    public void setMassive(int[] massive) {
        this.massive = massive;
    }

    public int[] getMassive() {
        return this.massive;
    }

    public void setPrimeIndexes(int[] primeIndexes) {
        this.primeIndexes = primeIndexes;
    }

    public int[] getPrimeIndexes() {
        return primeIndexes;
    }



}
