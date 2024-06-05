import calculator.CalculatorException;
import calculator.ConsoleCalculator;
import task5.Task_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class App {

    public static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        System.out.println("Введите номер задания:\n1 - Калькулятор\n2 - Вывод самой длинной строки в массиве\n" +
                "3 - Задание с массивом\n4 - Сладкий подарок\n5 - Подсчёт слов из файла");

        while (!scanner.hasNext("[1-5]")) {
            System.out.println("Некорректный ввод! Введите корректный номер задания.");
            scanner.next();
        }
        String task = scanner.next();

        switch (task) {
            case "1":
                ConsoleCalculator calculator = new ConsoleCalculator(scanner);
                calculator.startConsoleCalculator();
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
            case "5":
                Task_5 task5 = new Task_5(scanner);
                task5.startTask();
        }
        scanner.close();
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
}
