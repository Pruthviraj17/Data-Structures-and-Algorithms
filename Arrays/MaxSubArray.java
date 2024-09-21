package Arrays;

public class MaxSubArray {
    // simple brute force approach
    private static int bruteForce(int[] arr) {
        int n = arr.length;

        int sum = 0;
        int max = arr[0];

        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + arr[j];
                if (max < sum) {
                    max = sum;
                }
            }
        }

        return max;
    }

    // using kadanes algo
    private static int kadaneAlgo(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];

            if (sum < 0) {
                sum = 0;
            }

            if (sum > max) {
                max = sum;
            }

        }

        if (max == 0) {
            max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (max < nums[i]) {
                    max = nums[i];
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = { -7, -8, -16, -4, -8, -5, -7, -11, -10, -12, -4, -6, -4, -16, -10 };

        System.out.println(kadaneAlgo(arr));
    }
}
