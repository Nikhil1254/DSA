import java.util.*;

public class SlidingWindowMax {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int idx = 0; idx < arr.length; idx++)
            arr[idx] = scn.nextInt();

        int k = scn.nextInt();

        slidingWindowMax(arr, k);
    }

    public static void slidingWindowMax(int[] arr, int k) {

        int[] nger = nextGreaterElementToRight(arr);
        int j = 0;

        for (int i = 0; i <= arr.length - k; i++) {

            // int j = i;

            // more effecient way
            if (j < i)
                j = i;
                
            while (nger[j] < i + k)
                j = nger[j];

            System.out.println(arr[j]);
        }

    }

    public static int[] nextGreaterElementToRight(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int idx = n - 1; idx >= 0; idx--) {
            int val = arr[idx];

            while (st.size() > 0 && arr[st.peek()] < val)
                st.pop();

            if (st.size() == 0)
                res[idx] = n;
            else
                res[idx] = st.peek();

            st.push(idx);
        }

        return res;
    }
}
