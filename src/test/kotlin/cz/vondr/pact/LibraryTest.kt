/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package cz.vondr.pact

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class LibraryTest {
    @Test
    fun testSomeLibraryMethod() {
        val classUnderTest = Library()
        Assertions.assertTrue(classUnderTest.someLibraryMethod(), "someLibraryMethod should return 'true'")
    }
}
