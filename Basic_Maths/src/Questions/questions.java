package Questions;

public class questions {

    static int countDigits(int n){
        int cnt=(int)(Math.log10(n)+1);
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(countDigits(220));
    }
}
