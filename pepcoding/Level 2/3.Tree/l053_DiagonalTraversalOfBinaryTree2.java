import java.util.ArrayList;
import java.util.LinkedList;

// This is gfg order , node and it's all child in that level first then next node
// https://practice.geeksforgeeks.org/problems/diagonal-traversal-of-binary-tree/1

public class l053_DiagonalTraversalOfBinaryTree2 {
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

    public ArrayList<Integer> diagonal(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null)
            return ans;

        // BFS traversal
        LinkedList<Pair> que = new LinkedList<>();
        que.addLast(new Pair(root, 0));

        while (que.size() > 0) {
            int size = que.size();

            while (size-- > 0) {
                Pair rp = que.removeFirst();
                Node node = rp.node;
                int dl = rp.dl;

                while (node != null) {
                    ans.add(node.data);
                    if (node.left != null)
                        que.addLast(new Pair(node.left, dl + 1));
                    node = node.right;
                }

            }
        }

        return ans;
    }

    class Pair {
        Node node = null;
        int dl = -1;

        Pair(Node node, int dl) {
            this.node = node;
            this.dl = dl;
        }
    }
}
