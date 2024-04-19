package com.targetindia.dao

import com.targetindia.model.Customer
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.SQLException
import javax.sql.DataSource

class CustomerDaoJDBCImpl {
    private lateinit var dataSource: DataSource;

    public fun addCustomer(customer: Customer) {
        if(
            customer.id == null ||
            customer.name == null ||
            customer.name!!.isBlank() ||
            customer.email == null ||
            customer.email!!.isBlank()
        ) {
            throw RuntimeException("id/name/email are mandatory fields")
        }

        val sql: String = "insert into customer values (?, ?, ?, ?)"

        try {
            val conn: Connection = dataSource.connection
            val stmt: PreparedStatement = conn.prepareStatement(sql)

            stmt.setInt(1, customer.id!!)
            stmt.setString(2, customer.name)
            stmt.setString(3, customer.email)
            stmt.setString(4, customer.city)

        } catch (e: SQLException) {
            throw RuntimeException(e)
        }
    }
}