import java.util.ArrayList;
import java.util.LinkedList;

// https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/left-view-of-a-binarytree/ojquestion

public class l044_LeftViewOfBinaryTree {
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;

        LinkedList<Node> que = new LinkedList<>();
        que.addLast(root);

        while (que.size() > 0) {
            int size = que.size(); // current level size
            ans.add(que.getFirst().data); // getting first node of each level

            while (size-- > 0) {
                Node rn = que.removeFirst();

                if (rn.left != null)
                    que.addLast(rn.left);
                if (rn.right != null)
                    que.addLast(rn.right);
            }
        }

        return ans;
    }
}
