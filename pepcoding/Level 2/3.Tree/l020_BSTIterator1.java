import java.util.Scanner;

// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/bst-iterator/ojquestion
// https://leetcode.com/problems/binary-search-tree-iterator/

// done using morris traversal

public class l020_BSTIterator1 {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static class BSTIterator {
        private TreeNode curr = null;

        public BSTIterator(TreeNode root) {
            this.curr = root;
        }

        public int next() {
            int rv = -1; // removed value
            while (curr != null) {
                TreeNode left = curr.left;
                if (left == null) {
                    rv = curr.val;
                    curr = curr.right;
                    break;
                } else {
                    TreeNode rightMostNode = getRightMostNode(left, curr);
                    if (rightMostNode.right == null) {
                        // thread creation block
                        rightMostNode.right = curr;
                        curr = curr.left;
                    } else {
                        // thread destroy block
                        rightMostNode.right = null;
                        rv = curr.val;
                        curr = curr.right;
                        break;
                    }
                }
            }

            return rv;
        }

        public boolean hasNext() {
            return curr != null;
        }

        private TreeNode getRightMostNode(TreeNode node, TreeNode curr) {
            while (node.right != null && node.right != curr)
                node = node.right;

            return node;
        }
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static TreeNode constructFromInOrder_(int[] in, int si, int ei) {
        if (si > ei)
            return null;

        int mid = (si + ei) / 2;
        TreeNode node = new TreeNode(in[mid]);

        node.left = constructFromInOrder_(in, si, mid - 1);
        node.right = constructFromInOrder_(in, mid + 1, ei);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = constructFromInOrder_(in, 0, in.length - 1);
        BSTIterator itr = new BSTIterator(root);
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    public static void main(String[] args) {
        solve();
    }
}
