import java.util.Scanner;

// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/convert-sorted-dll-to-bst/ojquestion

// convert sorted dubly linkedlist to BST
public class l026_SortedDLLToDLL {
    public static Scanner scn = new Scanner(System.in);

    public static class Node {
        int val = 0;
        Node left = null;
        Node right = null;

        Node(int val) {
            this.val = val;
        }
    }

    // left : prev, right : next
    public static Node SortedDLLToBST(Node head) {
        if (head == null || (head.left == null && head.right == null))
            return head;

        Node midNode = getMidNode(head);

        Node nextNode = midNode.right, prevNode = midNode.left;

        midNode.right = midNode.left = nextNode.left = null; // nextNode will always exit if we are fiding first mid

        if (prevNode != null)
            prevNode.right = null;

        midNode.left = SortedDLLToBST(prevNode == null ? null : head); // edge case
        midNode.right = SortedDLLToBST(nextNode);

        return midNode;
    }

    public static Node getMidNode(Node head) {
        if (head == null || head.right == null)
            return head;

        Node slow = head, fast = head;

        while (fast.right != null && fast.right.right != null) {
            slow = slow.right;
            fast = fast.right.right;
        }
        return slow;
    }

    // Input_code===================================================

    public static void display(Node node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static Node makeList(int n) {
        Node dummy = new Node(-1);
        Node prev = dummy;
        while (n-- > 0) {
            Node node = new Node(scn.nextInt());
            prev.right = node;
            node.left = prev;
            prev = prev.right;
        }

        Node head = dummy.right;
        head.left = dummy.right = null;

        return head;
    }

    public static void main(String[] args) {
        Node head = makeList(scn.nextInt());

        head = SortedDLLToBST(head);
        display(head);
    }
}
