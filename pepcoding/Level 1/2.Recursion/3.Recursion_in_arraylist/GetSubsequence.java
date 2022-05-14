import java.util.ArrayList;
import java.util.Scanner;

public class GetSubsequence {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        String str = scn.next();
        System.out.println(gss(str));
    }

    public static ArrayList<String> gss(String str) {
        if (str.length() == 0) {
            ArrayList<String> res = new ArrayList<String>();
            res.add("");
            return res ;
        }

        ArrayList<String> res = gss(str.substring(1));

        int size = res.size();
        char ch = str.charAt(0);

        for (int i = 0; i < size; i++)
            res.add(ch + res.get(i));

        return res;

    }
}
