package Arrays;

public class ArraySortedOrNot {
    public static boolean check(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return rotatedArray(arr, i, arr.length);
            }
        }
        return true;
    }

    private static boolean rotatedArray(int[] arr, int start, int n) {
        for (int i = start; i < n ; i++) {
            if (arr[i] > arr[0] || arr[i + 1] > arr[0]) {
                return false;
            }
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 2 };
        boolean result = check(arr);
        System.out.println(result);
    }
}
