import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class CelebrityProblem {
    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"

        Stack<Integer> st = new Stack<>();

        for (int idx = 0; idx < arr.length; idx++)
            st.push(idx);

        while (st.size() > 1) {

            int idx2 = st.pop();
            int idx1 = st.pop();

            if (arr[idx1][idx2] == 1) {
                // idx1 knows idx2 -> idx1 is not celeb
                st.push(idx2);
            } else {
                // idx1 dont knows idx2 - idx2 cant be celeb to celeb everyone should know him
                st.push(idx1);
            }
        }

        // now after elemination checking remaining is celeb or not
        int pot = st.pop();

        for (int i = 0; i < arr.length; i++) {
            if (i != pot) {
                if (arr[pot][i] != 0 || arr[i][pot] != 1) {
                    System.out.println("none");
                    return;
                }
            }
        }

        System.out.println(pot);
    }
}
