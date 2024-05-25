import java.util.Scanner;


public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число a, число может быть дробным:");
        float a = getNextFloat(scanner);

        System.out.println("Введите число b, число может быть дробным:");
        float b = getNextFloat(scanner);

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
        scanner.close();
    }

    /**
     * Метод для получения следующего float числа из консоли.
     * При вводе любого значения, не являющегося float числом, будет выведено сообщение и ввод необходимо повторить.
     * @param scanner - текущий сканер для считывания числа из консоли.
     */
    private static float getNextFloat(Scanner scanner) {
        while (!scanner.hasNextFloat()) {
            System.out.println("Некорректный ввод! Введите новое число.");
            scanner.next();
        }
        return scanner.nextFloat();
    }
}
