package task5;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class WordProcessor {

    private Path path;
    private Map<String, Integer> map;

    public WordProcessor(Path path) {
        this.path = path;
        map = new TreeMap<>(new WordComparator());
        getWords();
    }

    public void printWordStatistic() {
        map.forEach((key, value) -> System.out.println(key + " " + value));
    }

    public void printMosFreqWords() {
        int maxFrequency = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getValue();
        for (Map.Entry<String, Integer> elem : map.entrySet()) {
            if (elem.getValue() == maxFrequency) {
                System.out.printf("Чаще всего встречается слово %s, количество - %d\n",elem.getKey(), elem.getValue());
            }
        }
    }

    private void getWords() {
        try(BufferedReader fileReader = Files.newBufferedReader(path)) {
            String line;
            while((line = fileReader.readLine()) != null) {
                String[] arr = line.split(" ");
                for (String elem : arr) {
                    map.merge(elem, 1, Integer::sum);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
