package calculator;

import java.util.Scanner;

public class ConsoleCalculator {

    private Scanner scanner;
    private Calculator calculator;

    public ConsoleCalculator(Scanner scanner) {
        this.scanner = scanner;
        this.calculator = new Calculator();
    }

    public Scanner getScanner() {
        return scanner;
    }

    public Calculator getCalculator() {
        return calculator;
    }

    public void startConsoleCalculator() throws CalculatorException {
        askForNumber("a");
        calculator.setA(getNextFloat());
        askForNumber("b");
        calculator.setB(getNextFloat());
        getOperationNumber();
        printResult(calculator.getResult());
    }

    private void printResult(float result) {
        System.out.printf("Результат операции: %.4f", result);
    }

    private void getOperationNumber() {
        System.out.println("Введите номер операции, которую хотите выполнить:\n1 - Сложение\n2 - Вычитание\n3 - Деленение\n4 - Умножение");
        try {
            calculator.setOperation(getNextInt());
        } catch (CalculatorException e) {
            System.out.println(e.getMessage());
            getOperationNumber();
        }
    }

    private void askForNumber(String name) {
        System.out.printf("Введите число %s, число может быть дробным\n", name);
    }

    private int getNextInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("Некорректный ввод! Введите новое число.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    /**
     * Метод для получения следующего float числа из консоли.
     * При вводе любого значения, не являющегося float числом, будет выведено сообщение и ввод необходимо повторить.
     */
    private float getNextFloat() {
        while (!scanner.hasNextFloat()) {
            System.out.println("Некорректный ввод! Введите новое число.");
            scanner.next();
        }
        return scanner.nextFloat();
    }
}
