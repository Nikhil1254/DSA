// https://practice.geeksforgeeks.org/problems/level-order-traversal/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
// https://leetcode.com/problems/binary-tree-level-order-traversal/

import java.util.ArrayList;
import java.util.List;


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

    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        levelOrder(root, ans, 0);

        return (List) ans;
    }

    private void levelOrder(TreeNode root, ArrayList<ArrayList<Integer>> ans, int level) {
        if (root == null)
            return;

        if (ans.size() == level)
            ans.add(new ArrayList<>());

        ans.get(level).add(root.val);

        levelOrder(root.left, ans, level + 1);
        levelOrder(root.right, ans, level + 1);

    }
}
