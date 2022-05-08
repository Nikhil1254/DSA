import java.util.*;

public class ToggleCase {
    public static String toggleCase(String str) {
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z')
                ans.append((char) ('A' + ch - 'a'));
            else if (ch >= 'A' && ch <= 'Z')
                ans.append((char) ('a' + ch - 'A'));
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(toggleCase(str));
    }
}
