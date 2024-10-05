package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class NextPermutation {
    private static void findNextPermutation(int[] arr, int n) {
        int indx = -1;
        // find the a[i]<a[i+1] index
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                indx = i;
                break;
            }
        }


        // for the case if array is in descending order return the array in ascending
        // order
        int start = 0;
        int end = n - 1;
        if (indx == -1) {
            while (start < end) {
                swap(arr, start, end);
                start++;
                end--;
            }
            return;
        }

        // find the smallest but greatest than arr[indx] from indx+1 to n
        for (int i = n - 1; i > indx; i--) {
            if (arr[i] > arr[indx]) {
                swap(arr, indx, i);
                break;
            }
        }
        // reverse indx+1 to n
        start = indx + 1;
        end = n - 1;
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int arr[], int indx1, int indx2) {
        int temp = arr[indx1];
        arr[indx1] = arr[indx2];
        arr[indx2] = temp;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 2 };
        findNextPermutation(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
