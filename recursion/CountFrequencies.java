import java.util.HashMap;
import java.util.Scanner;

public class CountFrequencies {

    public static void frequencyCount(int arr[], int n, int p) {
        // do modify in the given array
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = arr[i];
            int freq = 0;
            if (mp.containsKey(key))
                freq = mp.get(key); // fetching from the map
            freq++;
            mp.put(key, freq); // inserting into the map
        }

        int cnt = 1;
        while (cnt <= p) {
            if (mp.containsKey(cnt))
                System.out.print(mp.get(cnt) + " ");
            else
                System.out.print(0 + " ");
            cnt++;
        }
    }

    public static void main(String[] args) {

        frequencyCount(new int[] { 2, 3, 2, 3, 5 }, 5, 5);
        // Scanner sc = new Scanner(System.in);

        // int n;
        // n = sc.nextInt();
        // int[] arr = new int[n];
        // for (int i = 0; i < n; i++) {
        // arr[i] = sc.nextInt();
        // }

        // // precompute:
        // HashMap<Integer, Integer> mp = new HashMap<>();
        // for (int i = 0; i < n; i++) {
        // int key = arr[i];
        // int freq = 0;
        // if (mp.containsKey(key))
        // freq = mp.get(key); // fetching from the map
        // freq++;
        // mp.put(key, freq); // inserting into the map
        // }

        // int q;
        // q = sc.nextInt();
        // while (q-- > 0) {
        // int number;
        // number = sc.nextInt();
        // // fetch:
        // if (mp.containsKey(number))
        // System.out.println(mp.get(number));
        // else
        // System.out.println(0);
        // }
    }
}
