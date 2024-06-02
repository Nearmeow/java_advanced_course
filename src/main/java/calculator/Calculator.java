package calculator;

import calculator.operations.*;

import java.util.Scanner;

public class Calculator {

    private Scanner scanner;
    private Operation operation;

    public Calculator(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        System.out.println("Введите число a, число может быть дробным:");
        float a = getNextFloat();

        System.out.println("Введите число b, число может быть дробным:");
        float b = getNextFloat();

        System.out.println("Введите номер операции, которую хотите выполнить:\n1 - Сложение\n2 - Вычитание\n3 - Деленение\n4 - Умножение");

        while (!scanner.hasNext("[1-4]")) {
            System.out.println("Некорректный ввод! Введите корректный номер операции.");
            scanner.next();
        }
        String op = scanner.next();

        switch (op) {
            case "1":
                operation = new Addition();
                break;
            case "2":
                operation = new Subtraction();
                break;
            case "3":
                operation = new Division();
                break;
            case "4":
                operation = new Multiplication();
                break;
        }
        operation.perform(a, b);
        operation.printResult();
    }

    /**
     * Метод для получения следующего float числа из консоли.
     * При вводе любого значения, не являющегося float числом, будет выведено сообщение и ввод необходимо повторить.
     */
    protected float getNextFloat() {
        while (!scanner.hasNextFloat()) {
            System.out.println("Некорректный ввод! Введите новое число.");
            scanner.next();
        }
        return scanner.nextFloat();
    }
}