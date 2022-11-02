import java.util.*;

//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/submissions/
//https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/all-nodes-distance-k-in-binarytree/ojquestion

public class l006_AllNodesKDistanceAwayBinaryTreeExtraSpace {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<Integer> distanceK(TreeNode root, int target, int k) {
        ArrayList<TreeNode> path = new ArrayList<>();
        nodeToRootPath(root, target, path);
        ArrayList<Integer> list = new ArrayList<>();

        kDown(path.get(0), null, k, list);
        for (int idx = 1; idx < path.size(); idx++)
            kDown(path.get(idx), path.get(idx - 1), k - idx, list);

        return list;
    }

    public static boolean nodeToRootPath(TreeNode node, int target, ArrayList<TreeNode> path) {
        if (node == null)
            return false;

        if (node.val == target) {
            path.add(node);
            return true;
        }

        boolean left = nodeToRootPath(node.left, target, path);
        if (left) {
            path.add(node);
            return true;
        }

        boolean right = nodeToRootPath(node.right, target, path);
        if (right) {
            path.add(node);
            return true;
        }

        return false;
    }

    public static void kDown(TreeNode node, TreeNode blockNode, int k, ArrayList<Integer> list) {
        if (node == null || node == blockNode || k < 0)
            return;

        if (k == 0) {
            list.add(node.val);
            return;
        }

        kDown(node.left, blockNode, k - 1, list);
        kDown(node.right, blockNode, k - 1, list);
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
        int target = scn.nextInt();
        int k = scn.nextInt();

        ArrayList<Integer> ans = distanceK(root, target, k);
        if (ans.size() == 0)
            System.out.println();
        for (Integer ele : ans)
            System.out.println(ele + " ");

    }

    public static void main(String[] args) {
        solve();
    }
}
