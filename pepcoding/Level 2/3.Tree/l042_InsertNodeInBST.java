// https://leetcode.com/problems/insert-into-a-binary-search-tree/

// Time - O(log(n)) , space - O(h)
public class l042_InsertNodeInBST {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int data) {
            this.val = data;
        }
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null)
            return new TreeNode(val);

        if (root.val < val)
            root.right = insertIntoBST(root.right, val);
        else if (root.val > val)
            root.left = insertIntoBST(root.left, val);

        return root;
    }
}
