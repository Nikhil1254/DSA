import java.util.*;

// minimum time to burn Binary tree starting from target node
// https://practice.geeksforgeeks.org/problems/burning-tree/1

public class l009_TimeToBurnBinaryTree {

    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static int minTime(Node root, int target) {
        int[] max = { -1 };
        burningTree(root, target, max);
        return max[0];
    }

    private static int burningTree(Node root, int target, int[] max) {
        if (root == null)
            return -1;

        if (root.data == target) {
            burnNodes(root, null, 0, max);
            return 1;
        }

        int left = burningTree(root.left, target, max);
        if (left != -1) {
            burnNodes(root, root.left, left, max);
            return left + 1;
        }

        int right = burningTree(root.right, target, max);
        if (right != -1) {
            burnNodes(root, root.right, right, max);
            return right + 1;
        }

        return -1;
    }

    private static void burnNodes(Node root, Node blockNode, int time, int[] max) {
        if (root == null || root == blockNode)
            return;

        if (time > max[0])
            max[0] = time;

        burnNodes(root.left, blockNode, time + 1, max);
        burnNodes(root.right, blockNode, time + 1, max);
    }
}