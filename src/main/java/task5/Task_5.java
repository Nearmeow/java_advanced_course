package task5;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Task_5 {

    private Scanner scanner;

    public Task_5(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startTask() {
        System.out.println("Введите путь к файлу:");
        Scanner scanner = new Scanner(System.in);
        String pathToFile = scanner.next();

        while (!isValidPath(pathToFile)) {
            System.out.println("Такого файла не существует! Введите корректный путь:");
            pathToFile = scanner.next();
        }

        Path path = Path.of(pathToFile).toAbsolutePath();
        WordProcessor wordProcessor = new WordProcessor(path);
        wordProcessor.printWordStatistic();
        wordProcessor.printMosFreqWords();
    }

    private static boolean isValidPath(String fileName) {
        Path sourceFile = Paths.get(fileName);
        return Files.exists(sourceFile) && sourceFile.toFile().length() > 0;
    }
}
