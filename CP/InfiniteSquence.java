package CP;

public class InfiniteSquence {
    private static char findChar(int n, int m, int x, String s, String t) {
        int indx = -1;
        char c = 'a';

        while (true) {
            indx = indx + (2 * n);

            if (indx >= x) {
                indx = (2 * n - 1) - (indx - x);
                s += s;
                c = s.charAt(indx);
                break;
            }

            indx = indx + (2 * m);
            if (indx >= x) {
                indx = (2 * m - 1) - (indx - x);
                t += t;
                c = t.charAt(indx);

                break;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        int n = 3, m = 2;
        String s = "abc", t = "xy";
        int x = 0;
        // 0123456789
        // abcabcxyxyabcabcxyxy
        System.out.println(findChar(n, m, x, s, t));
    }
}
