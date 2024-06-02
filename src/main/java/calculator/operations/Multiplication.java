package calculator.operations;

public class Multiplication extends BaseOperation implements Operation {

    @Override
    public void perform(float a, float b) {
        super.setResult(a * b);
    }

    @Override
    public void printResult() {
        System.out.printf("Результат операции умножение: %.4f", super.getResult());
    }
}
