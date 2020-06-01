package cz.vondr.pact.consumer

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class LibraryTest {
    @Test
    fun testSomeLibraryMethod() {
        val classUnderTest = Library()
        Assertions.assertTrue(classUnderTest.someLibraryMethod(), "someLibraryMethod should return 'true'")
    }
}
