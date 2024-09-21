import java.util.Scanner;

public class Hashing {
    public static void main(String[] args) {
        // input the string
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        // hash the string
        int hash[] = new int[26];
        for (int i = 0; i < str.length(); i++) {
            hash[str.charAt(i) - 'a'] += 1;
        }

        // print the char occurence
        int n = sc.nextInt();
        while (n-- != 0) {
            char ch = sc.next().charAt(0);
            System.out.println(hash[ch - 'a']);
        }

        sc.close();
    }
}
