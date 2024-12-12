import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int[] arr = getArrayFromUser(scanner);

            System.out.println("Исходный массив: " + Arrays.toString(arr));

            BubbleSort.sort(arr);

            System.out.println("Отсортированный массив: " + Arrays.toString(arr));
        }
    }

    private static int[] getArrayFromUser(Scanner scanner) {
        System.out.print("Введите длину массива: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            throw new IllegalArgumentException("Длина массива должна быть больше нуля.");
        }

        int[] arr = new int[n];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
}