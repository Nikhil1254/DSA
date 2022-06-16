import java.util.*;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i=0 ; i<n ;i++)
            arr[i] = scn.nextInt();
        // solution
        lcs(arr);
    }

    public static void lcs(int[] arr) {
        HashMap<Integer, Boolean> hm = new HashMap<>();

        for (int ele : arr)
            hm.put(ele, true);

        for (int ele : arr)
            if (hm.containsKey(ele - 1))
                hm.put(ele, false);

        int start = 0;
        int size = 0;
        for (int ele : arr) {
            if (hm.get(ele) == true) {
                int temp = ele;
                int count = 0;

                while (hm.containsKey(temp)) {
                    count++;
                    temp++;
                }

                if (count > size) {
                    size = count;
                    start = ele;
                }
            }
        }

        while (size > 0) {
            System.out.println(start++);
            size--;
        }
    }
}