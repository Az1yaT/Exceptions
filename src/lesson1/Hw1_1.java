// Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
import java.util.Scanner;

public class Hw1_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        System.out.println(SquareOf(input));
        System.out.println(QuotientOf(5, 0));
        System.out.println(findValueOf(10, new int[] { 1, 2 }));
    }
    private static float QuotientOf(int a, int b) {
        if (b == 0)
            throw new ArithmeticException("Делить на ноль нельзя!");
        return a / b;
    }
    private static int findValueOf(int index, int[] array) {
        if (index > array.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Указанный индекс находится за пределами массива");
        }
        return array[index];
    }
    private static int SquareOf(String input) {
        if (!input.matches("[-+]?\\d+")) {
            throw new NumberFormatException("Введите целое число");
        }
        return Integer.parseInt(input) * Integer.parseInt(input);
    }
}