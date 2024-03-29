import java.util.*;

public class l011_reverseInRange {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverseInRange(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1) , prev = dummy ;
        dummy.next = head ;
        int idx = 0 ;
        
        while(idx<left-1){
            prev = prev.next ;
            idx++ ;
        }
        
        ListNode nHead = prev.next , nTail = prev.next;
        idx = left ;
        while(idx<right){
            idx++ ;
            nTail = nTail.next ;
        }
        
        ListNode forw = nTail.next ;
        prev.next = nTail.next = null ;
        prev.next = reverse(nHead) ;
        nHead.next = forw ; //after reverse it will be the tail
        return dummy.next ;
    }
    
    public static ListNode reverse(ListNode head){
        if(head==null || head.next == null)
            return head ;
        
        ListNode prev = null , curr = head ;
        
        while(curr!=null){
            ListNode forw = curr.next ;
            curr.next = prev ;
            prev = curr ;
            curr = forw ;
        }
        
        return prev ;
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
        int sz = scn.nextInt();
        ListNode h1 = createList(sz);

        int m = scn.nextInt();
        int n = scn.nextInt();

        h1 = reverseInRange(h1, m, n);
        printList(h1);
    }
}

// public static ListNode reverseInRange(ListNode head, int si, int ei) {
//     if (head == null || head.next == null)
//         return head;

//     ListNode res = new ListNode(-1), curr = head, prev = res;

//     int idx = 1;

//     // elements before si
//     while (idx < si) {
//         prev.next = curr;

//         curr = curr.next;
//         idx++;

//         prev = prev.next;
//         prev.next = null;
//     }

//     // eversing elements between si and ei
//     ListNode dummy = new ListNode(-1), th = dummy, tt = dummy;
//     while (idx <= ei) {

//         if (dummy == tt) {
//             dummy.next = curr;
//             th = tt = curr;
//             curr = curr.next;
//             tt.next = null;
//         } else {
//             dummy.next = curr;
//             curr = curr.next;
//             dummy.next.next = th;
//             th = dummy.next;
//         }

//         idx++;
//     }

//     prev.next = th;
//     dummy.next = null;
//     prev = tt;

//     // handling elements after ei
//     prev.next = curr;
//     ListNode nHead = res.next;
//     res.next = null;
//     return nHead;
// }