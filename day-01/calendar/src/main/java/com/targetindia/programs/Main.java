package com.targetindia.programs;

import com.targetindia.utils.KeyboardUtil;

public class Main {
    public static void main(String[] args) {

        int month = KeyboardUtil.getInt("Please enter a month: ");
        int year = KeyboardUtil.getInt("Please enter a year: ");

        Calendar.printCalendar(month, year);
    }
}