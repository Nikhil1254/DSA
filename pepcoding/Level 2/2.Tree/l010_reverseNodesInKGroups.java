import java.util.*;

// leetcode 25 - https://leetcode.com/problems/reverse-nodes-in-k-group/submissions/
public class l010_reverseNodesInKGroups {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverseInKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k<=1)
            return head;

        ListNode res = new ListNode(-1), dummy = new ListNode(-1);
        ListNode tail = res, dtail = dummy, curr = head;

        int count = 0;
        while (curr != null) {
            count++;

            if (dummy == dtail) {
                dtail = curr;
            }

            ListNode forw = dummy.next;
            dummy.next = curr;
            curr = curr.next;
            dummy.next.next = forw;

            if (count == k) {
                tail.next = dummy.next;
                tail = dtail;

                dummy.next = null;
                dtail = dummy;
                count = 0;
            }
        }

        if (count != 0) {
            ListNode nHead = dummy.next;
            dummy.next = null;
            tail.next = reverse(nHead);
        }

        head = res.next;
        res.next = null;
        return head;
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

        int k = scn.nextInt();
        h1 = reverseInKGroup(h1, k);
        printList(h1);
    }  
}
