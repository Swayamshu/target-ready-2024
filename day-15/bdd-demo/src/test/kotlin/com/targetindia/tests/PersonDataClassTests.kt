package com.targetindia.tests

import com.targetindia.com.targetindia.Person
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PersonDataClassTests {

    @Test
    fun `Person data class properties tested`() {
        val p1 = Person("John Doe", 14)
        assertEquals("John Doe", p1.name)
        assertEquals(14, p1.age)
    }
}