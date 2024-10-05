package Arrays;

import java.util.ArrayList;;

public class RearrangeElements {

    // in case when the negatives and positive are not equal
    public static ArrayList<Integer> RearrangebySign(ArrayList<Integer> A, int n) {
        // Define 2 ArrayLists, one for storing positive
        // and other for negative elements of the array.
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        // Segregate the array into positives and negatives.
        for (int i = 0; i < n; i++) {
            if (A.get(i) > 0)
                pos.add(A.get(i));
            else
                neg.add(A.get(i));
        }

        // If positives are lesser than the negatives.
        if (pos.size() < neg.size()) {

            // First, fill array alternatively till the point
            // where positives and negatives are equal in number.
            for (int i = 0; i < pos.size(); i++) {
                A.set(2 * i, pos.get(i));
                A.set(2 * i + 1, neg.get(i));
            }

            // Fill the remaining negatives at the end of the array.
            int index = pos.size() * 2;
            for (int i = pos.size(); i < neg.size(); i++) {
                A.set(index, neg.get(i));
                index++;
            }
        }

        // If negatives are lesser than the positives.
        else {
            // First, fill array alternatively till the point
            // where positives and negatives are equal in number.
            for (int i = 0; i < neg.size(); i++) {
                A.set(2 * i, pos.get(i));
                A.set(2 * i + 1, neg.get(i));
            }

            // Fill the remaining positives at the end of the array.
            int index = neg.size() * 2;
            for (int i = neg.size(); i < pos.size(); i++) {
                A.set(index, pos.get(i));
                index++;
            }
        }
        return A;
    }

    // using simple brute force approach
    private static int[] bruteForce(int[] nums, int n) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                pos.add(nums[i]);
            } else {
                neg.add(nums[i]);
            }
        }

        for (int i = 0; i < n / 2; i++) {
            nums[i * 2] = pos.get(i);
            nums[i * 2 + 1] = neg.get(i);
        }

        return nums;
    }

    // optimal approach
    private static int[] optimalApproach(int[] nums, int n) {
        int[] arr = new int[n];
        int posIndx = 0;
        int negIndx = 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                arr[posIndx] = nums[i];
                posIndx += 2;
            } else {
                arr[negIndx] = nums[i];
                negIndx += 2;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, -2, -5, 2, -4 };
        arr = optimalApproach(arr, arr.length);
        for (int element : arr) {
            System.out.print(element + " ");
        }
    }
}
