import java.util.Scanner;

public class CalculatorBase {

    private Scanner scanner;

    public CalculatorBase(Scanner scanner) {
        this.scanner = scanner;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void printResult() {

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
