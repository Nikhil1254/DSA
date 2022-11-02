import java.util.*;

//https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/all-single-child-parent-in-binary-tree/ojquestion

public class l004_AllSingleChildParentInBinaryTree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<Integer> exactlyOneChild(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        parentWithSingleChild(root, ans);
        return ans;
    }

    public static void parentWithSingleChild(TreeNode node, ArrayList<Integer> ans) {
        if (node == null || (node.left == null && node.right == null)) // if ts null or its a leaf node
            return;

        if (node.left == null || node.right == null) // if node has only one child
            ans.add(node.val);

        parentWithSingleChild(node.left, ans);
        parentWithSingleChild(node.right, ans);
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

        ArrayList<Integer> ans = exactlyOneChild(root);
        if (ans.size() == 0)
            System.out.println();
        for (Integer ele : ans)
            System.out.print(ele + " ");
    }

    public static void main(String[] args) {
        solve();
    }
}
