import java.util.*;

public class l009_TimeToBurnBinaryTree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int max = -1;

    public static int burningTree(TreeNode node, int fireNode) {
        burningTreeHelper(node, fireNode);
        return max;
    }

    public static int burningTreeHelper(TreeNode node, int tar) {
        if (node == null)
            return -1;

        if (node.val == tar) {
            burnNodes(node, null, 0); // function
            return 1;
        }

        int left = burningTreeHelper(node.left, tar);
        if (left != -1) {
            burnNodes(node, node.left, left);
            return left + 1;
        }

        int right = burningTreeHelper(node.right, tar);
        if (right != -1) {
            burnNodes(node, node.right, right);
            return right + 1;
        }

        return -1;
    }

    public static void burnNodes(TreeNode node, TreeNode blockNode, int time) {
        if (node == null || node == blockNode)
            return;

        if (time > max)
            max = time;

        burnNodes(node.left, blockNode, time + 1);
        burnNodes(node.right, blockNode, time + 1);
    }

    // input_section=================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode Treenode = new TreeNode(arr[IDX[0]++]);
        Treenode.left = createTree(arr, IDX);
        Treenode.right = createTree(arr, IDX);

        return Treenode;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);
        int fireNode = scn.nextInt();

        int ans = burningTree(root, fireNode);
        System.out.println(ans);

    }

    public static void main(String[] args) {
        solve();
    }
}