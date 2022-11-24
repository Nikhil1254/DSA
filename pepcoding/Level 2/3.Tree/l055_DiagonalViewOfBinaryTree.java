import java.util.ArrayList;
import java.util.LinkedList;

public class l055_DiagonalViewOfBinaryTree {
    class Node {
        int data;
        Node left, right;
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
            ans.add(que.getFirst().node.data);
            while (size-- > 0) {
                Pair rp = que.removeFirst();
                Node node = rp.node;
                int dl = rp.dl;

                while (node != null) {
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
