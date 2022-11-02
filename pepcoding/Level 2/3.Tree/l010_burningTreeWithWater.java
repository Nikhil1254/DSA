import java.util.HashSet;
import java.util.ArrayList;

public class l010_burningTreeWithWater {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<ArrayList<Integer>> burningTree(TreeNode root, int tar) {
        HashSet<Integer> waterSet = new HashSet<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        burningTreeHelper(root, tar, waterSet, ans); // funcion
        System.out.println(ans);
        return ans;
    }

    // -1 : indicates we did not found our target
    // -2 : indicates we found target but there is water
    public static int burningTreeHelper(TreeNode node, int tar, HashSet<Integer> waterSet,
            ArrayList<ArrayList<Integer>> ans) {
        if (node == null)
            return -1;

        boolean isWater = waterSet.contains(node.val);
        if (node.val == tar) {
            if (!isWater) {
                burnNodes(node, null, 0, waterSet, ans);
                return 1;
            }

            return -2; // it means we got target but it has water
        }

        int lt = burningTreeHelper(node.left, tar, waterSet, ans);
        if (lt > 0) {
            if (!isWater) {
                burnNodes(node, node.left, lt, waterSet, ans);
                return lt + 1;
            }
            return -2;
        }

        if (lt == -2)
            return -2;

        int rt = burningTreeHelper(node.right, tar, waterSet, ans);
        if (rt > 0) {
            if (!isWater) {
                burnNodes(node, node.right, rt, waterSet, ans);
                return rt + 1;
            }

            return -2;
        }

        if (rt == -2)
            return -2;

        return -1;
    }

    public static void burnNodes(TreeNode node, TreeNode blockNode, int time, HashSet<Integer> waterSet,
            ArrayList<ArrayList<Integer>> ans) {
        if (node == null || node == blockNode || waterSet.contains(node.val))
            return;

        if (time == ans.size())
            ans.add(new ArrayList<>());

        ans.get(time).add(node.val);
        burnNodes(node.left, blockNode, time + 1, waterSet, ans);
        burnNodes(node.right, blockNode, time + 1, waterSet, ans);
    }

}
