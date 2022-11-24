// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/

public class l035_ConstructBinaryTreeFromPreAndPostorder {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int data) {
            this.val = data;
        }
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return constructFromPrePost(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode constructFromPrePost(int[] preorder, int psi, int pei, int[] postorder, int ppsi, int ppei) {
        if (psi > pei)
            return null;

        if (psi + 1 > pei)
            return new TreeNode(preorder[psi]);

        int idx = ppsi;
        while (preorder[psi + 1] != postorder[idx])
            idx++;

        TreeNode root = new TreeNode(preorder[psi]);
        int tnel = idx - ppsi + 1; // total no of ele

        root.left = constructFromPrePost(preorder, psi + 1, psi + tnel, postorder, ppsi, ppsi + tnel - 1);
        root.right = constructFromPrePost(preorder, psi + tnel + 1, pei, postorder, ppsi + tnel, ppei - 1);

        return root;
    }
}
