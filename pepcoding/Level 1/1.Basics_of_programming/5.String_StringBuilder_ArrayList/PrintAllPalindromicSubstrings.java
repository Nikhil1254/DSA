import java.util.Scanner;

public class PrintAllPalindromicSubstrings {
    public static void solution(String str) {

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String sub = str.substring(i, j);
                if (isPalindrome(sub))
                    System.out.println(sub);
            }
        }
    }

    public static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;

        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        solution(str);

        String str1 = "abc";
        String str2 = str1;
        str1 += "d";

        System.out.println(str1 + " " + str2 + " " + (str1 == str2));
    }
}
