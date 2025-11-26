package com.example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTest {

    private static Calculator calc;

    @BeforeAll
    static void setup() {
        calc = new Calculator();
        System.out.println("🧪 Starting Calculator tests...");
    }

    @Test
    @Order(1)
    void testAdd() {
        assertEquals(5, calc.add(2, 3), "2 + 3 should equal 5");
    }

    @Test
    @Order(2)
    void testSubtract() {
        assertEquals(4, calc.subtract(6, 2), "6 - 2 should equal 4");
    }

    @Test
    @Order(3)
    void testMultiply() {
        assertAll("Multiplication results",
            () -> assertEquals(6, calc.multiply(2, 3), "2 * 3 = 6"),
            () -> assertNotEquals(5, calc.multiply(2, 3), "Shouldn't be 5")
        );
    }

    @AfterAll
    static void teardown() {
        System.out.println("✅ Calculator tests completed.");
    }
}
