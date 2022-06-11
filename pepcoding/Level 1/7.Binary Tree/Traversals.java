import java.util.*;

public class Traversals {
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

    public static int size(Node node) {
        // write your code here
        int size = 0;

        size += node.left == null ? 0 : size(node.left);
        size += node.right == null ? 0 : size(node.right);

        return size + 1;
    }

    public static int sum(Node node) {
        // write your code here
        int sum = node.data;

        sum += node.left == null ? 0 : sum(node.left);
        sum += node.right == null ? 0 : sum(node.right);

        return sum;
    }

    public static int max(Node node) {
        // write your code here
        int max = node.data;

        max = node.left == null ? max : Math.max(max, max(node.left));
        max = node.right == null ? max : Math.max(max, max(node.right));

        return max;
    }

    public static int height(Node node) {
        // write your code here

        int h = -1;

        h = node.left != null ? Math.max(h, height(node.left)) : h;
        h = node.right != null ? Math.max(h, height(node.right)) : h;

        return h + 1;
    }

    static String pre = "";
    static String in = "";
    static String post = "";

    public static void traversals(Node node) {
        pre += node.data + " ";

        if (node.left != null)
            traversals(node.left);

        in += node.data + " ";

        if (node.right != null)
            traversals(node.right);

        post += node.data + " ";
    }

    public static void main(String[] args) throws Exception {
        Integer[] arr = { 10, 20, 40, null, null, 50, 60, null, null, null, 30, null, 70, 80, 90, null, null, 100, null,
                null, null };

        Node root = construct(arr);

        int size = size(root);
        int sum = sum(root);
        int max = max(root);
        int ht = height(root);
        System.out.println(size);
        System.out.println(sum);
        System.out.println(max);
        System.out.println(ht);

        System.out.println("-----------------------------");
        System.out.println("traversals -");
        traversals(root);
        System.out.println("pre - " + pre);
        System.out.println("post - " + post);
        System.out.println("In - " + in);
    }
}
