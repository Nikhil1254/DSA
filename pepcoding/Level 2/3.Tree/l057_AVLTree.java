public class l057_AVLTree {
    static class TreeNode {
        int val;
        TreeNode left, right;
        int bal = 0;
        int height = 0;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode addData(TreeNode root, int data) {
        if (root == null)
            return new TreeNode(data);

        if (data > root.val)
            root.right = addData(root.right, data);
        else
            root.left = addData(root.left, data);

        return getRotation(root);
    }

    public static TreeNode removeData(TreeNode root, int data) {
        if (root == null)
            return null;

        if (data < root.val)
            root.left = removeData(root.left, data);
        else if (data > root.val)
            root.right = removeData(root.right, data);
        else {
            if (root.left == null || root.right == null)
                return root.left != null ? root.left : root.right;

            int min = getMin(root.right);
            root.val = min;
            root.right = removeData(root.right, root.val);
        }

        return getRotation(root);

    }

    private static int getMin(TreeNode node) {
        while (node.left != null)
            node = node.left;

        return node.val;
    }

    private static void updateBalAndHeight(TreeNode root) {
        int lh = root.left != null ? root.left.height : -1;
        int rh = root.right != null ? root.right.height : -1;

        int bal = lh - rh;

        root.height = Math.max(lh, rh) + 1;
        root.bal = bal;
    }

    private static TreeNode getRotation(TreeNode root) {
        updateBalAndHeight(root);
        if (root.bal == 2) { // ll,lr
            if (root.left.bal == 1) { // ll
                return rightRotation(root);
            } else {// lr
                root.left = leftRotation(root.left); // converting to ll
                return rightRotation(root);
            }

        } else if (root.bal == -2) {// rr,rl
            if (root.right.bal == -1) { // rr
                return leftRotation(root);
            } else {// rl
                root.right = rightRotation(root.right);
                return leftRotation(root);
            }
        }

        return root;
    }

    // applied on LL case
    private static TreeNode rightRotation(TreeNode A) {
        TreeNode B = A.left;
        TreeNode BKaRight = B.right;

        B.right = A;
        A.left = BKaRight;

        updateBalAndHeight(A);
        updateBalAndHeight(B);

        return B;
    }

    // applied on RR case
    private static TreeNode leftRotation(TreeNode A) {
        TreeNode B = A.right;
        TreeNode BKaLeft = B.left;

        B.left = A;
        A.right = BKaLeft;

        updateBalAndHeight(A);
        updateBalAndHeight(B);

        return B;
    }

    public static void display(TreeNode node) {
        if (node == null)
            return;

        String str = "";
        str += node.left != null ? node.left.val : ".";
        str += " -> " + node.val + " <- ";
        str += node.right != null ? node.right.val : ".";

        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = null;

        for (int val = 1; val <= 15; val++)
            root = addData(root, val);

        display(root);
    }
}
