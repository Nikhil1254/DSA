import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/vertical-order-traversal-of-a-binarytree/ojquestion

public class l04_VerticalOrderTraversalOfBinaryTree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        if (root == null)
            return ans;

        // getinng width of tree
        int[] minMax = new int[2];
        widthOfShadow(root, 0, minMax);
        int width = minMax[1] - minMax[0] + 1;

        // filling arraylist
        for (int idx = 0; idx < width; idx++)
            ans.add(new ArrayList<>());

        // level order traversal - BFS
        LinkedList<Pair> que = new LinkedList<>();
        que.addLast(new Pair(root, Math.abs(minMax[0])));

        while (que.size() > 0) {
            int size = que.size();

            while (size-- > 0) {
                Pair rp = que.removeFirst();
                TreeNode node = rp.node;
                int vl = rp.vl;

                ans.get(vl).add(node.val);

                if (node.left != null)
                    que.addLast(new Pair(node.left, vl - 1));
                if (node.right != null)
                    que.addLast(new Pair(node.right, vl + 1));
            }
        }

        return ans;

    }

    static class Pair {
        TreeNode node = null;
        int vl = 0;

        Pair(TreeNode node, int vl) {
            this.node = node;
            this.vl = vl;
        }
    }

    private static void widthOfShadow(TreeNode root, int vl, int[] minMax) {
        if (root == null)
            return;

        minMax[0] = Math.min(vl, minMax[0]);
        minMax[1] = Math.max(vl, minMax[1]);

        widthOfShadow(root.left, vl - 1, minMax);
        widthOfShadow(root.right, vl + 1, minMax);
    }

    // input_section=================================================

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

        ArrayList<ArrayList<Integer>> ans = verticalOrderTraversal(root);
        int idx = 0;
        for (ArrayList<Integer> i : ans) {
            System.out.print(idx++ + " -> ");
            for (Integer j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}
