package Arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    private static List<List<Integer>> betterAproach(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> hashSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                // simple maths formula -> arr[k]= - (arr[i]+arr[j])
                int k = -(nums[i] + nums[j]);
                if (set.contains(k)) {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], k);
                    temp.sort(null);
                    hashSet.add(temp);
                }

                set.add(nums[j]);
            }
        }

        return new ArrayList<>(hashSet);
    }

    // tc-> O(n^2) * logn, sc -> O(no of unique elements)
    private static List<List<Integer>> optimalAproach(int[] nums) {
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        // array should be sorted for this approach
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
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

        return list;
    }

    public static void main(String[] args) {
        int arr[] = { -2, 0, 1, 1, 2 };
        List<List<Integer>> list = optimalAproach(arr);

        for (List<Integer> list2 : list) {
            System.out.println(Arrays.toString(list2.toArray()));
        }
    }
}
