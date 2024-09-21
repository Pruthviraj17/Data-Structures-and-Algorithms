package sorting;

public class QuickSort {
    private static void swap(int[] arr, int swapIndx1, int swapIndx2) {
        int temp = arr[swapIndx2];
        arr[swapIndx2] = arr[swapIndx1];
        arr[swapIndx1] = temp;
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int left = low;
        int right = high;

        while (left < right) {
            while (arr[left] <= pivot && left <= high - 1) {
                left++;
            }
            while (arr[right] >= pivot && right >= low + 1) {
                right--;
            }
            if (left < right) {
                swap(arr, left, right);
            }
        }

        swap(arr, low, right);
        return right;
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // find the partition index
            int pIndex = partition(arr, low, high);
            quickSort(arr, low, pIndex-1);
            quickSort(arr, pIndex + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 3, 9, 8, 1, 2, 4, 6 };
        quickSort(arr, 0, arr.length - 1);
        for (int element : arr) {
            System.out.print(element + " ");
        }
    }
}
