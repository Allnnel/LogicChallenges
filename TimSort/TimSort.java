package org.example;

import java.util.Arrays;

import java.util.Arrays;

public class TimSort {
    // Минимальный размер подмассива для слияния
    private static final int MIN_MERGE = 32;

    public static void main(String[] args) {
        int[] arr = {12, 3, 6, 1, 9, 5, 7, 4, 1, 11, 8, 2, 10};
        timSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void timSort(int[] arr) {
        int n = arr.length;
        int minRun = calculateMinRun(n);
        // Деление массива на минимальные подмассивы и их сортировка
        for (int i = 0; i < n; i += minRun) {
            insertionSort(arr, i, Math.min(i + minRun - 1, n - 1));
        }
        // Слияние подмассивов в один
        for (int size = minRun; size < n; size *= 2) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1; // Середина массива
                int right = Math.min((left + 2 * size - 1), (n - 1)); // Правая граница подмассива
                merge(arr, left, mid, right); // Слияние двух подмассивов
            }
        }
    }

     // Метод вычисления минимального размера подмассива для слияния
    private static int calculateMinRun(int n) {
        int r = 0;
        while (n >= MIN_MERGE) {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }

    // Метод сортировки вставками
    private static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    // Метод слияния двух подмассивов в один
    private static void merge(int[] arr, int left, int mid, int right) {
         // Длина левого/правого подмассива
        int len1 = mid - left + 1;
        int len2 = right - mid;
        // Копирование левого/правого подмассива
        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);
        int i = 0, j = 0, k = left;
        // Слияние двух подмассивов
        while (i < len1 && j < len2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        // Дополнительное копирование левого/правого подмассива
        while (i < len1) {
            arr[k++] = leftArr[i++];
        }
        while (j < len2) {
            arr[k++] = rightArr[j++];
        }
    }
}
