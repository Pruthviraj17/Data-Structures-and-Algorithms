package Sorting;

public class RecursiveInsertionSort {
    private static void swap(int[] arr, int swapIndx1, int swapIndx2) {
        int temp = arr[swapIndx2];
        arr[swapIndx2] = arr[swapIndx1];
        arr[swapIndx1] = temp;
    }

    private static void sort(int[] arr, int low) {
        if (low <= 0) {
            return;

        }
        if (arr[low] < arr[low - 1]) {
            swap(arr, low, low - 1);
        }
        sort(arr, low - 1);
    }

    static void insertionSort(int[] arr, int low, int high) {
        if (low > high) {
            return;
        }
        sort(arr, low);
        insertionSort(arr, low + 1, high);
    }

    public static void main(String[] args) {
        int[] arr = { 5, 3, 9, 8, 1, 2, 4, 6, 17, 29, 332, 12, 1232, 312 };
        insertionSort(arr, 1, arr.length - 1);
        for (int element : arr) {
            System.out.print(element + " ");
        }
    }
}
