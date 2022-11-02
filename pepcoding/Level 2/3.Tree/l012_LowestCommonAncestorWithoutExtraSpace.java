public class l012_LowestCommonAncestorWithoutExtraSpace {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode lca = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lcaHelper(root, p, q);
        return lca;
    }

    public boolean lcaHelper(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null)
            return false;

        boolean selfPresent = (node == p || node == q);

        boolean leftPresent = lcaHelper(node.left, p, q);
        if (lca != null)
            return true;

        boolean rightPresent = lcaHelper(node.right, p, q);
        if (lca != null)
            return true;

        if ((leftPresent && rightPresent) || (leftPresent && selfPresent) || (rightPresent && selfPresent))
            lca = node;

        return leftPresent || rightPresent || selfPresent;
    }
}
