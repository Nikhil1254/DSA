import java.util.*;

// without using leading zeros while addition and some slight changes
public class l022_multiplyTwoListOptimized {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode multiplyTwoLL(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode dummy = new ListNode(-1), prev = dummy, l2_itr = l2;
        while (l2_itr != null) {
            ListNode singleRes = multiplyWithDigit(l1, l2_itr.val);
            addTwoList(singleRes, prev);

            prev = prev.next;
            l2_itr = l2_itr.next;
        }

        return reverse(dummy.next);
        // return null ;
    }

    public static void addTwoList(ListNode head, ListNode prev) {
        ListNode curr = head;
        int carry = 0;

        while (curr != null || carry != 0) {
            if (prev.next == null)
                prev.next = new ListNode(0);

            int sum = carry + prev.next.val + (curr != null ? curr.val : 0);
            prev.next.val = sum % 10;
            carry = sum / 10;

            prev = prev.next;
            curr = curr != null ? curr.next : null;
        }
    }

    // will get list in reverse order so no need to reverse
    public static ListNode multiplyWithDigit(ListNode head, int digit) {
        ListNode dummy = new ListNode(-1), prev = dummy;
        ListNode curr = head;
        int carry = 0;

        while (curr != null || carry != 0) {
            int prod = carry + digit * (curr != null ? curr.val : 0);

            prev.next = new ListNode(prod % 10);
            carry = prod / 10;
            prev = prev.next;
            curr = curr != null ? curr.next : null;
        }

        return dummy.next;
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = null, curr = head;

        while (curr != null) {
            ListNode forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }

        return prev;
    }

    // InFput_code===================================================

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode makeList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = makeList(scn.nextInt());
        ListNode head2 = makeList(scn.nextInt());

        ListNode ans = multiplyTwoLL(head1, head2);
        printList(ans);
    }
}
