package Arrays;

import java.util.*;;

public class LongestConsecutive {
    private static int betterApproach(int[] arr) {
        int n = arr.length;

        if (n == 0) {
            return 0;
        }

        Arrays.sort(arr);

        int cnt = 1;
        int longest = 1;
        int lastSmallest = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] == lastSmallest + 1) {
                cnt++;
            } else if (arr[i] != lastSmallest) {
                cnt = 1;
            }

            longest = Math.max(longest, cnt);
            lastSmallest = arr[i];
        }

        return longest;
    }

    private static int optimalApproach(int[] arr) {
        int n = arr.length;

        if (n == 0)
            return 0;

        int longest = 1;
        Set<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }

        for (int it : set) {
            if (!set.contains(it - 1)) {
                int cnt = 1;
                int x = it;
                while (set.contains(x + 1)) {
                    x++;
                    cnt++;
                }
                longest = Math.max(longest, cnt);
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 0, 1 };
        System.out.println(optimalApproach(arr));
    }
}
