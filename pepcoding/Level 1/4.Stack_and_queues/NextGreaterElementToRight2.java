import java.util.*;

// approach 2 - left to right processing elements

public class NextGreaterElementToRight2 {
    public static void display(int[] arr) {
        for (int ele : arr)
            System.out.print(ele + " ");
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int idx = 0; idx < arr.length; idx++)
            arr[idx] = scn.nextInt();

        int[] nge = solve(arr);
        display(nge);
    }

    public static int[] solve(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            while (st.size() > 0 && arr[st.peek()] < arr[i])
                res[st.pop()] = arr[i];

            st.push(i);
        }

        while (st.size() > 0)
            res[st.pop()] = -1;

        return res;
    }
}
