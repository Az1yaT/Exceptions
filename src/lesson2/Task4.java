package lesson2;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите что-нибудь");
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            scanner.close();
            throw new RuntimeException("Пустые строки вводить нельзя");
        }
        System.out.println(input);
    }
}
