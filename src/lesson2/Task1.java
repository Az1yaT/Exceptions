package lesson2;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        boolean askNext = true;
        while (askNext) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите дробное число");
            String input = scanner.next();
            if (input.matches("^[0-9]*[.]*[0-9]+$")) {
                System.out.println("Вы ввели число: " + Float.parseFloat(input));
                askNext = false;
                scanner.close();
            }
        }
    }
}
