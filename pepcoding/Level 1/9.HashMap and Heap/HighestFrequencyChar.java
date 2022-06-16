import java.util.HashMap;
import java.util.Scanner;

public class HighestFrequencyChar {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String str = scn.next();

        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (hm.containsKey(ch))
                hm.put(ch, hm.get(ch) + 1);
            else
                hm.put(ch, 1);
        }

        char maxFreqChar = str.charAt(0);
        for (char ch : hm.keySet()) {
            if (hm.get(ch) > hm.get(maxFreqChar)) {
                maxFreqChar = ch;
            }
        }

        System.out.println(maxFreqChar);
    }
}
