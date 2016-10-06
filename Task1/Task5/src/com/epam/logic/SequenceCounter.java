package com.epam.logic;

/**
 * Created by Andrei_Lysko on 9/21/2016.
 */
public class SequenceCounter {

    private int maxSubsequenceLength;                                           //max length of increasing seq
    private int maxElementIndex;                                                //index of maximal element in subseq
    private int lengthBuffer;                                                   //buffer for length of subseq

    public int getMaxSubsequenceLength() {
        return maxSubsequenceLength;
    }

    public SequenceCounter() {
        this.maxElementIndex = 0;
        this.lengthBuffer = 1;
        this.maxSubsequenceLength = 1;
    }

    public int calculateMaxLength(int[] sequence) {                              //calculating max increasing subseq
        if (sequence.length > 1) {
            int[] subSequence = new int[sequence.length - 1];
            for (int i = 0; i < sequence.length - 1; i++) {                     //generating subseq without 1st element
                if (sequence.length > 1) {
                    subSequence[i] = sequence[i + 1];
                }
            }
            maxSubsequenceSearch(sequence);                                        //searching for max increasing subseq
            calculateMaxLength(subSequence);                                    //recursive call for subseq without 1st
        }
        return this.maxSubsequenceLength;
    }

    public void maxSubsequenceSearch(int[] sequence) {                                //searching for max increasing subseq
        for (int i = 0; i < sequence.length - 1; i++) {
            if (sequence[maxElementIndex] < sequence[i + 1]) {                     //comparing max subseq element with current
                lengthBuffer++;
                maxElementIndex = i + 1;
                if (lengthBuffer > maxSubsequenceLength) {
                    maxSubsequenceLength = lengthBuffer;
                }
            }
            if (i == sequence.length - 2) {                                      //if subseq came to end - delete MAX element
                int[] subSequence = new int[sequence.length - 1];               //and search for another subseq without MAX
                for (int j = 0; j < subSequence.length; j++) {
                    if (j < maxElementIndex) {
                        subSequence[j] = sequence[j];
                    }
                    if (j >= maxElementIndex) {
                        subSequence[j] = sequence[j + 1];
                    }
                }
                maxElementIndex = 0;
                lengthBuffer = 1;
/*                for (int k = 0; k < sequence.length; k++) {
                    System.out.print(sequence[k] + " ");
                }
                System.out.println(); */
                maxSubsequenceSearch(subSequence);
            }
        }
    }

}
