package calculator;



public class Calculator {

    private int operation;
    private Float a;
    private Float b;
    private Float result;

    public Calculator(float a, float b, int operation) throws CalculatorException {
        this.a = a;
        this.b = b;
        checkOperation(operation);
        this.operation = operation;
    }

    public Calculator() {
    }

    public float getA() {
        return a;
    }

    public void setA(float a) {
        this.a = a;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) throws CalculatorException {
        checkOperation(operation);
        this.operation = operation;
    }

    public float getResult() throws CalculatorException {
        if (result == null) {
            calculate();
        }
        return result;
    }

    private void calculate() throws CalculatorException {
        if (a == null || b == null) {
            throw new CalculatorException("Не задан один из операндов!");
        }
        switch (operation) {
            case 1:
                result = a + b;
                break;
            case 2:
                result = a - b;
                break;
            case 3:
                if (b == 0) {
                    throw new CalculatorException("Попытка деления на ноль!");
                }
                result = a / b;
                break;
            case 4:
                result = a * b;
                break;
            default:
                throw new CalculatorException("Не указан номер операции!");
        }
        if (Float.isInfinite(result)) {
            throw new CalculatorException("Результат вычисления превышает допустимые границы!");
        }
    }

    private void checkOperation(int operation) throws CalculatorException {
        if ((operation < 1) || (operation > 4)) {
            throw new CalculatorException("Неверный номер операции!");
        }
    }
}