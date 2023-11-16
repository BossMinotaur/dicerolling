package edu.guilford;

import java.util.Arrays;
import java.util.Random;

public class DiceRolling {
    public static void main(String[] args) {
        // We need a Random object when we roll dice
        Random rand = new Random();
        // Let's also define how many dice we have and how many faces each die has
        final int NDICE = 1000;
        final int NFACES = 100;
        // *Final* means that the program cannot change the value
        // Use that for constants, and use identifiers with all capital letters
        
        // Declare and create an array of dice values
        int[] dieValues = new int[NDICE];

        // but now we want random values for each die; use a counting loop
        // This is another way of initializing values in an array using an algorithm
        int i = 0;
        while (i < NDICE) { // While index is an allowed value
            dieValues[i] = rand.nextInt(NFACES) + 1;
            i++;
        }

        // Let's see the results using the Java utility class Arrays
        System.out.println(Arrays.toString(dieValues));

        // Find the maximum value in the array
        // Set the max value to the first value in the array
        int maxValue = dieValues[0];

        // Loop over each element in the array
        
        // If the value of that element is larger, then set the max value 
        // to that larger value; use a for-each loop
        for (int value : dieValues) { 
            if (value > maxValue) {
                maxValue = value;
            }
        }
        System.out.println("The maximum value is " + maxValue);
        // When the loop is done, print out the result

        // Build a histogram
        final int NBINS = 10;
        // We need a count array with that number of bins
        int[] count = new int[NBINS];
        // We need to know how big each bin is
        int binSize = NFACES / NBINS;
        // This works well if NBINS evenly divides NFACES

        // Use a for-each loop to look at each die value and assign it to the appropriate bin
        for (int value : dieValues) {
            int bin = (value - 1) / binSize; // This is the bin the value goes in
            count[bin]++;
        }

        System.out.println("Histogram: " + Arrays.toString(count));
    }
}