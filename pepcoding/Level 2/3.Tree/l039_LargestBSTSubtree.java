// https://practice.geeksforgeeks.org/problems/largest-bst/1

public class l039_LargestBSTSubtree {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    static class BSTPair {
        boolean isBST = true; // if current root tree is BST
        int BSTSize = 0; // largest BST subtree size
        int min = (int) 1e9;
        int max = -(int) 1e9;
        Node BSTNode = null; // largest BST subtree root
    }

    static int largestBst(Node root) {
        // Write your code here
        return BSTPair_helper(root).BSTSize;
    }

    private static BSTPair BSTPair_helper(Node root) {
        if (root == null)
            return new BSTPair();

        BSTPair lp = BSTPair_helper(root.left);
        BSTPair rp = BSTPair_helper(root.right);

        BSTPair mp = new BSTPair();
        mp.isBST = lp.isBST && rp.isBST && ((lp.max < root.data) && (rp.min > root.data));
        mp.min = Math.min(root.data, Math.min(lp.min, rp.min));
        mp.max = Math.max(root.data, Math.max(lp.max, rp.max));

        if (mp.isBST) {
            mp.BSTSize = lp.BSTSize + rp.BSTSize + 1;
        } else {
            mp.BSTSize = Math.max(lp.BSTSize, rp.BSTSize);
        }

        return mp;
    }
}
