import java.util.Scanner;
import java.util.LinkedList;

// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/levelup_validate-bst/ojquestion
// https://leetcode.com/problems/validate-binary-search-tree/


// using extra space (Stack-linkedList as a stack we have used)
public class l019_isValidBST2 {
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
        LinkedList<TreeNode> st = new LinkedList<>();
        insertAllLeft(root, st);
        long prev = -(long) 1e13;

        while (st.size() > 0) {
            TreeNode rnode = st.removeFirst();
            if (prev >= rnode.val)
                return false;
            prev = rnode.val;
            insertAllLeft(rnode.right, st);
        }

        return true;
    }

    public static void insertAllLeft(TreeNode node, LinkedList<TreeNode> st) {
        while (node != null) {
            st.addFirst(node);
            node = node.left;
        }
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
