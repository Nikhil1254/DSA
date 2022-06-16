import java.util.*;
import java.io.*;

public class EfficientHeapConstructor {
    public static class PriorityQueue {
        ArrayList<Integer> data;

        public PriorityQueue() {
            data = new ArrayList<>();
        }

        // nlogn constructor
        // public PriorityQueue(int[] arr) {
        // data = new ArrayList<>();
        // for(int val : arr)
        // add(val);
        // }

        // efficient heap constructor - n
        public PriorityQueue(int[] arr) throws Exception {
            data = new ArrayList<>();
            for (int val : arr)
                data.add(val);

            for (int i = (data.size() / 2 - 1); i >= 0; i--)
                downheapify(i);

        }

        private void display(int[] arr) {
            for (int i = 0; i < arr.length; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
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
        int[] arr = { 11, 3, 12, 5, 2, 1 };

        PriorityQueue pq = new PriorityQueue(arr);
        while (pq.size() > 0)
            System.out.println(pq.remove());

        System.out.println();
    }

}
