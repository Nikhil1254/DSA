import java.util.ArrayList;
import java.util.Scanner;

public class GetKPC {
    static String[] values = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        String str = scn.next();
        System.out.println(getKPC(str));
    }

    public static ArrayList<String> getKPC(String str) {
        if (str.length() == 0) {
            ArrayList<String> res = new ArrayList<>();
            res.add("");
            return res;
        }

        String cs = values[Integer.parseInt(str.charAt(0)+"")]; // corresponding string
        ArrayList<String> cb = getKPC(str.substring(1));
        ArrayList<String> res = new ArrayList<>();

        for (int i = 0; i < cs.length(); i++) {
            char ch = cs.charAt(i);
            for (String s : cb)
                res.add(ch + s);

        }

        return res;
    }
}
