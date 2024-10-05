package Arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    // // using formula nCr Time Comp-> O(r) space-> O(1)
    // private static int elementAtPosition(int r, int n) {
    // long ans = 1;

    // for (int i = 0; i < r; i++) {
    // ans *= (n - i);
    // ans /= i + 1;
    // }

    // return (int) ans;
    // }

    // // return the nth row of pascal triangle
    // private static List<Integer> genrateNthRow(int n) {
    // List<Integer> list = new ArrayList<>();
    // long ans = 1;

    // list.add(1); // add one for the first index
    // for (int i = 1; i < n; i++) {
    // ans *= n - i;
    // ans /= i;
    // list.add((int) ans);
    // }

    // return list;
    // }

    // // time complexity if we use genrateNthRow() -> O(n^2) space-> O(n^2) to
    // return
    // // the ans
    // // time complexity if we use elementAtPosition() -> O(n*n*r) space-> O(n^2)
    // to
    // // return the ans
    // private static List<List<Integer>> generatePascalTriangle(int n) {
    // List<List<Integer>> pascalTriangle = new ArrayList<>();

    // for (int i = 1; i <= n; i++) {
    // pascalTriangle.add(genrateNthRow(i));
    // }

    // return pascalTriangle;
    // }

    // return the nth row of pascal triangle
    private static int[] genrateNthRow(int n) {
        int[] list = new int[n];
        long ans = 1;

        list[0] = 1; // add one for the first index
        for (int i = 1; i < n; i++) {
            ans *= n - i;
            ans /= i;
            list[i] = (int) ans;
        }

        return list;
    }

    // time complexity if we use genrateNthRow() -> O(n^2) space-> O(n^2) to return
    // the ans
    // time complexity if we use elementAtPosition() -> O(n*n*r) space-> O(n^2) to
    // return the ans
    private static int[][] generatePascalTriangle(int n) {
        int[][] pascalTriangle = new int[n][];

        for (int i = 1; i <= n; i++) {
            pascalTriangle[i - 1] = new int[i];
            pascalTriangle[i - 1] = genrateNthRow(i);
        }

        return pascalTriangle;
    }

    public static void main(String[] args) {
        int col = 3, row = 5;
        int n = 5;
        // System.out.println(elementAtPosition(col - 1, row - 1));
        int[][] pascalTriangle = generatePascalTriangle(n);

        for (int i = 0; i < pascalTriangle.length; i++) {
            for (int j = 0; j < pascalTriangle[i].length; j++) {
                System.out.print(pascalTriangle[i][j] + " ");
            }
            System.out.println();
        }
    }
}
