import java.util.Stack;

public class ConstructBinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    static Node constructBinaryTree(Integer[] arr) {
        Stack<Pair> st = new Stack<>();
        Node root = new Node(arr[0]);

        int idx = 1;
        st.push(new Pair(root, 1));

        while (st.size() > 0) {
            Pair top = st.peek();

            if (top.state == 1) {
                Integer data = arr[idx];

                if (data != null) {
                    Node node = new Node(data);
                    top.node.left = node;
                    st.push(new Pair(node, 1));
                } else
                    top.node.left = null;
                idx++;
                top.state++;

            } else if (top.state == 2) {
                Integer data = arr[idx];

                if (data != null) {
                    Node node = new Node(data);
                    top.node.right = node;
                    st.push(new Pair(node, 1));
                } else
                    top.node.right = null;
                idx++;
                top.state++;
            } else
                st.pop();
        }

        return root;
    }

    static void display(Node node) {
        if (node == null)
            return;

        String str = "";

        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data;

        System.out.println(str);

        display(node.left);

        display(node.right);
    }

    public static void main(String[] args) {
        Integer[] arr = { 10, 20, 40, null, null, 50, 60, null, null, null, 30, null, 70, 80, 90, null, null, 100, null,
                null, null };

        Node root = constructBinaryTree(arr);

        display(root);
    }
}
