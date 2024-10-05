package Arrays;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqual {
    private static int bruteForce(int[] arr, int k) {

        int sum = 0, cnt = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];

                if (sum == k) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private static int optimal(int[] arr, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int preSum = 0, cnt = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            preSum += arr[i];
            int remove = preSum - k;
            cnt += map.getOrDefault(remove, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 4 };
        int k = 6;
        System.out.println(optimal(arr, k));
    }
}
