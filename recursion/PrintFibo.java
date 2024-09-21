public class PrintFibo {
    static int printFicbo(int n){
        if (n <= 1)
            return n;
        int first = printFicbo(n - 1);
        int last = printFicbo(n - 2);
        return first + last;
    }
    public static void main(String[] args) {
        int n=10;

    }
}
