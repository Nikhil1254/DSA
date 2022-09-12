import java.util.*;

public class l009_segregateEvenAndOdd {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregateEvenOdd(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode even = new ListNode(-1);
        ListNode odd = new ListNode(-1);

        ListNode ptr = head, eprev = even, oprev = odd;

        while (ptr != null) {
            if (ptr.val % 2 == 0) {
                eprev.next = ptr;
                eprev = eprev.next;
                ptr = ptr.next;
            } else {
                oprev.next = ptr;
                oprev = oprev.next;
                ptr = ptr.next;
            }
        }

        eprev.next = oprev.next = null ;

        eprev.next = odd.next;
        head = even.next;
        even.next = odd.next = null;
        return head;

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = segregateEvenOdd(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
