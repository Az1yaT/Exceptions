package lesson2;

public class Task2 {
    public static void main(String[] args) {
        int d = 5;
        int[] intArray = { 1, 2, 3 };

        try {
            double catchedResl = (double) intArray[1] / d;
            System.out.println("catchedRes1 = " + catchedResl);
        } catch (ArithmeticException | IndexOutOfBoundsException e) {
            System.out.println("Catching exception: " + e);
        }
    }
}