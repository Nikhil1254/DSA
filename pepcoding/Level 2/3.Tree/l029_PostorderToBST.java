// https://practice.geeksforgeeks.org/problems/construct-bst-from-post-order/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
public class l029_PostorderToBST {

    static class Node {
        int data;
        Node left, right;

        public Node(int d) {
            data = d;
            left = right = null;
        }
    }

    // solution -
    public static Node constructTree(int post[], int n) {
        return postorderToBST(post, -(int) 1e9, (int) 1e9, new int[] { n - 1 });
    }

    private static Node postorderToBST(int[] postorder, int lr, int rr, int[] idx) {
        int i = idx[0];
        if (i <= -1 || postorder[i] < lr || postorder[i] > rr)
            return null;

        Node root = new Node(postorder[i]);
        idx[0]--;

        root.right = postorderToBST(postorder, root.data, rr, idx); // right call
        root.left = postorderToBST(postorder, lr, root.data, idx); // left call

        return root;
    }
}
