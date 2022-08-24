import java.util.*;

public class l021_additionOfTwoListRecursive {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null || l2==null)
            return l1==null ? l2 : l1 ;
            
        Pair p = addHelper(l1,l2,length(l1),length(l2)) ;
        
        ListNode head = null ;
        if(p.carry!=0){
            ListNode node = new ListNode(p.carry) ;
            node.next = p.node ;
            head = node;
        }else
            head = p.node ;
            
        return head ;
        
    }
    
    static class Pair{
        ListNode node ;
        int carry ;
        
        public Pair(ListNode node,int carry){
            this.node = node;
            this.carry = carry;
        }
    }
    
    public static Pair addHelper(ListNode c1,ListNode c2,int idx1 ,int idx2){
        if(c1==null && c2==null)
            return new Pair(null,0);
        
        Pair recRes = null ;   
        int sum = 0 ;
        if(idx1>idx2){
            recRes = addHelper(c1.next,c2,idx1-1,idx2) ;
            sum = recRes.carry + c1.val ;
        }
        else if(idx1<idx2){
            recRes = addHelper(c1,c2.next,idx1,idx2-1) ;
            sum = recRes.carry + c2.val ;
        }
        else{
            recRes = addHelper(c1.next,c2.next,idx1-1,idx2-1) ;
            sum = recRes.carry + c1.val + c2.val ;
        }
            
            
        ListNode node = new ListNode(sum%10);
        node.next = recRes.node ;
        return new Pair(node,sum/10);
    }
    
    public static int length(ListNode head){
        int len =0 ;
        
        while(head!=null){
            len++ ;
            head = head.next ;
        }
        
        return len ;
    }

    // InFput_code===================================================

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode makeList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = makeList(scn.nextInt());
        ListNode head2 = makeList(scn.nextInt());

        ListNode ans = addTwoNumbers(head1, head2);
        printList(ans);
    }
}