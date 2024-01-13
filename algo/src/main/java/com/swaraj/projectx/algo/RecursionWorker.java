package com.swaraj.projectx.algo;

public class RecursionWorker {
    public static void startCountDown(int counter) {
        System.out.println("count-down = " + counter);

        //base case
        if (counter == 0) return;

        //recursive case
        startCountDown(counter - 1);
    }

    /*
    fact(5) = 5 * fact(4)
    fact(4) = 4 * fact(3)
    ....
    fact(1) = 1 // base case
    --> recursive case possible
     */
}
