// https://leetcode.com/problems/serialize-and-deserialize-bst/

public class l030_SerializeAndDeserializeBST {

    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        TreeNode curr = root;

        while (curr != null) {
            TreeNode left = curr.left;
            if (left == null) {
                sb.append(curr.val + " "); // preorder
                curr = curr.right;
            } else {
                // left exist
                TreeNode rightMostNode = getRightMostNode(left, curr);
                if (rightMostNode.right == null) {
                    rightMostNode.right = curr;
                    sb.append(curr.val + " "); // preorder region
                    curr = curr.left;
                } else {
                    rightMostNode.right = null;
                    curr = curr.right;
                }
            }
        }

        return sb.toString();
    }

    private TreeNode getRightMostNode(TreeNode node, TreeNode curr) {
        while (node.right != null && node.right != curr)
            node = node.right;
        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data.length() == 0)
            return null;

        String[] pre = data.split(" ");
        int[] preorder = new int[pre.length];

        for (int i = 0; i < pre.length; i++)
            preorder[i] = Integer.parseInt(pre[i]);

        return preorderToBST(preorder, -(int) 1e9, (int) 1e9, new int[] { 0 });
    }

    private TreeNode preorderToBST(int[] preorder, int lr, int rr, int[] idx) {
        int i = idx[0];
        if (i >= preorder.length || preorder[i] < lr || preorder[i] > rr)
            return null;

        TreeNode root = new TreeNode(preorder[i]);
        idx[0]++;

        root.left = preorderToBST(preorder, lr, root.val, idx);
        root.right = preorderToBST(preorder, root.val, rr, idx);

        return root;
    }
}
