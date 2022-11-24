import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

// left diagonal sum it is
// https://pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/diagonal-order-sum-of-a-binary-tree/ojquestion

public class l054_DiagonalSumOfBinaryTree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<Integer> diagonalOrderSum(TreeNode root) {

        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null)
            return ans;

        // BFS traversal
        LinkedList<Pair> que = new LinkedList<>();
        que.addLast(new Pair(root, 0));

        while (que.size() > 0) {
            int size = que.size();
            ans.add(0);
            while (size-- > 0) {
                Pair rp = que.removeFirst();
                TreeNode node = rp.node;
                int vl = rp.vl;

                while (node != null) {
                    ans.set(vl, ans.get(vl) + node.val);
                    if (node.left != null)
                        que.addLast(new Pair(node.left, vl + 1));
                    node = node.right;
                }

            }
        }

        return ans;
    }

    static class Pair {
        TreeNode node = null;
        int vl = -1;

        Pair(TreeNode node, int vl) {
            this.node = node;
            this.vl = vl;
        }
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

        ArrayList<Integer> ans = diagonalOrderSum(root);
        for (Integer j : ans)
            System.out.print(j + " ");

    }

    public static void main(String[] args) {
        solve();
    }
}
