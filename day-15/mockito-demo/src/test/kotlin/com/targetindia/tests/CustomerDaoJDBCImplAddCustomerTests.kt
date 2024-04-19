package com.targetindia.tests

import com.targetindia.dao.CustomerDaoJDBCImpl
import com.targetindia.model.Customer
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.doAnswer
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.SQLException
import javax.sql.DataSource

@ExtendWith(MockitoExtension::class)
class CustomerDaoJDBCImplAddCustomerTests {
    @Mock
    lateinit var dataSource: DataSource
    @Mock
    lateinit var conn: Connection
    @Mock
    lateinit var stmt: PreparedStatement
    @InjectMocks
    lateinit var dao: CustomerDaoJDBCImpl

    @Test
    fun testAddCustomerWithNullId() {

        val c = Customer()
        c.id = null
        c.name = "Swayamshu"
        c.email = "swayamshu2k@gmail.com"
        c.city = "Delhi"

        Assertions.assertThrows(RuntimeException::class.java) {
            dao.addCustomer(c)
        }
    }

    @Test
    fun testAddCustomerWithEmptyName() {

        val c = Customer()
        c.id = 13455
        c.name = "   "
        c.email = "swayamshu2k@gmail.com"
        c.city = "Delhi"

        Assertions.assertThrows(RuntimeException::class.java) {
            dao.addCustomer(c)
        }
    }

    @Test
    fun testAddCustomerWithDuplicateEmail() {

        val c = Customer()
        c.id = 123
        c.name = "Swayamshu"
        c.email = "swayamshu2k@gmail.com"
        c.city = "Delhi"

        val sql: String = "insert into customer values (?, ?, ?, ?)"
        `when`(dataSource.connection).thenReturn(conn)
        `when`(conn.prepareStatement(sql)).thenReturn(stmt)
        `when`(stmt.executeUpdate()).thenThrow(SQLException("Duplicate Email!"))

        try {
            dao.addCustomer(c)
        } catch (e: RuntimeException) {
            Assertions.assertEquals("Duplicate Email!", e.message)
        }
    }
}