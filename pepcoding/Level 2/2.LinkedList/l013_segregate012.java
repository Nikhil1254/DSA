import java.util.*;

public class l013_segregate012 {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregate012(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode zero = new ListNode(-1), one = new ListNode(-1), prevz = zero, prevo = one;
        ListNode two = new ListNode(-1), prevt = two;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val == 0) {
                prevz.next = curr;
                curr = curr.next;
                prevz = prevz.next;
            } else if (curr.val == 1) {
                prevo.next = curr;
                curr = curr.next;
                prevo = prevo.next;
            } else {
                prevt.next = curr;
                curr = curr.next;
                prevt = prevt.next;
            }
        }

        prevo.next = prevz.next = prevt.next = null;

        prevo.next = two.next;
        prevz.next = one.next;
        head = zero.next;

        zero.next = one.next = two.next = null;

        return head;
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
        h1 = segregate012(h1);
        printList(h1);
    }
}
