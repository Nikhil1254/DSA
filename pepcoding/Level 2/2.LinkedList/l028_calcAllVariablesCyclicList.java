import java.util.*;

public class l028_calcAllVariablesCyclicList {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void allVariablesOfCycle(ListNode head) {
        ListNode meetNode = isCyclePresentInLL(head); // jithe slow fast meet kartay to detect cycle to node

        if (meetNode == null) {
            System.out.println("cycle does not exit !");
            return;
        }

        ListNode slow = head, fast = meetNode, cycleNode = null;
        int A = 0, mDash = 0;

        // to find cycleNode , a and mDash
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;

            if (fast == meetNode)
                mDash++;

            A++;
        }

        cycleNode = slow; // jithna cycle start hot to node

        int cycleLen = 1; // b+c
        slow = slow.next;

        // this loop is for finding cycle length
        while (slow != fast) {
            slow = slow.next;
            cycleLen++;
        }

        // calculating remaining variables
        int C = A - mDash * cycleLen;
        int B = cycleLen - C;
        int M = (A!=0 && C==0) ? 0 : mDash + 1; // to handle case when m==0 

        System.out.println("a : " + A);
        System.out.println("b : " + B);
        System.out.println("C : " + C);
        System.out.println("m : " + M);
        // System.out.println("mDash : " + mDash); 

    }

    // if cycle is present then it will return meeting node else null
    public static ListNode isCyclePresentInLL(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast)
                break;
        }

        return slow == fast ? slow : null;
    }

    public static ListNode takeInput() {
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }
        int idx = scn.nextInt();
        if (idx >= 0) {
            ListNode curr = dummy.next;
            while (idx-- > 0) {
                curr = curr.next;
            }
            prev.next = curr;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = takeInput();
        // ListNode ans = CycleNode(head);
        // System.out.println(ans != null ? ans.val : -1);
        allVariablesOfCycle(head); 
    }
}
