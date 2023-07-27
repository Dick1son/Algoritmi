package hw1;

import java.util.Arrays;
import java.util.Random;

public class HeapSort {
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Построение пирамиды
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Извлечение элементов из пирамиды
        for (int i = n - 1; i >= 0; i--) {
            // Перемещение текущего корня в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызов процедуры heapify на уменьшенной пирамиде
            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i; // Инициализация наибольшего элемента
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Если левый дочерний элемент больше корня
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // Если наибольший элемент не корень
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно heapify на поддереве
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[10]; 

        // Заполнение массива случайными числами от -365 до 365
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(365 - (-365) + 1) + (-365);
        }

        System.out.println("Исходный массив: " + Arrays.toString(arr));

        heapSort(arr);

        System.out.println("Отсортированный массив: " + Arrays.toString(arr));
    }
}