package Arrays;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarray {
    // time compexity for this is O(n^2) and space complexity is O(1)
    private static int bruteForce(int[] arr, int n) {
        int largest = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];

                if (sum == 0) {
                    int cnt = j - i + 1;
                    largest = Math.max(largest, cnt);
                }
            }
        }

        return largest;
    }

    // time compexity for this is O(n^2) and space complexity is O(1)
    private static int betterApproach(int[] arr, int n) {
        int largest = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum == 0) {
                largest = i + 1;
            } else {

                if (map.containsKey(sum)) {
                    int cnt = i - map.get(sum);
                    largest = Math.max(largest, cnt);
                } else {
                    map.put(sum, i);
                }
            }
        }

        return largest;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 50, 13, 3, 44, 3, 23, 44, 29, 32, 3, 7, 36, 45, 11, 46, 26, 4, 35, 40, 13, 22 };
        System.out.println(betterApproach(arr, arr.length));
    }
}
