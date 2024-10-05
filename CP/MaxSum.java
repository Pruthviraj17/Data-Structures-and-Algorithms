package CP;

import java.util.Arrays;

public class MaxSum {
    private static long maxSum(int[] arr, int n, int x) {

        long max = -1;

        int i = 0;
        int j = n - 1;

        Arrays.sort(arr);

        while (i < j) {
            // this should be 0
            int bit1 = (arr[i] >> x - 1) & 1;

            // this should be 1
            int bit2 = (arr[j] >> x - 1) & 1;

            if (bit1 != 0) {
                i++;
            }
            if (bit2 != 1) {
                j--;
            }

            if (bit1 == 0 && bit2 == 1) {
                int tempMax = arr[i] + arr[j];
                if (tempMax > max) {
                    max = tempMax;
                }
                System.out.println(arr[i] + " " + arr[j]);
                i++;
            }
        }

        i = 0;
        j = n - 1;

        while (i < j) {
            // this should be 0
            int bit1 = (arr[i] >> x - 1) & 1;

            // this should be 1
            int bit2 = (arr[j] >> x - 1) & 1;

            if (bit1 != 1) {
                i++;
            }
            if (bit2 != 0) {
                j--;
            }

            if (bit1 == 1 && bit2 == 0) {
                int tempMax = arr[i] + arr[j];
                if (tempMax > max) {
                    max = tempMax
                }
                System.out.println(arr[i] + " " + arr[j]);
                i++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 4, 1, 2, 7, 5, 6, 8 };
        int x = 3;
        int n = arr.length;

        System.out.println(maxSum(arr, n, x));

    }
}
