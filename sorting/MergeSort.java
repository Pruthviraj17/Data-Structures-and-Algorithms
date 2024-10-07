package Sorting;

import java.util.*;

public class MergeSort {
    // merge the elements
    private static void merge(int[] array, int low, int mid, int high) {
        ArrayList<Integer> list = new ArrayList<>();

        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (array[left] <= array[right]) {
                list.add(array[left]);
                left++;
            } else {
                list.add(array[right]);
                right++;
            }
        }

        // add the remianing left half
        while (left <= mid) {
            list.add(array[left]);
            left++;
        }

        // add the remianing right half
        while (right <= high) {
            list.add(array[right]);
            right++;
        }

        // replace the elements in the array
        for (int i = low; i <= high; i++) {
            array[i] = list.get(i - low);
        }
    }

    // divide the array
    static void divide(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        // divide the left half
        divide(arr, low, mid);
        // divide the right half
        divide(arr, mid + 1, high);
        // merge the elements
        merge(arr, low, mid, high);
    }

    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };

        divide(arr, 0, arr.length - 1);
        for (int element : arr) {
            System.out.print(element + " ");
        }
    }
}
