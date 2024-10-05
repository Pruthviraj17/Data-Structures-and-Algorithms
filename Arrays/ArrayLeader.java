package Arrays;

import java.util.ArrayList;

public class ArrayLeader {
    private static ArrayList<Integer> optimal(int n, int arr[]) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(arr[n - 1]);

        if (n == 1) {
            return list;
        }

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1] && arr[i] > list.get(list.size() - 1)) {
                list.add(arr[i]);
            }
        }

        // hence they requre the answer in sequetial order like array just reverse the
        // array
        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            swap(list, start, end);
            start++;
            end--;
        }

        return list;
    }

    private static void swap(ArrayList<Integer> list, int indx1, int indx2) {
        int temp = list.get(indx1);
        list.set(indx1, list.get(indx2));
        list.set(indx2, temp);
    }

    public static void main(String[] args) {
        int[] arr = { 16, 17, 4, 11, 3, 5, 2 };
        int max = Integer.MIN_VALUE;
        int n = arr.length;
        ArrayList<Integer> list = optimal(n, arr);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
