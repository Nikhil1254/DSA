// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

public class l033_ConstructBinaryTreeFromPreAndInorder {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int data) {
            this.val = data;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return constructTreeFromPreAndInorder(preorder, 0, n - 1, inorder, 0, n - 1);
    }

    private TreeNode constructTreeFromPreAndInorder(int[] preorder, int psi, int pei, int[] inorder, int isi, int iei) {
        if (psi > pei)
            return null;

        int idx = isi;
        while (preorder[psi] != inorder[idx])
            idx++;

        TreeNode root = new TreeNode(preorder[psi]);
        int tnel = idx - isi; // total no of elements

        root.left = constructTreeFromPreAndInorder(preorder, psi + 1, psi + tnel, inorder, isi, idx - 1); // left call
        root.right = constructTreeFromPreAndInorder(preorder, psi + tnel + 1, pei, inorder, idx + 1, iei); // right call

        return root;

    }
}
