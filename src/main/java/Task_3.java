import presents.Candy;
import presents.Jellybean;
import presents.Sweet;

import java.util.*;

public class Task_3 {

    protected static void task3_1() {
        Random random = new Random();

        int[] array = new int[20];
        for (int i = 0; i < 20; i++) {
            array[i] = random.ints(-10, 11).findFirst().getAsInt();
        }

        System.out.println("Сформировались элементы массива:");
        System.out.println(Arrays.toString(array));

        int maxNegative = -10;
        int minPositive = 10;

        for (int i = 0; i < 20; i++) {
            if (array[i] < 0) {
                if (array[i] > maxNegative) {
                    maxNegative = array[i];
                }
            } else {
                if (array[i] < minPositive) {
                    minPositive = array[i];
                }
            }
        }

        System.out.println("Максимальное отрицательно число в массиве - " + maxNegative);
        System.out.println("Минимальное положительное число в массиве - " + minPositive);

        for (int i = 0; i < 20; i++) {
            if (array[i] == maxNegative) {
                array[i] = minPositive;
            } else if (array[i] == minPositive) {
                array[i] = maxNegative;
            }
        }
        System.out.println("Массив после замены:");
        System.out.println(Arrays.toString(array));

    }

    protected static void task3_2() {
        Candy candy1 = new Candy("Romashka", 0.25, 20.5, "chocolate");
        Candy candy2 = new Candy("Raffaello", 0.5, 45, "almond");
        Candy candy3 = new Candy("Toffee", 0.3, 18.5, "condensed milk");
        Jellybean jellybean1 = new Jellybean("Haribo", 0.4, 57.8, "bear");
        Jellybean jellybean2 = new Jellybean("BonPari", 0.22, 23.9, "worm");

        List<Sweet> present = new ArrayList<>();
        present.add(candy1);
        present.add(candy2);
        present.add(candy3);
        present.add(jellybean1);
        present.add(jellybean2);

        double totalWeight = 0;
        double totalPrice = 0;

        for (Sweet sweet: present) {
            totalWeight += sweet.getWeight();
            totalPrice += sweet.getPrice();
        }
        System.out.printf("Общий вес подарка - %.2f\n",totalWeight);
        System.out.printf("Общая цена подарка - %.2f\n", totalPrice);
        System.out.println("Сладости в подарке:");
        present.forEach(System.out::println);
    }
}
