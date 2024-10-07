package Arrays;

import java.util.*;

public class SubArrayWithXor {
    private static int bruteForce(int[] arr, int b) {
        int cnt = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int xor = 0;
            for (int j = i; j < n; j++) {
                xor ^= arr[j];
                if (xor == b) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private static int optimal(int[] arr, int b) {
        int cnt = 0;
        int n = arr.length;
        int xor = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < n; i++) {
            xor ^= arr[i];
            int x = xor ^ b;
            cnt += map.getOrDefault(x, 0);
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 2 };
        int b = 2;
        System.out.println(optimal(arr, b));
    }
}
