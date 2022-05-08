import java.util.Scanner;

public class DifferenceOfConsecutiveCharacters {
    public static String solution(String str) {
        // write your code here
        StringBuilder ans = new StringBuilder();
        ans.append(str.charAt(0));

        for (int idx = 1; idx < str.length(); idx++) {
            int diff = str.charAt(idx) - str.charAt(idx - 1);
            ans.append(diff);
            ans.append(str.charAt(idx));
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }
}
