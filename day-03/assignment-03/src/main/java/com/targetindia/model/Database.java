package com.targetindia.model;

import com.targetindia.exceptions.InputFormatException;
import com.targetindia.exceptions.InvalidIdException;
import com.targetindia.utils.WriterUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Database {
    private final List<Customer> DATA = new ArrayList<Customer>();

    public void printData() {
        WriterUtil.printHeader();

        for (Customer customer : DATA) {
            WriterUtil.print(customer);
        }
    }

    public void printData(String city) {
        WriterUtil.printHeader();

        for (Customer customer : DATA) {
            if (Objects.equals(customer.getCity(), city)) {
                WriterUtil.print(customer);
            }
        }
    }

    private void addData(Customer customer) {
        DATA.add(customer);
    }

    private void deleteDataByID(int id) {
        for(Customer customer : DATA) {
            if(Objects.equals(customer.getId(), id)) {
                DATA.remove(customer);
                return;
            }
        }
    }

    private void updateDataByID(int id, Customer customer) {
        for (int i = 0; i < DATA.size(); i++) {
            Customer c = DATA.get(i);
            if (Objects.equals(c.getId(), id)) {
                DATA.set(i, customer);
                return;
            }
        }
    }

    public void processAddCustomer(String command) throws InputFormatException {
        String[] arg = command.split(",");

        if(arg.length != 5) {
            throw new InputFormatException("Please enter all 5 fields.");
        }

        Customer customer = new Customer(Integer.parseInt(arg[0]), arg[1], arg[2], arg[3], arg[4]);
        addData(customer);
    }

    public void processDeleteCustomer(int id) throws InvalidIdException {
        if(id < 0) {
            throw new InvalidIdException("Id must be >= 0.");
        }

        deleteDataByID(id);
    }

    public void processUpdateCustomer(String command) throws InputFormatException {
        String[] input = command.split(" ", 2);
        int id = Integer.parseInt(input[0]);
        String[] arg = input[1].split(",");

        if(arg.length != 5) {
            throw new InputFormatException("Please enter all 5 fields.");
        }

        updateDataByID(id, new Customer(Integer.parseInt(arg[0]), arg[1], arg[2], arg[3], arg[4]));
    }
}
