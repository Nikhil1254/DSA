import java.util.*;

public class l005_unfoldList {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void unfold(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode nHead = head.next;

        ListNode ptr1 = head;
        ListNode ptr2 = nHead;

        while (ptr2 != null && ptr2.next != null) {
            ptr1.next = ptr1.next.next;
            ptr2.next = ptr2.next.next;

            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        ptr1.next = reverse(nHead);
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

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
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

        ListNode head = dummy.next;
        unfold(head);
        printList(head);
    }  
}
