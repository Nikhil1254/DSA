import java.util.*;

public class l008_mergeKSotedLists {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    // sol 1- merging one by one , complexity - lk^2
    public static ListNode mergeKLists_01(ListNode[] lists) {

        ListNode res = null;

        for (ListNode list : lists)
            res = mergeTwoLists(res, list);

        return res;
    }

    // sol 2 - make one list and then mergeSort , better than fist solution
    public static ListNode mergeKLists_02(ListNode[] lists) {
        if (lists.length == 0)
            return null;

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        for (ListNode list : lists) {
            if (list != null) {
                ListNode tail = getTail(list);
                prev.next = list;
                prev = tail;
            }
        }

        ListNode head = dummy.next;
        dummy.next = null;
        return mergeSort(head);
    }

    public static ListNode getTail(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode tail = head;

        while (tail.next != null)
            tail = tail.next;

        return tail;
    }

    // solution 3 - better than first two
    public static ListNode mergeKLists_03(ListNode[] lists) {
        if (lists.length == 0)
            return null;

        return mergeKLists_03_helper(lists, 0, lists.length - 1);
    }

    public static ListNode mergeKLists_03_helper(ListNode[] lists, int si, int ei) {
        if (si == ei)
            return lists[si];

        int mid = (si + ei) / 2;

        return mergeTwoLists(mergeKLists_03_helper(lists, si, mid), mergeKLists_03_helper(lists, mid + 1, ei));
    }

    // previous codes that we are using here  - 

    public static ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode mid = midNode(head);
        ListNode nHead = mid.next;
        mid.next = null;

        return mergeTwoLists(mergeSort(head), mergeSort(nHead));

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

    // This will merge two sorted lists
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null || l2 == null)
            return l1 != null ? l1 : l2;

        ListNode dummy = new ListNode(-1);

        ListNode prev = dummy, c1 = l1, c2 = l2;

        while (c1 != null && c2 != null) {
            if (c1.val < c2.val) {
                prev.next = c1;
                c1 = c1.next;
            } else {
                prev.next = c2;
                c2 = c2.next;
            }

            prev = prev.next;
        }

        prev.next = c1 != null ? c1 : c2;
        ListNode head = dummy.next;
        dummy.next = null;
        return head;

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
        // int n = scn.nextInt();
        // ListNode[] list = new ListNode[n];
        // for (int i = 0; i < n; i++) {
        //     int m = scn.nextInt();
        //     list[i] = createList(m);
        // }

        // ListNode head = mergeKLists(list);
        // printList(head);
    }
}
