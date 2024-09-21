package Arrays;

import java.util.*;;

public class MaxScoreSubArray {
    public static int maxSubarraySum(Integer[] arr, int n) {
        int maxi = Integer.MIN_VALUE; // maximum sum

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                // current subarray = arr[i.....j]

                // add the current element arr[j]
                // to the sum i.e. sum of arr[i...j-1]
                sum += arr[j];

                maxi = Math.max(maxi, sum); // getting the maximum
            }
        }

        return maxi;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, 3, 1, 5, 6);
        Integer[] temp = list.toArray(new Integer[3]);
        System.out.println(maxSubarraySum(temp, list.size()));
    }
}
