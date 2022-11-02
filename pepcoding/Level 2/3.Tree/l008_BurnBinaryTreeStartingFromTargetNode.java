import java.util.*;

//https://www.geeksforgeeks.org/burn-the-binary-tree-starting-from-the-target-node/
//https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/burning-tree-2/ojquestion

public class l008_BurnBinaryTreeStartingFromTargetNode {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<ArrayList<Integer>> burningTree(TreeNode root, int data) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        burningTreeHelper(root, data, list); // funcion
        return list;
    }

    public static int burningTreeHelper(TreeNode node, int data, ArrayList<ArrayList<Integer>> list) {
        if (node == null)
            return -1;

        if (node.val == data) {
            kDown(node, null, 0, list); // function
            return 1;
        }

        int left = burningTreeHelper(node.left, data, list);
        if (left != -1) {
            kDown(node, node.left, left, list);
            return left + 1;
        }

        int right = burningTreeHelper(node.right, data, list);
        if (right != -1) {
            kDown(node, node.right, right, list);
            return right + 1;
        }

        return -1;
    }

    public static void kDown(TreeNode node, TreeNode blockNode, int time, ArrayList<ArrayList<Integer>> list) {
        if (node == null || node == blockNode)
            return;

        if (list.size() == time) {
            list.add(new ArrayList<Integer>());
        }

        list.get(time).add(node.val);

        kDown(node.left, blockNode, time + 1, list);
        kDown(node.right, blockNode, time + 1, list);
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

        ArrayList<ArrayList<Integer>> ans = burningTree(root, fireNode);
        if (ans.size() == 0)
            System.out.println();
        for (ArrayList<Integer> ar : ans) {
            for (Integer ele : ar)
                System.out.print(ele + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}
