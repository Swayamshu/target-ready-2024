package com.targetindia.utils;

import com.targetindia.model.Customer;

public class WriterUtil {
    public static void printHeader() {
        System.out.println("Id,Name,City,Email,Phone");
    }
    public static void print(Customer customer) {
        System.out.printf("%d,%s,%s,%s,%s\n",
                customer.getId(),
                customer.getName(),
                customer.getCity(),
                customer.getEmail(),
                customer.getNumber());
    }
}
