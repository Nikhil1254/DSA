import java.util.*;

public class l033_copyListWithRandomPointersWithoutExtraSpace {
    public static class ListNode {
        int val = 0;
        ListNode next = null;
        ListNode random = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode copyRandomList(ListNode head) {
        if (head == null)
            return null;

        ListNode curr = head;

        // creating list -
        while (curr != null) {
            ListNode forw = curr.next, node = new ListNode(curr.val);
            curr.next = node;
            node.next = forw;
            curr = forw;
        }

        // setting random pointers -
        curr = head;
        ListNode nHead = curr.next;

        while (curr != null) {
            curr.next.random = curr.random != null ? curr.random.next : null;

            curr = curr.next.next;
        }

        // seperating lists -
        curr = head;

        while (curr != null) {
            ListNode forw = curr.next;

            curr.next = forw.next;
            forw.next = forw.next != null ? forw.next.next : null;
            curr = curr.next;
        }

        return nHead;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        ListNode[] arr = new ListNode[n];
        ListNode prev = null;

        for (int i = 0; i < n; i++) {
            arr[i] = new ListNode(0);
            if (prev != null)
                prev.next = arr[i];
            prev = arr[i];
        }

        for (int i = 0; i < n; i++) {
            int val = scn.nextInt();
            int idx = scn.nextInt();

            arr[i].val = val;
            if (idx != -1)
                arr[i].random = arr[idx];
        }

        ListNode head = copyRandomList(arr[0]);
        while (head != null) {
            System.out.print("(" + head.val + ", " + (head.random != null ? head.random.val : -1) + ") ");
            head = head.next;
        }
    }
}
