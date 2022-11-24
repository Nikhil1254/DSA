import java.util.ArrayList;
import java.util.LinkedList;

// https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

public class l050_TopViewOfBinaryTree {
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

    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<Integer>();

        if (root == null)
            return null;

        LinkedList<Pair> que = new LinkedList<>(); // Pair class

        int[] minMax = new int[2];
        getShadowWidth(root, 0, minMax); // function
        int width = minMax[1] - minMax[0] + 1;

        que.addLast(new Pair(root, Math.abs(minMax[0])));
        for (int idx = 0; idx < width; idx++)
            ans.add(null);

        while (que.size() > 0) {
            int size = que.size();
            while (size-- > 0) {
                Pair rp = que.removeFirst();
                Node node = rp.node;
                int vl = rp.vl;

                ans.set(vl, ans.get(vl) != null ? ans.get(vl) : node.data);
                if (node.left != null)
                    que.addLast(new Pair(node.left, vl - 1));
                if (node.right != null)
                    que.addLast(new Pair(node.right, vl + 1));
            }
        }

        return ans;
    }

    static class Pair {
        Node node;
        int vl;

        Pair(Node node, int vl) {
            this.node = node;
            this.vl = vl;
        }
    }

    private static void getShadowWidth(Node root, int vl, int[] minMax) {
        if (root == null)
            return;

        minMax[0] = Math.min(vl, minMax[0]);
        minMax[1] = Math.max(vl, minMax[1]);

        getShadowWidth(root.left, vl - 1, minMax);
        getShadowWidth(root.right, vl + 1, minMax);
    }
}
