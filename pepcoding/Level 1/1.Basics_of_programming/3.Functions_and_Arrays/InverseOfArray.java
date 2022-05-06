import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InverseOfArray {
    public static void display(int[] a) {

        for (int val : a) {
            System.out.println(val);
        }
        
    }

    public static int[] inverse(int[] a) {
        // write your code here
        int[] res = new int[a.length];

        for (int idx = 0; idx < a.length; idx++) {
            res[a[idx]] = idx;
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] inv = inverse(a);
        display(inv);
    }
}
