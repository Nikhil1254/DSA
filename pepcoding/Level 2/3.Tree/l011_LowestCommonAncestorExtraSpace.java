import java.util.ArrayList;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
// Bruteforce - using extra space .

public class l011_LowestCommonAncestorExtraSpace {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> pPathToRoot = new ArrayList<>();
        ArrayList<TreeNode> qPathToRoot = new ArrayList<>();

        nodeToRootPath(root, p, pPathToRoot);
        nodeToRootPath(root, q, qPathToRoot);

        // if p or q or both does not exist
        if (pPathToRoot.size() == 0 || qPathToRoot.size() == 0)
            return null;

        int p1 = pPathToRoot.size() - 1, p2 = qPathToRoot.size() - 1;

        while (p1 >= 0 && p2 >= 0 && pPathToRoot.get(p1) == qPathToRoot.get(p2)) {
            p1--;
            p2--;
        }

        return pPathToRoot.get(++p1);
    }

    public boolean nodeToRootPath(TreeNode node, TreeNode target, ArrayList<TreeNode> path) {
        if (node == null)
            return false;

        if (node == target) {
            path.add(node);
            return true;
        }

        boolean lt = nodeToRootPath(node.left, target, path);
        if (lt) {
            path.add(node);
            return true;
        }

        boolean rt = nodeToRootPath(node.right, target, path);
        if (rt) {
            path.add(node);
            return true;
        }

        return false;
    }
}