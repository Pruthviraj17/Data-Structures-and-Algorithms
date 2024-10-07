package Sorting;

/**
 * BasicSorting
 */
public class BasicSorting {

    public static void main(String[] args) {
        int[] arr = { 4, 1, 3, 9, 7 };
        int n = 5;
        for (int i = 0; i < n - i; i++) {
            for (int j = 0; j < n - i-1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int no : arr) {
            System.out.print(no + " ");
        }
    }
}