import java.util.*;

public class NextSmallerElementOnLeft {
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
        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            while (st.size() > 0 && arr[i] <= arr[st.peek()])
                st.pop();

            if (st.size() == 0)
                res[i] = -1;
            else
                res[i] = arr[st.peek()];

            st.push(i);
        }

        return res;
    }
}
