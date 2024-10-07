package Arrays;

import java.util.*;;

public class MergeSortedArray {
    // tc -> O(n+m), sc-> O(n+m)
    private static void bruteForce(long[] a, long[] b) {
        int n = a.length;
        int m = b.length;
        long[] temp = new long[n + m];

        int left = 0;
        int right = 0;
        int indx = 0;

        while (left < n && right < m) {
            if (a[left] <= b[right]) {
                temp[indx] = a[left];
                left++;
                indx++;
            } else {
                temp[indx] = b[right];
                right++;
                indx++;
            }
        }

        while (left < n) {
            temp[indx] = a[left];
            indx++;
            left++;
        }

        while (right < m) {
            temp[indx] = b[right];
            indx++;
            right++;
        }
        indx = 0;
        for (int i = 0; i < n; i++) {
            a[i] = temp[indx++];
        }

        for (int i = 0; i < m; i++) {
            b[i] = temp[indx++];
        }

    }

    // tc -> O(min(n,m)) + O(nlogn) + O(mlogm), sc-> O(1)
    private static void optimal1(long[] a, long[] b) {
        int n = a.length;
        int m = b.length;

        int left = n - 1;
        int right = 0;

        while (left >= 0 && right < m) {

            if (a[left] > b[right]) {

                long temp = a[left];
                a[left] = b[right];
                b[right] = temp;

                left--;
                right++;
            } else {
                break;
            }
        }

        Arrays.sort(a);
        Arrays.sort(b);

    }

    public static void swapIfGreater(long[] arr1, long[] arr2, int ind1, int ind2) {
        if (arr1[ind1] > arr2[ind2]) {
            long temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }

    // tc -> O(min(n,m)) + O(nlogn) + O(mlogm), sc-> O(1)
    // using gap method
    public static void optimal2(long[] arr1, long[] arr2) {

        // len of the imaginary single array:
        int n = arr1.length;
        int m = arr2.length;
        int len = n + m;

        // Initial gap:
        int gap = (len / 2) + (len % 2);

        while (gap > 0) {
            // Place 2 pointers:
            int left = 0;
            int right = left + gap;
            while (right < len) {
                // case 1: left in arr1[]
                // and right in arr2[]:
                if (left < n && right >= n) {
                    swapIfGreater(arr1, arr2, left, right - n);
                }
                // case 2: both pointers in arr2[]:
                else if (left >= n) {
                    swapIfGreater(arr2, arr2, left - n, right - n);
                }
                // case 3: both pointers in arr1[]:
                else {
                    swapIfGreater(arr1, arr1, left, right);
                }
                left++;
                right++;
            }
            // break if iteration gap=1 is completed:
            if (gap == 1)
                break;

            // Otherwise, calculate new gap:
            gap = (gap / 2) + (gap % 2);
        }
    }

    public static void main(String[] args) {
        long[] nums1 = { 0, 1, 2, 3 };
        long[] nums2 = { 2, 5, 6 };
        // int m = 3, n = 3;
        optimal2(nums1, nums2);

        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }
}
