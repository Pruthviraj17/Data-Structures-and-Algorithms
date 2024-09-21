package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    // if there have to only return YES or No this is the best approach
    private static String usingTwoPointer(int[] nums, int n, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            if (nums[left] + nums[right] < target) {
                left++;
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                return "YES";
            }
        }

        return "NO";
    }

    // if there have to return indexes like [0,1] this is the best approach
    private static int[] usingHashing(int[] nums, int n, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int rem = target - nums[i];

            if (map.containsKey(rem)) {
                return new int[] { map.get(rem), i };
            }

            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }

        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int arr[] = { 2, 7, 11, 15 };
        int target = 10;
        System.out.println(Arrays.toString(usingHashing(arr, arr.length, target)));
    }
}
