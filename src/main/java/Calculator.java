import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Calculator {

    public static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        System.out.println("Введите номер задания:\n1 - Калькулятор\n2 - Вывод самой длинной строки в массиве");

        while (!scanner.hasNext("[1-2]")) {
            System.out.println("Некорректный ввод! Введите корректный номер задания.");
            scanner.next();
        }
        String task = scanner.next();

        switch (task) {
            case "1":
                startCalculator();
                break;
            case "2":
                startLongestWordSearcher();
                break;
        }
        scanner.close();
    }

    private static void startCalculator() {
        System.out.println("Введите число a, число может быть дробным:");
        float a = getNextFloat();

        System.out.println("Введите число b, число может быть дробным:");
        float b = getNextFloat();

        System.out.println("Введите номер операции, которую хотите выполнить:\n1 - Сложение\n2 - Вычитание\n3 - Деленение\n4 - Умножение");

        while (!scanner.hasNext("[1-4]")) {
            System.out.println("Некорректный ввод! Введите корректный номер операции.");
            scanner.next();
        }
        String operation = scanner.next();

        switch (operation) {
            case "1":
                System.out.printf("Результат операции a + b: %.4f", a + b);
                break;
            case "2":
                System.out.printf("Результат операции a - b: %.4f", a - b);
                break;
            case "3":
                System.out.printf("Результат операции a / b: %.4f", a / b);
                break;
            case "4":
                System.out.printf("Результат операции a * b: %.4f", a * b);
                break;
        }
    }

    private static void startLongestWordSearcher() {
        System.out.println("Введите размер массива.");
        while (!scanner.hasNextInt()) {
            System.out.println("Некорректный ввод! Введите целое число для задания размера массива");
            scanner.next();
        }
        int arraySize = scanner.nextInt();
        List<String> values = new ArrayList<>(arraySize);

        for (int i = 0; i < arraySize; i++) {
            System.out.printf("Введите строку для добавления в массив. Осталось ввести %d строк(и)\n", arraySize - i);
            values.add(scanner.next());
        }
        Collections.sort(values);
        System.out.printf("Самая длинна строка в списке - %s", values.get(arraySize - 1));
    }

    /**
     * Метод для получения следующего float числа из консоли.
     * При вводе любого значения, не являющегося float числом, будет выведено сообщение и ввод необходимо повторить.
     */
    private static float getNextFloat() {
        while (!scanner.hasNextFloat()) {
            System.out.println("Некорректный ввод! Введите новое число.");
            scanner.next();
        }
        return scanner.nextFloat();
    }
}
