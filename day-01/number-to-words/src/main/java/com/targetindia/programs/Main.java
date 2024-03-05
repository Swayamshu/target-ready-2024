package com.targetindia.programs;

import com.targetindia.utils.KeyboardUtil;

public class Main {
    public static void main(String[] args) {

        int number = KeyboardUtil.getInt("Please enter a number between 1 and 99,99,99,999: ");

        if(!NumberToWords.isValid(number)) {
            System.out.println("Please enter a number between 1 and 99,99,99,999 only.");
            return;
        }

        String result = NumberToWords.inWords(number);
        System.out.println(result);
    }
}