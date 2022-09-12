import java.util.*;

public class l029_intersectionOfTwoListDiffMethod {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode IntersectionNodeInTwoLL(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        int len1 = lengthOfList(p1), len2 = lengthOfList(p2);

        int diff = len1 > len2 ? len1 - len2 : len2 - len1;
        ListNode node = len1 > len2 ? p1 : p2;

        while (diff-- > 0) {
            node = node.next;
        }

        if (len1 > len2)
            p1 = node;
        else
            p2 = node;

        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;

    }

    public static int lengthOfList(ListNode head) {
        int len = 0;

        while (head != null) {
            len++;
            head = head.next;
        }

        return len;
    }

    // Input_code===================================================

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

        int idx = scn.nextInt();

        ListNode head2 = makeList(scn.nextInt());

        if (idx >= 0) {
            ListNode curr = head1;
            while (idx-- > 0)
                curr = curr.next;

            ListNode prev = head2;
            while (prev.next != null)
                prev = prev.next;

            prev.next = curr;
        }

        ListNode ans = IntersectionNodeInTwoLL(head1, head2);
        System.out.println(ans != null ? ans.val : -1);
    }
}
