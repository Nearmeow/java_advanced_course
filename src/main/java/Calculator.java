import java.util.*;
import java.util.stream.Collectors;


public class Calculator {

    public static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        System.out.println("Введите номер задания:\n1 - Калькулятор\n2 - Вывод самой длинной строки в массиве\n" +
                "3 - Задание с массивом\n4 - Сладкий подарок");

        while (!scanner.hasNext("[1-4]")) {
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
            case "3":
                Task_3.task3_1();
                break;
            case "4":
                Task_3.task3_2();
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
        while (!scanner.hasNext("[0-9]\\d*")) {
            System.out.println("Некорректный ввод! Введите целое положительное число для задания размера массива");
            scanner.next();
        }
        int arraySize = scanner.nextInt();
        List<String> values = new ArrayList<>(arraySize);
        int maxLength = 0;

        for (int i = 0; i < arraySize; i++) {
            System.out.printf("Введите строку для добавления в массив. Осталось ввести %d строк(и)\n", arraySize - i);
            values.add(scanner.next());
            if (values.get(i).length() > maxLength) {
                maxLength = values.get(i).length();
            }
        }
        int finalMaxLength = maxLength;
        List<String> resultList = values.stream().filter(e -> e.length() == finalMaxLength).collect(Collectors.toList());
        System.out.println("Самая длинная строка(или строки) в массиве:");
        resultList.forEach(System.out::println);
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
