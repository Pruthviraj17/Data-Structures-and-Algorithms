public class Fibonacci {
    static int fibonacciNumber(int n) {
        if (n <= 1)
            return n;
        int first = fibonacciNumber(n - 1);
        int last = fibonacciNumber(n - 2);
        return first + last;
    }
    public static void main(String args[]) {
        int no = 5;
        System.out.println(fibonacciNumber(no));
    }
}