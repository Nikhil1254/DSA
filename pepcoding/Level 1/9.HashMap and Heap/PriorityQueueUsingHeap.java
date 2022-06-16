import java.util.*;
import java.io.*;

public class PriorityQueueUsingHeap {
    public static class PriorityQueue {
        ArrayList<Integer> data;

        public PriorityQueue() {
            data = new ArrayList<>();
        }

        // nlogn constructor
        public PriorityQueue(int[] arr) {
        data = new ArrayList<>();
        for (int val : data)
        add(val);
        }

        

        public void add(int val) {
            // write your code here
            this.data.add(val);
            upheapify(this.size() - 1);
        }

        public void upheapify(int ci) {
            if (ci == 0)
                return;

            int pi = (ci - 1) / 2; // parent idx

            if (this.data.get(ci) < this.data.get(pi)) {
                swap(ci, pi);
                upheapify(pi);
            }
        }

        public void swap(int i, int j) {
            int ith = this.data.get(i);
            int jth = this.data.get(j);

            this.data.set(i, jth);
            this.data.set(j, ith);
        }

        public int remove() {
            // write your code here
            if (this.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }

            swap(0, this.size() - 1);
            int val = this.data.remove(this.size() - 1);
            downheapify(0);
            return val;
        }

        public void downheapify(int pi) {
            int minIdx = pi; // min index

            int li = 2 * pi + 1; // left child index

            if (li < data.size() && this.data.get(li) < this.data.get(minIdx))
                minIdx = li;

            int ri = pi * 2 + 2;
            if (ri < this.size() && this.data.get(ri) < this.data.get(minIdx))
                minIdx = ri;

            if (minIdx != pi) {
                swap(pi, minIdx);
                downheapify(minIdx);
            }
        }

        public int peek() {
            // write your code here
            if (this.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }

            return this.data.get(0);
        }

        public int size() {
            // write your code here
            return this.data.size();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue qu = new PriorityQueue();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("add")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if (str.startsWith("remove")) {
                int val = qu.remove();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("peek")) {
                int val = qu.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(qu.size());
            }
            str = br.readLine();
        }
    }
}
