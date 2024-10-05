package Recursion;

public class ReverseString {
    static boolean revString(String str, int s,int e) {
        if(s>e || s==e) return true;
        if(str.charAt(s)!=str.charAt(e)) return false;
        return revString(str,s+1,e-1);
    }

    static boolean revStringMethod2(String str, int i) {
        if(i>str.length()/2) return true;
        if(str.charAt(i)!=str.charAt(str.length()-i-1)) return false;
        return revStringMethod2(str,i+1);
    }

    public static void main(String[] args) {
        String str = " ";
        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        System.out.println(revStringMethod2(str,0));
    }
}
