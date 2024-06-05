import calculator.Calculator;
import calculator.CalculatorException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTests {

    @Test
    public void testSuccessAddition() throws CalculatorException {
        Calculator calculator = new Calculator();
        float a = 12;
        float b = 2;
        calculator.setA(a);
        calculator.setB(b);
        calculator.setOperation(1);
        Assertions.assertEquals(a + b, calculator.getResult());
    }

    @Test
    public void testSuccessSubtraction() throws CalculatorException {
        Calculator calculator = new Calculator();
        float a = 12;
        float b = 2.04F;
        calculator.setA(a);
        calculator.setB(b);
        calculator.setOperation(2);
        Assertions.assertEquals(a - b, calculator.getResult());
    }

    @Test
    public void testSuccessDivision() throws CalculatorException {
        Calculator calculator = new Calculator();
        float a = 12.12F;
        float b = 2.04F;
        calculator.setA(a);
        calculator.setB(b);
        calculator.setOperation(3);
        Assertions.assertEquals(a / b, calculator.getResult());
    }

    @Test
    public void testSuccessMultiplication() throws CalculatorException {
        Calculator calculator = new Calculator();
        float a = 26.12F;
        float b = 2.9F;
        calculator.setA(a);
        calculator.setB(b);
        calculator.setOperation(4);
        Assertions.assertEquals(a * b, calculator.getResult());
    }

    @Test
    public void testDivisionByZero() throws CalculatorException {
        Calculator calculator = new Calculator();
        calculator.setA(1);
        calculator.setB(0);
        calculator.setOperation(3);
        Assertions.assertThrows(CalculatorException.class, calculator::getResult);
    }

    @Test
    public void testEmptyOperation() {
        Calculator calculator = new Calculator();
        calculator.setA(1);
        calculator.setB(2);
        Assertions.assertThrows(CalculatorException.class, calculator::getResult);
    }

    @Test
    public void testLargeValue() throws CalculatorException {
        Calculator calculator = new Calculator();
        calculator.setA(Float.MAX_VALUE);
        calculator.setB(2);
        calculator.setOperation(4);
        Assertions.assertThrows(CalculatorException.class, calculator::getResult);
    }

    @Test
    public void testNullOperands() throws CalculatorException {
        Calculator calculator = new Calculator();
        calculator.setOperation(4);
        Assertions.assertThrows(CalculatorException.class, calculator::getResult);
    }

    @Test
    public void testANull() throws CalculatorException {
        Calculator calculator = new Calculator();
        calculator.setOperation(4);
        calculator.setB(6);
        Assertions.assertThrows(CalculatorException.class, calculator::getResult);
    }

    @Test
    public void testBNull() throws CalculatorException {
        Calculator calculator = new Calculator();
        calculator.setOperation(4);
        calculator.setA(6);
        Assertions.assertThrows(CalculatorException.class, calculator::getResult);
    }

    @Test
    public void testAllNull() throws CalculatorException {
        Calculator calculator = new Calculator();
        Assertions.assertThrows(CalculatorException.class, calculator::getResult);
    }
}