// https://leetcode.com/problems/balanced-binary-tree/

public class l038_BalancedBinaryTree {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    class Pair {
        boolean isBalanced = true;
        int height = -1;
    }

    public boolean isBalanced(TreeNode root) {
        return isBalanced_(root).isBalanced;
    }

    private Pair isBalanced_(TreeNode root) {
        if (root == null)
            return new Pair();

        Pair lp = isBalanced_(root.left); // left pair
        Pair rp = isBalanced_(root.right); // right pair

        Pair ans = new Pair();
        ans.height = Math.max(lp.height, rp.height) + 1;
        ans.isBalanced = lp.isBalanced && rp.isBalanced && (Math.abs(lp.height - rp.height) <= 1);

        return ans;
    }
}
