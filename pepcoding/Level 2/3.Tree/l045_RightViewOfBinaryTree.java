import java.util.ArrayList;
import java.util.LinkedList;

// https://practice.geeksforgeeks.org/problems/right-view-of-binary-tree/1
// https://leetcode.com/problems/binary-tree-right-side-view/
// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/right-view-of-a-binarytree/ojquestion

public class l045_RightViewOfBinaryTree {
    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    ArrayList<Integer> rightView(Node root) {
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

                if (rn.right != null)
                    que.addLast(rn.right);
                if (rn.left != null)
                    que.addLast(rn.left);
            }
        }

        return ans;
    }
}