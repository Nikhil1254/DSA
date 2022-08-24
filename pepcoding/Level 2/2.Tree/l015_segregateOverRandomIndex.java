import java.util.*;

// segregate over pivot index
public class l015_segregateOverRandomIndex {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregate(ListNode head, int pivotIdx) {
        if (head == null || head.next == null)
            return head;

        ListNode s = new ListNode(-1), l = new ListNode(-1);
        ListNode curr = head, sp = s, lp = l;

        ListNode pivot = getPivot(head, pivotIdx);

        while (curr != null) {
            if (curr != pivot) {
                if (curr.val <= pivot.val) {
                    sp.next = curr;
                    sp = sp.next;
                } else {
                    lp.next = curr;
                    lp = lp.next;
                }
            }

            curr = curr.next;
        }

        sp.next = lp.next = pivot.next = null;
        sp.next = pivot;
        pivot.next = l.next;

        head = s.next;
        s.next = l.next = null;

        return head;
    }

    public static ListNode getPivot(ListNode head, int pi) {
        int idx = 0;
        ListNode pivot = head;

        while (idx < pi) {
            pivot = pivot.next;
            idx++;
        }

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
        int idx = scn.nextInt();
        h1 = segregate(h1, idx);
        printList(h1);
    }
}