import java.util.*;
import java.io.*;

public class TargetSumPair3 {
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

    // we will be applying same stratory we do in sorted array and print tsp
    // but we are not using extra arraylist here instead we know normla inorder
    // means from left to right in sorted array
    // reverse inorder means right to left in sorted array - in BST normal inorder
    // gives increasing order
    // reverse inorder gives decreasing order.

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node getNextFromNormalInorder(Stack<Pair> st) {

        while (st.size() > 0) {
            Pair top = st.peek();

            if (top.state == 0) {
                if (top.node.left != null) {
                    st.push(new Pair(top.node.left, 0));
                }

                top.state++;
            } else if (top.state == 1) {
                if (top.node.right != null)
                    st.push(new Pair(top.node.right, 0));

                top.state++;
                return top.node;
            } else {
                st.pop();
            }
        }

        return null;
    }

    public static Node getNextFromReverseInorder(Stack<Pair> st) {
        while (st.size() > 0) {
            Pair top = st.peek();

            if (top.state == 0) {
                if (top.node.right != null) {
                    st.push(new Pair(top.node.right, 0));
                }

                top.state++;
            } else if (top.state == 1) {
                if (top.node.left != null)
                    st.push(new Pair(top.node.left, 0));

                top.state++;
                return top.node;
            } else {
                st.pop();
            }
        }

        return null;
    }

    public static void tsp(Node root, int tar) {
        Stack<Pair> ls = new Stack<>(); // left to right
        Stack<Pair> rs = new Stack<>(); // right to left

        ls.push(new Pair(root, 0));
        rs.push(new Pair(root, 0));

        Node left = getNextFromNormalInorder(ls);
        Node right = getNextFromReverseInorder(rs);

        while (left != right) {
            if (left.data + right.data == tar) {
                System.out.println(left.data + " " + right.data);
                left = getNextFromNormalInorder(ls);
                right = getNextFromReverseInorder(rs);
            } else if (left.data + right.data < tar) {
                left = getNextFromNormalInorder(ls);
            } else {
                right = getNextFromReverseInorder(rs);
            }
        }
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

        int data = Integer.parseInt(br.readLine());

        Node root = construct(arr);
        // write your code here
        tsp(root, data);
    }
}
