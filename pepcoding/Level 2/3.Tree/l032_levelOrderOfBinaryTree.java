// https://practice.geeksforgeeks.org/problems/level-order-traversal/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
// https://leetcode.com/problems/binary-tree-level-order-traversal/

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

// recursive solution - leetcode
// iterative solution leetcode / gfg both I have done using queue

public class l032_levelOrderOfBinaryTree {

    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int data) {
            this.val = data;
        }
    }

    // iterative solution of level order traversal
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;

        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        int level = 0;

        while (que.size() > 0) {
            int size = que.size();
            ans.add(new ArrayList<>());

            while (size-- > 0) {
                TreeNode rn = que.removeFirst();
                ans.get(level).add(rn.val);
                if (rn.left != null)
                    que.addLast(rn.left);
                if (rn.right != null)
                    que.addLast(rn.right);
            }

            level++;
        }

        return ans;
    }
}
