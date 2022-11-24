// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/ 

public class l028_PreorderToBST {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, -(int) 1e9, (int) 1e9, new int[] { 0 });
    }

    private TreeNode bstFromPreorder(int[] preorder, int lr, int rr, int[] idx) {
        int i = idx[0];
        if (i == preorder.length || preorder[i] < lr || preorder[i] > rr)
            return null;

        TreeNode root = new TreeNode(preorder[i]);
        idx[0]++;

        root.left = bstFromPreorder(preorder, lr, root.val, idx); // left call
        root.right = bstFromPreorder(preorder, root.val, rr, idx); // right call

        return root;
    }
}
