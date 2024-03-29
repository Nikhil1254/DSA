import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class StockSpan {
    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val : a) {
            sb.append(val + "\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] span = solve(a);
        display(span);
    }

    // NGETL chach use karun implement kelay just slight modification
    public static int[] solve(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for (int idx = 0; idx < arr.length; idx++) {

            while (st.size() > 0 && arr[idx] > arr[st.peek()])
                st.pop();

            if (st.size() == 0)
                res[idx] = idx + 1;
            else
                res[idx] = idx - st.peek();

            st.push(idx);
        }

        return res;
    }

}
