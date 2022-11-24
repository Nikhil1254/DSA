// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

public class l034_ConstructBinaryTreeFromPostAndInoder {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int data) {
            this.val = data;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return constructTreeFromPostAndInorder(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode constructTreeFromPostAndInorder(int[] postorder, int psi, int pei, int[] inorder, int isi,
            int iei) {
        if (psi > pei)
            return null;

        int idx = isi;
        while (postorder[pei] != inorder[idx])
            idx++;

        TreeNode root = new TreeNode(postorder[pei]);
        int tnel = idx - isi;

        root.left = constructTreeFromPostAndInorder(postorder, psi, psi + tnel - 1, inorder, isi, idx - 1);
        root.right = constructTreeFromPostAndInorder(postorder, psi + tnel, pei - 1, inorder, idx + 1, iei);

        return root;
    }
}
