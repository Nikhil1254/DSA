import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class MergeOverlappingIntervals {
    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time
        Arrays.sort(arr, (arr1, arr2) -> arr1[0] - arr2[0]);
        Stack<int[]> st = new Stack<>();
        st.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {

            if (arr[i][0] <= st.peek()[1])
                st.peek()[1] = Math.max(arr[i][1], st.peek()[1]);
            else
                st.push(arr[i]);
        }

        Stack<int[]> st1 = new Stack<>();

        while (st.size() > 0)
            st1.push(st.pop());

        while (st1.size() > 0) {
            int[] res = st1.pop();
            System.out.println(res[0] + " " + res[1]);
        }
    }
}
