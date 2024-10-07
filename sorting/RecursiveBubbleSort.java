package Sorting;

public class RecursiveBubbleSort {
    private static void swap(int[] arr, int swapIndx1, int swapIndx2) {
        int temp = arr[swapIndx2];
        arr[swapIndx2] = arr[swapIndx1];
        arr[swapIndx1] = temp;
    }

    private static void sort(int[] arr, int low, int high) {
        if (low >= high)
            return;

        if (arr[low] > arr[low + 1]) {
            swap(arr, low, low + 1);
        }
        sort(arr, low + 1, high);

    }

    static void bubblSort(int[] arr, int high) {
        if (high == 0) {
            return;
        }
        sort(arr, 0, high);
        bubblSort(arr, high - 1);
    }

    public static void main(String[] args) {
        int[] arr = { 5, 3, 9, 8, 1, 2, 4, 6, 17, 29, 332, 12, 1232, 312 };
        bubblSort(arr, arr.length - 1);
        for (int element : arr) {
            System.out.print(element + " ");
        }
    }
}
