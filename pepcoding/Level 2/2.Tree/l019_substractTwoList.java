import java.util.*;

public class l019_substractTwoList {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode subtractTwoNumbers(ListNode l1, ListNode l2) {
        if (l2 == null)
            return l1;

        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode dummy = new ListNode(-1), prev = dummy, c1 = l1, c2 = l2;

        int borrow = 0;
        while (c1 != null) {
            int sub = borrow + c1.val - (c2 != null ? c2.val : 0);
            if (sub < 0) {
                sub += 10;
                borrow = -1;
            } else
                borrow = 0;

            prev.next = new ListNode(sub);
            prev = prev.next;
            c1 = c1.next;
            if (c2 != null)
                c2 = c2.next;
        }

        ListNode head = reverse(dummy.next), curr = head;

        while (curr != null && curr.val == 0) {
            ListNode forw = curr.next;
            curr.next = null;
            curr = forw;
        }

        return curr != null ? curr : new ListNode(0);
    }

    public static ListNode reverse(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode prev = null;
        ListNode curr = head;

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
        int n1 = scn.nextInt();
        ListNode head1 = makeList(n1);
        int n2 = scn.nextInt();
        ListNode head2 = makeList(n2);

        ListNode ans = null;
        if (n1 >= n2)
            ans = subtractTwoNumbers(head1, head2);
        else
            ans = subtractTwoNumbers(head2, head1);

        printList(ans);
    }

}