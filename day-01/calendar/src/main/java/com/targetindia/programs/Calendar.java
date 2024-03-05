package com.targetindia.programs;

public class Calendar {
    static int getStartingWeekday(int month, int year) {
        int[] index = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 };

        if (month < 3) {
            year--;
        }

        return (year + year / 4 - year / 100 + year / 400 + index[month - 1] + 1) % 7;
    }

    static boolean isLeapYear(int year) {
        return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
    }

    static boolean isValidateDate(int month, int year) {
        boolean validDate = true;

        if(year == 0) {
            System.out.println("Error: Please enter a valid year(year >= 0)!");
            validDate = false;
        }

        if(month < 1 || month > 12) {
            System.out.println("Error: Please enter a valid month(1 <= month <= 12)!");
            validDate = false;
        }

        return validDate;
    }

    public static void printCalendar(int month, int year) {
        if(!isValidateDate(month, year)) {
            return;
        }

        String[] monthName = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        int startingWeekdayIndex = getStartingWeekday(month, year);
        int k;

        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        monthDays[1] = isLeapYear(year) ? 29 : 28;

        int maxDays = monthDays[month - 1];

        System.out.printf("\nCalendar for (%s, %d) is: \n", monthName[month - 1], year);
        System.out.println(" Su Mo Tu We Th Fr Sa");

        for(k = 0; k < startingWeekdayIndex; k++) {
            System.out.print("   ");
        }

        for(int day = 1; day <= maxDays; day++) {
            System.out.printf("%3d", day);

            if(++k > 6) {
                k = 0;
                System.out.print("\n");
            }
        }

        System.out.print("\n");
    }
}
