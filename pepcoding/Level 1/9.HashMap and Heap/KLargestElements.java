import java.util.*;
import java.io.*;

public class KLargestElements {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int k = Integer.parseInt(br.readLine());
        // write your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int ele : arr) {
            if (pq.size() < k)
                pq.add(ele);
            else {
                if (ele > pq.peek()) {
                    pq.remove();
                    pq.add(ele);
                }
            }
        }

        while (pq.size() > 0)
            System.out.println(pq.remove());
    }
}
