package com.targetindia.programs;

import java.sql.DriverManager;
import java.util.ResourceBundle;

public class AddNewShipperRecord {
    public static void main(String[] args) throws Exception {

        System.out.println("Drivers currently loaded in JVM:\n");

        var drivers = DriverManager.getDrivers();
        while(drivers.hasMoreElements()) {
            var driver = drivers.nextElement();
            System.out.printf("instance of type %s\n", driver.getClass().getName());
        }

        ResourceBundle rb = ResourceBundle.getBundle("jdbc-config");
        String url = rb.getString("jdbc.driver.url");
        String username = rb.getString("jdbc.driver.username");
        String password = rb.getString("jdbc.driver.password");

        var connection = DriverManager.getConnection(url, username, password);
        System.out.printf("\nGot a connection of type \"%s\".\n", connection.getClass().getName());

        var statement = connection.prepareStatement("insert into shippers values (?, ?, ?)");
        statement.setInt(1, 4);
        statement.setString(2, "Swayamshu");
        statement.setString(3, "(981) 184-8966");
        statement.executeUpdate();

        System.out.println("New shipper data added successfully!");
    }
}