import java.util.*;

public class l002Problems {
    // equalSets problem -
    private static int equalSets(int[] arr, int idx, int sum1, int sum2, String set1, String set2) {

        if (idx == arr.length) {
            if (sum1 == sum2) {
                System.out.println(set1 + " = " + set2);
                return 1;
            }
            return 0;
        }

        int count = 0;
        count += equalSets(arr, idx + 1, sum1 + arr[idx], sum2, set1 + arr[idx] + " ", set2); // set1 choice
        count += equalSets(arr, idx + 1, sum1, sum2 + arr[idx], set1, set2 + arr[idx] + " "); // set2 choice

        return count;

    }

    public static void equalSets() {
        int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80 };
        // we have to call like this only to avoid mirror answers
        System.out.println(equalSets(arr, 1, arr[0], 0, arr[0] + " ", ""));
    }

    // ===================================================================================
    // String permutations -

    public static int allPermutations(String str, String asf) {
        // no os permutations possible = n! -> n is length of the string
        if (str.length() == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1);
            count += allPermutations(ros, asf + ch);
        }

        return count;
    }

    // Sol 1(requires sorted string) -using prev and cur pointers
    public static int uniquePermutations(String str, String asf) {
        if (str.length() == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        char prev = '$';

        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);

            if (cur != prev) {
                String ros = str.substring(0, i) + str.substring(i + 1);
                count += uniquePermutations(ros, asf + cur);
            }

            prev = cur;
        }

        return count;
    }

    // Sol2 (using visited array for marking char visited to avoid second calls) -
    public static int uniquePermutations1(String str, String asf) {
        if (str.length() == 0) {
            System.out.println(asf);
            return 1;
        }

        boolean[] vis = new boolean[26];
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (vis[ch - 'a'] == false) {
                String ros = str.substring(0, i) + str.substring(i + 1);
                count += uniquePermutations1(ros, asf + ch);

                vis[ch - 'a'] = true;
            }
        }

        return count;
    }

    // =======================================================================================================
    // permutations problem leetcode
    // https://leetcode.com/problems/permutations/

    public static void main(String[] args) {
        // equalSets();
        // System.out.println(allPermutations("aab", ""));
        // System.out.println(uniquePermutations("aab", ""));
        System.out.println(uniquePermutations1("aba", ""));
    }

}
