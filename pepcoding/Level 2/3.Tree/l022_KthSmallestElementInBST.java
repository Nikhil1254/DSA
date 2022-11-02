// done using morris traversal
// https://leetcode.com/problems/kth-smallest-element-in-a-bst/

public class l022_KthSmallestElementInBST {

    class TreeNode{
        int val ;
        TreeNode left ;
        TreeNode right ;

        public TreeNode(int val){
            this.val = val ;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        TreeNode curr = root;
        int ans = -1;

        while (curr != null) {
            TreeNode left = curr.left;
            if (left == null) {
                if (--k == 0)
                    ans = curr.val;
                curr = curr.right;
            } else {
                TreeNode rightMostNode = getRightMostNode(left, curr);
                if (rightMostNode.right == null) {
                    // thread creation block
                    rightMostNode.right = curr;
                    curr = curr.left;
                } else {
                    // thread cut block
                    rightMostNode.right = null;
                    if (--k == 0)
                        ans = curr.val;
                    curr = curr.right;
                }
            }
        }

        return ans;
    }

    private TreeNode getRightMostNode(TreeNode node, TreeNode curr) {
        while (node.right != null && node.right != curr)
            node = node.right;
        return node;
    }
}
