import java.io.*;
import java.util.*;

public class MergeKSortedLists {

    static class Pair {
        int li; // list index
        int di; // data index
        int val; // value present in corresponding list at di

        Pair(int li, int di, int val) {
            this.li = li;
            this.di = di;
            this.val = val;
        }
    }

    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {
        ArrayList<Integer> rv = new ArrayList<>();

        // write your code here
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.val - p2.val);

        // filling priority queue with first value of each list
        for (int i = 0; i < lists.size(); i++) {
            pq.add(new Pair(i, 0, lists.get(i).get(0)));
        }

        // building answer
        while (pq.size() > 0) {
            Pair p = pq.remove();
            rv.add(p.val);
            p.di++;

            if (p.di < lists.get(p.li).size()) {
                p.val = lists.get(p.li).get(p.di);
                pq.add(p);
            }
        }
        return rv;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ArrayList<Integer> list = new ArrayList<>();

            int n = Integer.parseInt(br.readLine());
            String[] elements = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                list.add(Integer.parseInt(elements[j]));
            }

            lists.add(list);
        }

        ArrayList<Integer> mlist = mergeKSortedLists(lists);
        for (int val : mlist) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

}
