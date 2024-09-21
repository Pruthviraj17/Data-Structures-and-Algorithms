package Arrays;

public class BuySellStocks {
    // using simple brute force approach
    private static int bruteForce(int[] stocks, int n) {
        int max = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stocks[j] - stocks[i] > max) {
                    max = stocks[j] - stocks[i];
                }
            }
        }

        return max;
    }

    // using dynamic programming approach
    private static int usingDP(int[] stocks, int n) {
        int maxPrice = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            minPrice = Math.min(minPrice, stocks[i]);
            maxPrice = Math.max(maxPrice, stocks[i] - minPrice);
        }

        return maxPrice;
    }

    public static void main(String[] args) {
        int[] stocks = { 7, 1, 5, 3, 6, 4 };
        System.out.println(usingDP(stocks, stocks.length));
    }
}
