package com.targetindia.programs;

import com.targetindia.exceptions.*;
import com.targetindia.model.Database;
import com.targetindia.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final String ADD_CUSTOMER_COMMAND = "add";
    private static final String SEARCH_CUSTOMER_COMMAND = "search";
    private static final String DELETE_CUSTOMER_COMMAND = "delete";
    private static final String UPDATE_CUSTOMER_COMMAND = "update";
    private static final String VIEW_ALL_CUSTOMERS_COMMAND = "view";
    private static final String EXIT_COMMAND = "exit";

    public static void main(String[] args) {
        Database DB = new Database();
        processCommands(DB);
    }

    private static void processCommands(Database DB) {
        String input = KeyboardUtil.getString("> ");

        while(!input.equals(EXIT_COMMAND)) {

            String[] command = input.split(" ", 2);

            try {
                switch(command[0]) {

                    case ADD_CUSTOMER_COMMAND:
                        DB.processAddCustomer(command[1]);
                        break;

                    case VIEW_ALL_CUSTOMERS_COMMAND:
                        DB.printData();
                        break;

                    case SEARCH_CUSTOMER_COMMAND:
                        DB.printData(command[1]);
                        break;

                    case DELETE_CUSTOMER_COMMAND:
                        DB.processDeleteCustomer(Integer.parseInt(command[1]));
                        break;

                    case UPDATE_CUSTOMER_COMMAND:
                        DB.processUpdateCustomer(command[1]);
                        break;

                    default:
                        log.warn("Please enter a valid input or enter \"exit\" to terminate the program.");
                        break;
                }
            } catch (InputFormatException |
                     InvalidIdException |
                     InvalidNumberException |
                     InvalidEmailException |
                     InvalidCityException |
                     InvalidNameException e) {
                log.warn(e.getMessage());
            }

            input = KeyboardUtil.getString("> ");
        }
    }
}