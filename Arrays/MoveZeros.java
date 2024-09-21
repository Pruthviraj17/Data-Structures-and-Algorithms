package Arrays;

public class MoveZeros {
    private static void optimalApproach(int[] nums, int n) {
        // using two pointer and swap approach
        int i = 0;
        int j = 1;
        while (j < n) {
            if (nums[i] != 0) {
                i++;
            }
            if (nums[j] != 0 && nums[i] == 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
            j++;
        }
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 2, 3, 0, 6 };
        optimalApproach(nums, nums.length);
        for (int element : nums) {
            System.out.print(element + " ");
        }
    }
}
