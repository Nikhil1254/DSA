import java.util.Scanner;

// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/convert-binary-search-tree-to-doubly-linked-list/ojquestion

public class l024_BSTToCircularDLL {
    public static Scanner scn = new Scanner(System.in);

    public static class Node {
        int val = 0;
        Node left = null;
        Node right = null;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node bToDLL(Node root) {
        Node curr = root;
        Node dummy = new Node(-1), prev = dummy;

        while (curr != null) {
            Node left = curr.left;
            if (left == null) {
                prev.right = curr;
                curr.left = prev;
                prev = prev.right;

                curr = curr.right;
            } else {
                Node rightMostNode = getRightMost(left, curr);
                if (rightMostNode.right == null) {
                    // thread creation block
                    rightMostNode.right = curr;
                    curr = curr.left;
                } else {
                    // thread destroy block
                    rightMostNode.right = null;

                    prev.right = curr;
                    curr.left = prev;

                    prev = prev.right;
                    curr = curr.right;
                }
            }
        }

        Node head = dummy.right;
        head.left = dummy.right = null;
        head.left = prev;
        prev.right = head;

        return head;
    }

    public static Node getRightMost(Node node, Node curr) {
        while (node.right != null && node.right != curr)
            node = node.right;

        return node;
    }

    // input_section=================================================

    public static void display(Node node) {
        Node head = node;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.right;
            if (node == head)
                break;
        }

    }

    public static Node constructFromInOrder_(int[] in, int si, int ei) {
        if (si > ei)
            return null;

        int mid = (si + ei) / 2;
        Node node = new Node(in[mid]);

        node.left = constructFromInOrder_(in, si, mid - 1);
        node.right = constructFromInOrder_(in, mid + 1, ei);

        return node;
    }

    public static Node constructFromInOrder(int[] inOrder) {
        int n = inOrder.length;
        return constructFromInOrder_(inOrder, 0, n - 1);
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        Node root = constructFromInOrder(in);
        root = bToDLL(root);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
