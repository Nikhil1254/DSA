import java.util.Scanner;

public class GetSubsequence {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        String str = scn.next();
        printSS(str, "");
    }

    public static void printSS(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        char ch = str.charAt(0);
        String subStr = str.substring(1);

        printSS(subStr, ans + ch);
        printSS(subStr, ans);
    }
}
