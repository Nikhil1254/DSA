import java.util.Scanner;

// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/levelup_validate-bst/ojquestion
// https://leetcode.com/problems/validate-binary-search-tree/submissions/


// Using morris traversal - without using extra space
public class l018_IsValidBST1 {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isValidBST(TreeNode root) {
        TreeNode curr = root;
        long prev = -(long) 1e13;
        boolean flag = true;

        while (curr != null) {
            TreeNode left = curr.left;
            if (left == null) {
                // checking
                if (prev >= curr.val)
                    flag = false;
                prev = curr.val;

                curr = curr.right;
            } else {
                TreeNode rightMostNode = getRightMostNode(left, curr);
                if (rightMostNode.right == null) {
                    // thread creation block
                    rightMostNode.right = curr;
                    curr = curr.left;
                } else {
                    // thread destroy block
                    rightMostNode.right = null;
                    // checking
                    if (prev >= curr.val)
                        flag = false;
                    prev = curr.val;
                    curr = curr.right;
                }
            }
        }

        return flag;
    }

    public static TreeNode getRightMostNode(TreeNode node, TreeNode curr) {
        while (node.right != null && node.right != curr)
            node = node.right;

        return node;
    }

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }

        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);
        System.out.println(isValidBST(root));
    }

    public static void main(String[] args) {
        solve();
    }
}
