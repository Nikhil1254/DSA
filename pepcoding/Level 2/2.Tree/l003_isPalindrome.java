import java.util.*;

public class l003_isPalindrome {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode mid = midNode(head);
        ListNode nHead = mid.next;
        mid.next = null;
        nHead = reverse(nHead);

        ListNode p1 = head;
        ListNode p2 = nHead;

        boolean res = true;

        while (p2 != null) {
            if (p1.val != p2.val) {
                res = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        mid.next = reverse(nHead);
        return res;

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

    public static ListNode midNode(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
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

        System.out.println(isPalindrome(dummy.next));
    }
}
