import java.util.*;

public class l025_copyListWithRandomPointersUsingExtraSpace {
    public static class ListNode {
        int val = 0;
        ListNode next = null;
        ListNode random = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode copyRandomList(ListNode head) {
        if (head == null )
            return head;

        HashMap<ListNode, ListNode> map = new HashMap<>();

        ListNode dummy = new ListNode(-1), prev = dummy, curr = head;

        // creaing list and mapping nodes
        while (curr != null) {
            prev.next = new ListNode(curr.val);
            prev = prev.next;

            map.put(curr, prev);
            curr = curr.next;
        }

        // setting random pointers
        curr = head;
        prev = dummy.next;

        while (curr != null) {
            prev.random = map.get(curr.random);

            curr = curr.next;
            prev = prev.next;
        }

        return dummy.next;

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
