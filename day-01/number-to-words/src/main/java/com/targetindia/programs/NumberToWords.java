package com.targetindia.programs;

public class NumberToWords {

    private static final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] ONES = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    private static final int CRORE = 10000000;
    private static final int LAKH = 100000;
    private static final int THOUSAND = 1000;
    private static final int HUNDRED = 100;
    private static final int TEN = 10;

    public static boolean isValid(int number) {
        return (1 <= number) && (999999999 <= number);
    }

    public static String inWords(int number) {
        StringBuilder sb = new StringBuilder();

        if(number >= CRORE) {
            sb.append(inWords(number / CRORE)).append(" Crore ");
            number %= CRORE;
        }
        if(number >= LAKH) {
            sb.append(inWords(number / LAKH)).append(" Lakh ");
            number %= LAKH;
        }
        if(number >= THOUSAND) {
            sb.append(inWords(number / THOUSAND)).append(" Thousand ");
            number %= THOUSAND;
        }
        if(number >= HUNDRED) {
            sb.append(inWords(number / HUNDRED)).append(" Hundred ");
            number %= HUNDRED;
        }
        if(number >= 20) {
            sb.append(TENS[number / TEN]).append(" ").append(ONES[number % TEN]);
        } else {
            sb.append(ONES[number]);
        }

        return sb.toString().trim();
    }
}
