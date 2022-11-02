import java.util.ArrayList;

public class l014_BSTNodeToRootPath {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> nodeToRootPath(TreeNode root, int target) {
        ArrayList<Integer> path = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null) {
            path.add(curr.val);

            if (curr.val == target)
                break;
            else if (curr.val < target)
                curr = curr.right;
            else
                curr = curr.left;
        }

        return curr != null ? path : new ArrayList<>();
    }
}
