import java.util.*;

public class l016_quickSortList {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode quickSort(ListNode head) {
        return quickSort_helper(head)[0];
    }

    public static ListNode[] quickSort_helper(ListNode head) {
        if (head == null || head.next == null)
            return new ListNode[] { head, head };

        int mid = length(head) / 2;
        ListNode[] partition = segregate(head, mid);

        ListNode[] left = quickSort_helper(partition[0]);
        ListNode[] right = quickSort_helper(partition[2]);

        return mergeLists(left, partition[1], right);
    }

    public static ListNode[] mergeLists(ListNode[] left,ListNode pivot,ListNode[] right){
        ListNode head = null , tail = null ;

        
        head = left[0]==null ? pivot : left[0] ;
        tail = right[0]==null ? pivot : getTail(right[0]) ;

        pivot.next = right[0] ;
        if(left[0]!=null)
            left[1].next = pivot ;
        
        return new ListNode[]{head,tail};
    }

    public static ListNode getTail(ListNode head) {
        if (head == null || head.next == null)
            return head;

        while (head.next != null)
            head = head.next;

        return head;
    }

    public static int length(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }

        return len;
    }

    public static ListNode[] segregate(ListNode head, int pivotIdx) {

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

        ListNode lHead = s.next == pivot ? null : s.next;
        ListNode rHead = l.next;

        return new ListNode[] { lHead, pivot, rHead };
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

        ListNode head = quickSort(h1);
        printList(head);
    }
}
