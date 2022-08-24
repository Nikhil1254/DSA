import java.util.*;

public class l020_multiplyTwoList {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode multiplyTwoLL(ListNode l1, ListNode l2) {
        ListNode res = null;

        l1 = reverse(l1);
        l2 = reverse(l2);

        int count = 0;
        ListNode c1 = l1;

        while (c1 != null) {
            int carry = 0;
            ListNode dummy = new ListNode(-1), prev = dummy, c2 = l2;
            int temp = count;
            while (temp-- > 0) {
                prev.next = new ListNode(0);
                prev = prev.next;
            }

            while (c2 != null || carry != 0) {
                int sum = c1.val * (c2 != null ? c2.val : 0) + carry;

                prev.next = new ListNode(sum % 10);
                prev = prev.next;
                c2 = c2 != null ? c2.next : null;
                carry = sum / 10;
            }

            res = addTwoNumbers(res, dummy.next);
            c1 = c1.next;
            count++;
        }

        return reverse(res); // je final output yenar tyala apan reverse karun ghenar bas each time reverse
                             // karnya peksha

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 == null ? l2 : l1;

        // we will be passing reverse list directly so no nedd to write this
        // l1 = reverse(l1);
        // l2 = reverse(l2);

        ListNode dummy = new ListNode(-1), prev = dummy, c1 = l1, c2 = l2;
        int carry = 0;

        while (c1 != null || c2 != null || carry != 0) {
            int sum = carry + (c1 != null ? c1.val : 0) + (c2 != null ? c2.val : 0);

            prev.next = new ListNode(sum % 10);
            prev = prev.next;
            carry = sum / 10;

            c1 = c1 != null ? c1.next : null;
            c2 = c2 != null ? c2.next : null;
        }

        ListNode resHead = dummy.next;
        dummy.next = null;
        // resHead = reverse(resHead);

        return resHead; // we are returning reverse list only

    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode curr = head, prev = null;

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