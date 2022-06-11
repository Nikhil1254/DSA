import java.util.*;
import java.io.*;

public class IsBalance {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    static class BalancePair {
        boolean isBal;
        int ht;

        BalancePair(boolean isBal, int ht) {
            this.isBal = isBal;
            this.ht = ht;
        }
    }

    public static BalancePair isBalance1(Node node) {
        if (node == null)
            return new BalancePair(true, -1);

        BalancePair lp = isBalance1(node.left);
        BalancePair rp = isBalance1(node.right);

        int ht = Math.max(lp.ht, rp.ht) + 1;
        boolean bal = lp.isBal && rp.isBal && (Math.abs(lp.ht - rp.ht) <= 1);

        return new BalancePair(bal, ht);
    }

    static boolean isBal = true;

    public static int isBalance2(Node node) {
        if (node == null)
            return -1;

        int lh = isBalance2(node.left);
        int rh = isBalance2(node.right);

        if (Math.abs(lh - rh) > 1)
            isBal = false;

        return Math.max(lh, rh) + 1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }

        Node root = construct(arr);

        // write your code here
        System.out.println(isBalance1(root).isBal);
        isBalance2(root);
        System.out.println(isBal);
    }
}
