import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class NextSmallerElementToRight {

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

        for (int i = arr.length - 1; i >= 0; i--) {

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
