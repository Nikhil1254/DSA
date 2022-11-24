import java.util.ArrayList;

// https://www.codingninjas.com/codestudio/problems/predecessor-and-successor_920476?leftPanelTab=0

// finding predecessor and successor in binary tree using morris traversal
// time - O(n) , space = O(1)
public class l040_predecessorAndSuccessorInBinaryTree {
    class binaryTreeNode {

        int data;
        binaryTreeNode left;
        binaryTreeNode right;

        binaryTreeNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static ArrayList<Integer> findPreSuc(binaryTreeNode root, int key) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        binaryTreeNode pre = null, succ = null, prev = null, curr = root;

        while (curr != null) {
            binaryTreeNode left = curr.left;
            if (left == null) {
                // inorder region
                if (key == curr.data)
                    pre = prev;
                else if (prev != null && prev.data == key)
                    succ = curr;

                prev = curr;
                curr = curr.right;
            } else {
                binaryTreeNode rightMostNode = getRightMostNode(left, curr);
                if (rightMostNode.right == curr) {
                    // thread destroy block- inorder region
                    rightMostNode.right = null;

                    if (key == curr.data)
                        pre = prev;
                    else if (prev != null && prev.data == key)
                        succ = curr;

                    prev = curr;

                    curr = curr.right;
                } else {
                    // thread creation
                    rightMostNode.right = curr;
                    curr = curr.left;
                }
            }
        }

        ans.add(pre != null ? pre.data : -1);
        ans.add(succ != null ? succ.data : -1);

        return ans;
    }

    private static binaryTreeNode getRightMostNode(binaryTreeNode node, binaryTreeNode curr) {
        while (node.right != null && node.right != curr)
            node = node.right;
        return node;
    }
}
