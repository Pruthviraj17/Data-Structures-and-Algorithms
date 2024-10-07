package Arrays;

public class MaximuProductSubarray {
    // tc-> O(n^2) and the sc-> O(1)
    private static int bruteForce(int[] arr, int n) {
        int largest = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = i; j < n; j++) {
                product *= arr[j];
                largest = Math.max(largest, product);
            }
        }

        return largest;
    }

    // tc-> O(n) and the sc-> O(1)
    private static int optimal(int[] arr, int n) {
        int largest = Integer.MIN_VALUE;

        int suffix = 1;
        int prefix = 1;
        for (int i = 0; i < n; i++) {
            if (suffix == 0)
                suffix = 1;
            if (prefix == 0)
                prefix = 1;

            suffix *= arr[i];
            prefix *= arr[n - i - 1];

            largest = Math.max(largest, Math.max(suffix, prefix));
        }

        return largest;
    }

    public static void main(String[] args) {
        int[] arr = { -2, 3, 0, 9, -1, -1, 3, 0, 4, -1 };
        System.out.println(optimal(arr, arr.length));
    }
}
