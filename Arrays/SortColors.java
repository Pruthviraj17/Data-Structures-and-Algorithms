package Arrays;

public class SortColors {
    // using counter variables (better approach)
    private static void usingCounter(int[] arr, int n) {
        int cnt0 = 0;
        int cnt1 = 0;
      

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                cnt0++;
            } else if (arr[i] == 1) {
                cnt1++;
            }
        }

        // replace array elements with 0
        for (int i = 0; i < cnt0; i++) {
            arr[i] = 0;
        }

        // replace array elements with 1
        for (int i = cnt0; i < cnt0 + cnt1; i++) {
            arr[i] = 1;
        }

        // replace the remaining array elements with 2
        for (int i = cnt0 + cnt1; i < n; i++) {
            arr[i] = 2;
        }
    }

    // using DNF (Dutch National Flag Algorithm) (optimal approach)
    private static void usingDNF(int arr[], int n) {
        int low = 0;
        int mid = 0;
        int high = n - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] arr, int indx1, int indx2) {
        int temp = arr[indx1];
        arr[indx1] = arr[indx2];
        arr[indx2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 1, 0, 2 };

        usingDNF(arr, arr.length);
        for (int element : arr) {
            System.out.print(element + " ");
        }
    }
}