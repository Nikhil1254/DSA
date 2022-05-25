import java.util.*;

public class LargestAreaHistogram {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int idx = 0; idx < arr.length; idx++)
            arr[idx] = scn.nextInt();

        System.out.println(solution(arr));
    }

    public static int solution(int[] arr) {
        int[] nsetl = nextSmallerElementToLeft(arr);
        int[] nsetr = nextSmallerElementToRight(arr);

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int w = nsetr[i] - nsetl[i] - 1;
            int h = arr[i];
            int area = w * h;
            if (area > max)
                max = area;
        }

        return max;
    }

    public static int[] nextSmallerElementToLeft(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (st.size() > 0 && arr[i] <= arr[st.peek()])
                st.pop();

            if (st.size() == 0)
                res[i] = -1;
            else
                res[i] = st.peek();

            st.push(i);
        }

        return res;
    }

    public static int[] nextSmallerElementToRight(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (st.size() > 0 && arr[i] <= arr[st.peek()])
                st.pop();

            if (st.size() == 0)
                res[i] = arr.length;
            else
                res[i] = st.peek();

            st.push(i);
        }

        return res;
    }
}
