package com.targetindia.programs;

import com.targetindia.model.Database;
import com.targetindia.utils.KeyboardUtil;

public class Main {
    public static final String EXIT_COMMAND = "exit";

    public static void main(String[] args) {
        Database DB = new Database();
        processCommands(DB);
    }

    public static void processCommands(Database DB) {
        String input = KeyboardUtil.getString("> ");

        while(!input.equals(EXIT_COMMAND)) {

            String[] command = input.split(" ", 2);

            switch(command[0]) {

                case "add":
                    DB.processAddCustomer(command[1]);
                    break;

                case "view":
                    DB.printData();
                    break;

                case "search":
                    DB.printData(command[1]);
                    break;

                case "delete":
                    DB.processDeleteCustomer(Integer.parseInt(command[1]));
                    break;

                case "update":
                    DB.processUpdateCustomer(command[1]);
                    break;

                default:
                    System.out.println("Please enter a valid input or enter \"exit\" to terminate the program.");
                    break;
            }

            input = KeyboardUtil.getString("> ");
        }
    }
}