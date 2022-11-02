// done using morris traversal - but in reverse orde i.e right to left
// https://practice.geeksforgeeks.org/problems/kth-largest-element-in-bst/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

public class l023_KthLargestElementInBST {
    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public int kthLargest(Node root, int k) {
        // Your code here
        return reverseMorrisTraversal(root, k);
    }

    private Node getLeftMostNode(Node node, Node curr) {
        while (node.left != null && node.left != curr)
            node = node.left;

        return node;
    }

    private int reverseMorrisTraversal(Node root, int k) {
        Node curr = root;
        int ans = -1;

        while (curr != null) {
            Node right = curr.right;
            if (right == null) {
                if (--k == 0)
                    ans = curr.data;
                curr = curr.left;
            } else {
                Node leftMostNode = getLeftMostNode(right, curr);
                if (leftMostNode.left == null) {
                    // thread creation block
                    leftMostNode.left = curr;
                    curr = curr.right;
                } else {
                    // thread destroy block
                    leftMostNode.left = null;
                    if (--k == 0)
                        ans = curr.data;

                    curr = curr.left;
                }
            }
        }

        return ans;
    }
}
