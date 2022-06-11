import java.util.*;
import java.io.*;

public class LargestBstSubtree {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    // solution 1 -
    static int largestBstSize;
    static int largestBstNode;

    static class BstPair {
        boolean isBST;
        int max;
        int min;
        int size;

        BstPair(boolean isBST, int min, int max, int size) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }

    public static BstPair largestBstSubtree(Node node) {
        if (node == null)
            return new BstPair(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        BstPair lp = largestBstSubtree(node.left);
        BstPair rp = largestBstSubtree(node.right);

        boolean isBST = lp.isBST && rp.isBST && (node.data >= lp.max && node.data <= rp.min);
        int max = Math.max(node.data, Math.max(lp.max, rp.max));
        int min = Math.min(node.data, Math.min(lp.min, rp.min));
        int s = lp.size + rp.size + 1;

        if (isBST && s > largestBstSize) {
            largestBstSize = s;
            largestBstNode = node.data;
        }

        return new BstPair(isBST, min, max, s);
    }

    // solution 2 -
    static class BSTPair {
        int max;
        int min;
        boolean isBst;

        Node root; // largest bst root in tree
        int size; // largest bst size in tree

        BSTPair(boolean isBst, int min, int max, Node root, int size) {
            this.isBst = isBst;
            this.min = min;
            this.max = max;
            this.root = root;
            this.size = size;
        }

        BSTPair() {

        }
    }

    public static BSTPair largestBstSubtree1(Node node) {
        if (node == null)
            return new BSTPair(true, Integer.MAX_VALUE, Integer.MIN_VALUE,null, 0);

        BSTPair lp = largestBstSubtree1(node.left);
        BSTPair rp = largestBstSubtree1(node.right);

        BSTPair mp = new BSTPair();
        mp.isBst = lp.isBst && rp.isBst && (node.data >= lp.max && node.data <= rp.min);
        mp.min = Math.min(node.data, Math.min(lp.min, rp.min));
        mp.max = Math.max(node.data, Math.max(lp.max, rp.max));

        if(mp.isBst){
            mp.size = lp.size+rp.size+1 ;
            mp.root = node ;
        }else if(lp.size>rp.size){
            mp.size = lp.size;
            mp.root = lp.root;
        }else{
            mp.size = rp.size;
            mp.root = rp.root;
        }

        return mp;
    }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);
    
    // write your code here
    // largestBstSubtree(root);
    // System.out.println(largestBstNode+"@"+largestBstSize);
    BSTPair p = largestBstSubtree1(root);
    System.out.println(p.root.data+"@"+p.size);
  }

}
