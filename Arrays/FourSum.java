package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {
    private static List<List<Integer>> bruteForce(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        int sum = nums[i] + nums[j] + nums[k] + nums[l];
                        if (sum == target) {
                            List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            list.sort(null);
                            set.add(list);
                        }
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }

    private static List<List<Integer>> optimalAproach(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        // array should be sorted for this approach
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int l = i + 1; l < n; l++) {
                if (l > (i + 1) && nums[l] == nums[l - 1])
                    continue;

                int j = l + 1;
                int k = n - 1;

                while (j < k) {
                    long sum = (long) nums[l] + (long) nums[i] + (long) nums[j] + (long) nums[k];

                    if (sum < target) {
                        j++;
                    } else if (sum > target) {
                        k--;
                    } else {
                        list.add(Arrays.asList(nums[i], nums[l], nums[j], nums[k]));
                        j++;
                        k--;

                        while (j < k && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        while (j < k && nums[k] == nums[k + 1]) {
                            k--;
                        }
                    }
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int arr[] = { 1000000000, 1000000000, 1000000000, 1000000000 };
        int target = -294967296;
        List<List<Integer>> list = optimalAproach(arr, target);

        for (List<Integer> list2 : list) {
            System.out.println(Arrays.toString(list2.toArray()));
        }

        long temp = 1000000000L * 4; // 'L' indicates that 1000000000 is a long literal
        System.out.println(temp);
    }
}
