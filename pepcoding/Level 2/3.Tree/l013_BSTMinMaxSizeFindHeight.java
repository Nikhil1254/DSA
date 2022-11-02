import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class l013_BSTMinMaxSizeFindHeight {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // function same as binry tree only
    public int height(TreeNode node) {
        return node == null ? -1 : Math.max(height(node.left), height(node.right)) + 1;
    }

    public int size(TreeNode node) {
        return node == null ? 0 : size(node.left) + size(node.right) + 1;
    }

    // using BST property to be more efficient
    public int max(TreeNode root) {
        TreeNode curr = root;
        while (curr.right != null)
            curr = curr.right;

        return curr.val;
    }

    public int min(TreeNode root) {
        TreeNode curr = root;
        while (curr.left != null)
            curr = curr.left;

        return curr.val;
    }

    public boolean find(TreeNode root, int target) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.val == target)
                return true;
            else if (curr.val < target)
                curr = curr.right;
            else
                curr = curr.left;
        }

        return false;
    }

    
}
