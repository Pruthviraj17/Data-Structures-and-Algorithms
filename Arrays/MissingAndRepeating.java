package Arrays;

import java.util.*;;

public class MissingAndRepeating {
    // tc-> O(2n) and the sc-> O(n)
    private static int[] byHashing(int arr[]) {
        int n = arr.length;
        int[] hash = new int[n + 1];
        int duplicate = -1;
        int missing = -1;

        for (int i = 0; i < n; i++) {
            hash[arr[i]] += 1;
        }

        for (int i = 1; i <= n; i++) {
            if (hash[i] == 2) {
                duplicate = i;
            } else if (hash[i] == 0) {
                missing = i;
            }
        }

        return new int[] { duplicate, missing };
    }

    // tc-> O(n) and the sc-> O(1)
    private static int[] byMathFormula(int arr[]) {
        long n = (long) arr.length;

        long SN = (n * (n + 1)) / 2;
        long S2N = (n * (n + 1) * (2 * n + 1)) / 6;

        long S = 0, S2 = 0;
        for (int i = 0; i < n; i++) {
            S += (long) arr[i];
            S2 += (long) arr[i] * (long) arr[i];
        }

        long val1 = S - SN;
        long val2 = S2 - S2N;
        val2 = val2 / val1;
        long x = (val1 + val2) / 2;
        long y = x - val1;

        return new int[] { (int) x, (int) y };
    }

    // tc-> O(4n) and the sc-> O(n)
    public static int[] byXorMethod(int[] a) {
        int n = a.length; // size of the array
        int xr = 0;

        // Step 1: Find XOR of all elements:
        for (int i = 0; i < n; i++) {
            xr = xr ^ a[i];
            xr = xr ^ (i + 1);
        }

        // Step 2: Find the differentiating bit number:
        int number = (xr & ~(xr - 1));

        // Step 3: Group the numbers:
        int zero = 0;
        int one = 0;
        for (int i = 0; i < n; i++) {
            // part of 1 group:
            if ((a[i] & number) != 0) {
                one = one ^ a[i];
            }
            // part of 0 group:
            else {
                zero = zero ^ a[i];
            }
        }

        for (int i = 1; i <= n; i++) {
            // part of 1 group:
            if ((i & number) != 0) {
                one = one ^ i;
            }
            // part of 0 group:
            else {
                zero = zero ^ i;
            }
        }

        // Last step: Identify the numbers:
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == zero)
                cnt++;
        }

        if (cnt == 2)
            return new int[] { zero, one };
        return new int[] { one, zero };
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 2 };
        int[] ans = byMathFormula(arr);
        System.out.println(Arrays.toString(ans));
    }
}
