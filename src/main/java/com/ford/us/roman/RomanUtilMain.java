package com.ford.us.roman;

import com.ford.us.roman.util.Roman;

public class RomanUtilMain {

    public static void main(String[] args) {

        if (args.length!=1)
        {
            System.out.print("Pls pass roman String to convert to Integer! example XXI ");
        }

        System.out.printf("The given roman: %s Integer value:  %d ", args[0],Roman.toInteger(args[0]));

    }
}
