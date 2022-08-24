import java.util.*;

public class l017_removeNthNodeFromEndOfList {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode p1 = head, p2 = head;

        while (n-- > 0)
            p2 = p2.next;

        while (p2 != null && p2.next != null) {
            p2 = p2.next;
            p1 = p1.next;
        }

        if (p2 != null) {
            ListNode node = p1.next;
            p1.next = p1.next.next;
            node.next = null;
        } else {
            head = head.next;
            p1.next = null;
        }

        return head;
    }

    // easier way - using dummy node -
    public static ListNode removeNthFromEnd01(ListNode head, int n) {
        if (head == null)
            return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p1 = dummy, p2 = dummy;

        while (n-- > 0)
            p2 = p2.next;

        while (p2.next != null) {
            p2 = p2.next;
            p1 = p1.next;
        }

        ListNode node = p1.next;
        p1.next = p1.next.next;
        node.next = null;

        return dummy.next;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode createList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        ListNode h1 = createList(n);

        int m = scn.nextInt();
        h1 = removeNthFromEnd(h1, m);
        printList(h1);
    }
}
