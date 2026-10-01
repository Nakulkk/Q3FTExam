import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorAppTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Test Addition of Two Positive Numbers")
    void testAdd() {
        int result = calculator.add(5, 3);
        assertEquals(8, result, "5 + 3 should equal 8");
    }

    @Test
    @DisplayName("Test Subtraction Resulting in a Negative Value")
    void testSubtract() {
        int result = calculator.subtract(3, 10);
        assertEquals(-7, result, "3 - 10 should equal -7");
    }

    @Test
    @DisplayName("Test Multiplication with Zero")
    void testMultiplyByZero() {
        int result = calculator.multiply(7, 0);
        assertEquals(0, result, "Multiplying any number by 0 should equal 0");
    }

    @Test
    @DisplayName("Test Division of Two Numbers")
    void testDivide() {
        double result = calculator.divide(10, 4);
        assertEquals(2.5, result, 0.0001, "10 / 4 should equal 2.5");
    }

    @Test
    @DisplayName("Test Division by Zero Throws ArithmeticException")
    void testDivideByZero() {
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> calculator.divide(10, 0),
                "Division by zero should throw an ArithmeticException"
        );
        assertEquals("/ by zero", exception.getMessage());
    }
}
