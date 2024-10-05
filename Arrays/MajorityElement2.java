package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement2 {
    private static List<Integer> bruteForce(int[] nums) {
        int n = nums.length;
        int cnt = 1;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            cnt = 1;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    cnt++;
                }
            }
            if (cnt > (n / 3)) {
                if (!list.contains(nums[i]))
                    list.add(nums[i]);
            }
        }

        return list;
    }

    // using hashing tc-> O(nlogn) in worst case and sp-> O(n)
    private static List<Integer> betterApproach(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int cnt = map.getOrDefault(nums[i], 0) + 1;
            map.put(nums[i], cnt);
            if (cnt == (n / 3) + 1) {
                list.add(nums[i]);
            }
        }

        return list;
    }

    // using moore's voting algorithms
    // using hashing tc-> O(2n) in worst case and sp-> O(1)
    private static List<Integer> optimal(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        int cnt1 = 0, cnt2 = 0;
        int element1 = Integer.MIN_VALUE, element2 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && nums[i] != element2) {
                element1 = nums[i];
                cnt1 = 1;
            } else if (cnt2 == 0 && nums[i] != element1) {
                element2 = nums[i];
                cnt2 = 1;
            } else if (nums[i] == element1) {
                cnt1++;
            } else if (nums[i] == element2) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        // check whether if the elements in the array are greater than n/3
        cnt1 = 0;
        cnt2 = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == element1) {
                cnt1++;
            } else if (nums[i] == element2) {
                cnt2++;
            }
        }

        if (cnt1 >= (n / 3) + 1) {
            list.add(element1);
        }
        if (cnt2 >= (n / 3) + 1) {
            list.add(element2);
        }

        return list;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 3, 1, 1, 1, 2, 2, 2 };
        List<Integer> list = optimal(arr);

        String s="swdsw";

        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}
