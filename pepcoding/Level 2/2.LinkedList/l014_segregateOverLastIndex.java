import java.util.*;

public class l014_segregateOverLastIndex {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregateOnLastIndex(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode pivot = head;
        while (pivot.next != null)
            pivot = pivot.next;

        ListNode smaller = new ListNode(-1), prevs = smaller; // smaller and equal elements
        ListNode greater = new ListNode(-1), prevg = greater; // greater elements
        ListNode curr = head;

        while (curr != null) {
            if (curr.val <= pivot.val) {
                prevs.next = curr;
                prevs = prevs.next;
            } else {
                prevg.next = curr;
                prevg = prevg.next;
            }
            curr = curr.next;
        }

        prevs.next = prevg.next = null;

        prevs.next = greater.next;
        head = smaller.next;
        smaller.next = greater.next = null;
        return pivot;
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
        h1 = segregateOnLastIndex(h1);
        printList(h1);
    }
}