// https://practice.geeksforgeeks.org/problems/predecessor-and-successor/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article


// Using BST property we have done it , Time - O(log(n)) , space - O(1)
public class l041_PredecessorAndSuccessorInBST {

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    class Res {
        Node pre = null;
        Node succ = null;
    }

    public static void findPreSuc(Node root, Res p, Res s, int key) {
        // add your code here

        Node pre = null, succ = null, curr = root;
        while (curr != null) {
            if (key < curr.data) {
                // moving to left side
                succ = curr;
                curr = curr.left;
            } else if (key > curr.data) {
                // moving to right side
                pre = curr;
                curr = curr.right;
            } else {
                // data found
                Node leftMostNode = getLeftMost(curr.right);
                Node rightMostNode = getRightMost(curr.left);

                pre = rightMostNode != null ? rightMostNode : pre;
                succ = leftMostNode != null ? leftMostNode : succ;
                break;
            }
        }

        p.pre = pre;
        s.succ = succ;
    }

    private static Node getLeftMost(Node node) {
        if (node == null)
            return null;

        while (node.left != null)
            node = node.left;
        return node;
    }

    private static Node getRightMost(Node node) {
        if (node == null)
            return null;

        while (node.right != null)
            node = node.right;
        return node;
    }
}
