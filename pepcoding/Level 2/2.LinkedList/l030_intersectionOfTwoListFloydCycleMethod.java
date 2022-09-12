import java.util.*;

public class l030_intersectionOfTwoListFloydCycleMethod {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode IntersectionNodeInTwoLL(ListNode headA, ListNode headB) {
        ListNode tail = getTail(headB);
        tail.next = headB;

        return CycleNode(headA);
    }

    public static ListNode getTail(ListNode head) {
        while (head.next != null)
            head = head.next;

        return head;
    }

    public static ListNode CycleNode(ListNode head) {
        ListNode meetNode = isCyclePresentInLL(head);

        if (meetNode == null)
            return null;

        ListNode ptr1 = head, ptr2 = meetNode;

        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return ptr1;

    }

    // if cycle is present then it will return meeting node else null
    public static ListNode isCyclePresentInLL(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast)
                break;
        }

        return slow == fast ? slow : null;
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
