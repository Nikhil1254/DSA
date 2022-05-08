import java.util.Scanner;

public class StringCompression {
    public static String compression1(String str) {
        // write your code here
        StringBuilder ans = new StringBuilder("");
        ans.append(str.charAt(0));

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i - 1))
                ans.append(str.charAt(i));
        }
        return ans.toString();
    }

    public static String compression2(String str) {
        // write your code here
        StringBuilder ans = new StringBuilder();

        ans.append(str.charAt(0));
        int count = 1;

        for (int i = 1; i < str.length(); i++) {

            if (str.charAt(i) == str.charAt(i - 1))
                count++;
            else {
                if (count > 1)
                    ans.append(count);
                ans.append(str.charAt(i));
                count = 1;
            }
        }
        if (count > 1)
            ans.append(count);
        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(compression1(str));
        System.out.println(compression2(str));
    }
}