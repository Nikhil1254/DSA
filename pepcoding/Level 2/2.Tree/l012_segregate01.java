import java.util.*;

public class l012_segregate01 {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregate01(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode zero = new ListNode(-1), one = new ListNode(-1), prevz = zero, prevo = one;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val == 0) {
                prevz.next = curr;
                curr = curr.next;
                prevz = prevz.next;
            } else {
                prevo.next = curr;
                curr = curr.next;
                prevo = prevo.next;
            }
        }

        prevz.next = prevo.next = null;

        prevz.next = one.next;
        return zero.next;

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
        h1 = segregate01(h1);
        printList(h1);
    }
}
