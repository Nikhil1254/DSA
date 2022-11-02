import java.util.*;

// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/node-to-root-path-binary-tree/ojquestion

public class l002_nodeToRootPath {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<TreeNode> nodeToRootPath(TreeNode node, int data) {
        // ArrayList<TreeNode> list = new ArrayList<>() ;
        // nodeToRootPath_1(node,data,list) ;
        // return list ;
        return nodeToRootPath_2(node, data);
    }

    // returning ArrayList -
    public static ArrayList<TreeNode> nodeToRootPath_2(TreeNode node, int data) {
        if (node == null)
            return new ArrayList<TreeNode>();

        if (node.val == data) {
            ArrayList<TreeNode> list = new ArrayList<>();
            list.add(node);
            return list;
        }

        ArrayList<TreeNode> left = nodeToRootPath_2(node.left, data);
        if (left.size() != 0) {
            left.add(node);
            return left;
        }

        ArrayList<TreeNode> right = nodeToRootPath_2(node.right, data);
        if (right.size() != 0) {
            right.add(node);
            return right;
        }

        return new ArrayList<TreeNode>();
    }

    // passing arraylist as an argument -
    public static boolean nodeToRootPath_1(TreeNode node, int data, ArrayList<TreeNode> ans) {
        if (node == null)
            return false;

        if (node.val == data) {
            ans.add(node);
            return true;
        }

        boolean res = nodeToRootPath_1(node.left, data, ans) || nodeToRootPath_1(node.right, data, ans);

        if (res)
            ans.add(node);

        return res;
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

        int data = scn.nextInt();
        ArrayList<TreeNode> ans = nodeToRootPath(root, data);
        if (ans.size() == 0)
            System.out.println();
        for (TreeNode node : ans)
            System.out.print(node.val + " ");

    }

    public static void main(String[] args) {
        solve();
    }
}