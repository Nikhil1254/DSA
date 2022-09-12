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
        if (head == null || head.next == null || k <= 1)
            return head;

        int len = length(head);
        ListNode dummy = new ListNode(-1), prev = dummy;
        while (len >= k) {
            int count = k;
            ListNode revHead = null, revTail = null;
            while (count-- > 0) {
                ListNode[] rem = removeFirst(head); // head,removedNode
                head = rem[0];
                ListNode[] revList = addFirst(revHead, revTail, rem[1]); // head,tail
                revHead = revList[0];
                revTail = revList[1];
            }
            len -= k;
            prev.next = revHead;
            prev = revTail;
            revHead = revTail = null;
        }

        prev.next = head;
        return dummy.next;
    }

    public static int length(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    public static ListNode[] addFirst(ListNode head, ListNode tail, ListNode node) {
        if (head == null) {
            return new ListNode[] { node, node };
        }

        node.next = head;
        head = node;
        return new ListNode[] { head, tail };
    }

    public static ListNode[] removeFirst(ListNode head) {
        if (head == null)
            return new ListNode[] { null, null };

        ListNode node = head;
        head = head.next;
        node.next = null;
        return new ListNode[] { head, node };
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

// public static ListNode reverseInKGroup(ListNode head, int k) {
// if (head == null || head.next == null || k<=1)
// return head;

// ListNode res = new ListNode(-1), dummy = new ListNode(-1);
// ListNode tail = res, dtail = dummy, curr = head;

// int count = 0;
// while (curr != null) {
// count++;

// if (dummy == dtail) {
// dtail = curr;
// }

// ListNode forw = dummy.next;
// dummy.next = curr;
// curr = curr.next;
// dummy.next.next = forw;

// if (count == k) {
// tail.next = dummy.next;
// tail = dtail;

// dummy.next = null;
// dtail = dummy;
// count = 0;
// }
// }

// if (count != 0) {
// ListNode nHead = dummy.next;
// dummy.next = null;
// tail.next = reverse(nHead);
// }

// head = res.next;
// res.next = null;
// return head;
// }

// public static ListNode reverse(ListNode head) {

// if (head == null || head.next == null)
// return head;

// ListNode prev = null;
// ListNode curr = head;

// while (curr != null) {
// ListNode forw = curr.next;

// curr.next = prev;
// prev = curr;
// curr = forw;
// }

// return prev;
// }