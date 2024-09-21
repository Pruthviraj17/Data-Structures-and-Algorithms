package Arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    private static int usingHashing(int[] arr, int n) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }

        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > (n / 2)) {
                return entry.getKey();
            }
        }

        return -1;
    }

    private static int usingMooresVotingAlgo(int[] arr) {
        int cnt = 0;
        int element = 0;

        for (int i = 0; i < arr.length; i++) {
            if (cnt == 0) {
                cnt++;
                element = arr[i];
            } else if (arr[i] == element) {
                cnt++;
            } else {
                cnt--;
            }
        }

        // if there are not any such number then cross check
        int cnt2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (element == arr[i]) {
                cnt2++;
            }
        }

        if (cnt2 <= (arr.length / 2)) {
            // in this case no such numbers present
            element = -1;
        }

        return element;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 2, 1, 1 };

        System.out.println(usingMooresVotingAlgo(arr));
    }
}
