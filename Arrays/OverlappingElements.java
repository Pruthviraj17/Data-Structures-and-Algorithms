package Arrays;

import java.util.*;;

public class OverlappingElements {
    // time comp-> O(nlogn) to sort the array + O(2n) for the iteration i+j
    // space -> O(n)
    private static List<List<Integer>> bruteForce(int[][] arr) {
        int n = arr.length;
        Arrays.sort(arr, new Comparator<int[]>() {
            // this function will work like if the return is >=0 then it will swap else
            // return<=-1
            // then it will not
            public int compare(int[] a, int[] b) {

                // this will also work
                // if (a[0] > b[0]) {
                // return 1;
                // } else {
                // return -1;
                // }

                return a[0] - b[0];
            }
        });

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) { // select an interval:
            int start = arr[i][0];
            int end = arr[i][1];

            // Skip all the merged intervals:
            if (!ans.isEmpty() && end <= ans.get(ans.size() - 1).get(1)) {
                continue;
            }

            // check the rest of the intervals:
            for (int j = i + 1; j < n; j++) {
                if (arr[j][0] <= end) {
                    end = Math.max(end, arr[j][1]);
                } else {
                    break;
                }
            }
            ans.add(Arrays.asList(start, end));
        }
        return ans;
    }

    // time comp-> O(nlogn) to sort the array + O(n) (slightly optimized than
    // before) for the iteration i+j
    // space -> O(n)
    private static List<List<Integer>> optimal(int[][] arr) {
        int n = arr.length;
        Arrays.sort(arr, new Comparator<int[]>() {
            // this function will work like if the return is >=0 then it will swap else
            // return<=-1
            // then it will not
            public int compare(int[] a, int[] b) {

                // this will also work
                // if (a[0] > b[0]) {
                // return 1;
                // } else {
                // return -1;
                // }

                return a[0] - b[0];
            }
        });

        List<List<Integer>> ans = new ArrayList<>();
        // after sorting {{1, 3}, {2, 4}, {3, 5}, {6, 7}}
        for (int i = 0; i < n; i++) {
            if (ans.isEmpty() || arr[i][0] > ans.get(ans.size() - 1).get(1)) {
                ans.add(Arrays.asList(arr[i][0], arr[i][1]));
            }

            else {
                int indexLast = ans.get(ans.size() - 1).get(1);
                ans.get(ans.size() - 1).set(1, Math.max(arr[i][1], indexLast));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = { { 2, 4 }, { 3, 5 }, { 1, 3 }, { 6, 7 } };
        List<List<Integer>> ans = optimal(arr);

        for (List<Integer> list : ans) {
            System.out.println(list.toString());
        }
    }
}
