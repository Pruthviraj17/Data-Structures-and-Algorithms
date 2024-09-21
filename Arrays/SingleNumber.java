package Arrays;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    private static int usingHashMap(int[] nums, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i])+1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int nums[] = { 2, 2, 3, 5, 5, 6, 7, 8,8, 7, 6, };
        System.out.println(usingHashMap(nums, nums.length));
    }
}
