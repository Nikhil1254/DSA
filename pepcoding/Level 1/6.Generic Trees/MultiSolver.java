import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class MultiSolver {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

    public static int size(Node node) {
        // write your code here
        int size = 0;

        for (Node child : node.children)
            size += size(child);

        return size + 1;
    }

    static int size;
    static int height;
    static int max;
    static int min;

    public static void multiSolver(Node node,int depth) {
        size++;
        height = Math.max(height, depth);
        min = Math.min(min,node.data);
        max = Math.max(max, node.data);

        for(Node child : node.children)
            multiSolver(child, depth+1);

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        // int sz = size(root);
        // System.out.println(sz);
        // display(root);
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        size = 0;
        height = 0;
        multiSolver(root,0);
        System.out.println("size : " + size + "\nheight :" + height + "\nmin : " + min + "\nmax : " + max);
    }
}
