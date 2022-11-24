import java.util.ArrayList;
import java.util.LinkedList;

// https://practice.geeksforgeeks.org/problems/vertical-sum/1

// Done using BFS - class Soluion
public class l048_VerticalOrderSumInBinaryTree1 {
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public ArrayList<Integer> verticalSum(Node root) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if (root == null)
            return ans;

        // getinng width of tree
        int[] minMax = new int[2];
        widthOfShadow(root, 0, minMax);
        int width = minMax[1] - minMax[0] + 1;

        // filling arraylist
        for (int idx = 0; idx < width; idx++)
            ans.add(0);

        // level order traversal - BFS
        LinkedList<Pair> que = new LinkedList<>();
        que.addLast(new Pair(root, Math.abs(minMax[0])));

        while (que.size() > 0) {
            int size = que.size();

            while (size-- > 0) {
                Pair rp = que.removeFirst();
                Node node = rp.node;
                int vl = rp.vl;

                ans.set(vl, ans.get(vl) + node.data);

                if (node.left != null)
                    que.addLast(new Pair(node.left, vl - 1));
                if (node.right != null)
                    que.addLast(new Pair(node.right, vl + 1));
            }
        }

        return ans;
    }

    static class Pair {
        Node node = null;
        int vl = 0;

        Pair(Node node, int vl) {
            this.node = node;
            this.vl = vl;
        }
    }

    private static void widthOfShadow(Node root, int vl, int[] minMax) {
        if (root == null)
            return;

        minMax[0] = Math.min(minMax[0], vl);
        minMax[1] = Math.max(minMax[1], vl);

        widthOfShadow(root.left, vl - 1, minMax);
        widthOfShadow(root.right, vl + 1, minMax);
    }
}
