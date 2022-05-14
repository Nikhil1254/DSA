import java.util.Scanner;

public class PrintEncodings {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String str = scn.next();
        printEncodings(str, "");
    }

    public static void printEncodings(String str, String asf) {
        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }

        int val = str.charAt(0) - '0';
        if (val >= 1)
            printEncodings(str.substring(1), asf + (char) ('a' - 1 + val));

        if (str.length() >= 2) {
            if (str.charAt(0) != '0') {
                val = (str.charAt(0) - '0') * 10 + (str.charAt(1) - '0');
                if (val <= 26)
                    printEncodings(str.substring(2), asf + (char) ('a' - 1 + val));
            }
        }

    }
}
