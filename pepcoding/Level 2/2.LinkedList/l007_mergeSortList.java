import java.util.*;

public class l007_mergeSortList {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode quickSort(ListNode head) {
        return quicksortHelper(head)[0];
    }
    
    public static ListNode[] quicksortHelper(ListNode head){
        if(head==null || head.next==null)
            return new ListNode[]{head,head} ;
            
        ListNode mid = midNode(head) ;
        ListNode[] seg = segregate(head,mid) ; // lh,pivot,rh
        ListNode pivot = seg[1] ;
        
        ListNode[] left = quicksortHelper(seg[0]);
        ListNode[] right = quicksortHelper(seg[2]);
        
        pivot.next = right[0] ;
        if(left[1]!=null)
            left[1].next = pivot; 
        
        ListNode nHead = left[0]==null ? pivot : left[0] ;
        ListNode nTail = right[0]==null ? pivot : right[1] ;
        
        return new ListNode[]{nHead,nTail} ;
    }
    
    public static ListNode[] segregate(ListNode head,ListNode pivot){
        ListNode smaller = new ListNode(-1) , larger = new ListNode(-1) , sp = smaller , lp = larger , curr = head;
        
        while(curr!=null){
            if(curr!=pivot){
                if(curr.val<=pivot.val){
                    sp.next = curr ;
                    sp = sp.next ;
                }else{
                    lp.next = curr ;
                    lp = lp.next ;
                }
            }
            curr = curr.next ;
        }
        
        sp.next = lp.next = pivot.next = null ;
        return new ListNode[]{smaller.next , pivot , larger.next} ;
        
    }
    
    public static ListNode midNode(ListNode head) {
        
        if(head==null || head.next==null)
            return head ;
            
        ListNode slow = head , fast = head ;
        
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next ;
            fast = fast.next.next ;
        }
    
        return slow;
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
