package Arrays;

import java.util.*;;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        // int[] arr = { 0, 0, 1, 2, 3, 4, 5, 6, 7, 8 };

        Arrays.sort(arr);

        int longest = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                longest = longest + 1;
                max = Math.max(max, longest);
            } else {
                max = Math.max(max, longest);
                longest = 1;
            }
        }

        System.out.println(max);
    }
}
