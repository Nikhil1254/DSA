public class ConstructBST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static Node constructBST(int[] arr, int lo, int hi) {
        if (lo > hi)
            return null;

        int mid = (lo + hi) / 2;
        int data = arr[mid];

        Node lc = constructBST(arr, lo, mid - 1);
        Node rc = constructBST(arr, mid + 1, hi);

        return new Node(data, lc, rc);
    }

    static void display(Node node) {
        if (node == null)
            return;

        String str = "";

        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data;

        System.out.println(str);

        display(node.left);

        display(node.right);
    }

    public static int size(Node node) {
        // write your code here
        if (node == null)
            return 0;

        return size(node.left) + size(node.right) + 1;
    }

    public static int sum(Node node) {
        // write your code here
        if (node == null)
            return 0;

        return sum(node.left) + sum(node.right) + node.data;
    }

    public static int max(Node node) {
        // write your code here
        if (node == null)
            return Integer.MIN_VALUE;

        return Math.max(node.data, Math.max(max(node.left), max(node.right)));
    }

    public static int min(Node node) {
        // write your code here
        if (node == null)
            return Integer.MAX_VALUE;

        return Math.min(node.data, Math.min(min(node.left), min(node.right)));
    }

    public static boolean find(Node node, int data) {
        // write your code here
        if (node == null)
            return false;

        if (node.data == data)
            return true;
        else if (node.data > data)
            return find(node.left, data);
        else
            return find(node.right, data);
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50, 60, 70 };

        Node root = constructBST(arr, 0, arr.length - 1);

        display(root);
    }
}
