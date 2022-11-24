
// https://www.codingninjas.com/codestudio/problems/verify-preorder-sequence-in-binary-search-tree_1281309?leftPanelTab=0

public class l031_VerifyPreorderSequenceInBST {
    public static boolean isBSTPreorder(int[] arr) {
        // Write your code here.
        int[] idx = { 0 };
        preorderToBST(arr, -(int) 1e9, (int) 1e9, idx);
        return idx[0] == arr.length;
    }

    private static void preorderToBST(int[] arr, int lr, int rr, int[] idx) {
        int i = idx[0];
        if (i >= arr.length || arr[i] < lr || arr[i] > rr)
            return;

        int val = arr[i];
        idx[0]++;

        preorderToBST(arr, lr, val, idx);
        preorderToBST(arr, val, rr, idx);
    }
}