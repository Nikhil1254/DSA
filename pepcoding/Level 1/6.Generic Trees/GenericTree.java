import java.util.ArrayList;
import java.util.Stack;

public class GenericTree {
    public static class Node {
        int data;
        ArrayList<Node> children;

        Node() {
            this.data = 0;
            this.children = new ArrayList<>();
        }
    }

    public static void display(Node root){

        System.out.print(root.data+" -> ");
        for(Node node : root.children)
            System.out.print(node.data+", ");

        System.out.println(".");

        for(Node node : root.children)
            display(node);
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, 110, -1, 120, -1, 130, -1, -1, -1, 40, 80, -1, 90, -1, -1,
                -1 };

        Stack<Node> st = new Stack<>();
        Node root = null;
        for (int val : arr) {
            if (val == -1)
                st.pop();
            else {
                Node node = new Node();
                node.data = val;

                if (st.size() == 0) {
                    root = node;
                } else {
                    st.peek().children.add(node);
                }
                st.push(node);
            }
        }

        display(root);
    }
}
