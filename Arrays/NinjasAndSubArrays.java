package Arrays;

public class NinjasAndSubArrays {
    private static int findMaxSum(int n, int[] arr) {
        int sum = Integer.MIN_VALUE;

        int i = 0, j = n - 1;

        while (i < j - 1) {
            sum = Math.max(sum, findSum(i, j, arr));
            j--;
            // again check;
            sum = Math.max(sum, findSum(i, j, arr));
            j++;
            i++;
            // again check
            sum = Math.max(sum, findSum(i, j, arr));
            j--;
        }

        return sum;
    }

    private static int findSum(int i, int j, int[] arr) {
        int smallest = Integer.MIN_VALUE, secondSmallest = Integer.MIN_VALUE, largest = Integer.MIN_VALUE;

        for (int k = i; k <= j; k++) {
            if (largest < arr[k]) {
                secondSmallest = largest;
                largest = arr[k];
            } else if (secondSmallest < arr[k]) {
                smallest = secondSmallest;
                secondSmallest = arr[k];
            } else if (smallest < arr[k]) {
                smallest = arr[k];
            }
        }

        return smallest + secondSmallest;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 2, 1 };
        // System.out.println(findMaxSum(arr.length, arr));
        System.out.println(findSum(0, arr.length - 1, arr));
    }
}
