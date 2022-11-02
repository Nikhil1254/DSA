import java.util.*;

//https://practice.geeksforgeeks.org/problems/root-to-leaf-paths/1 - 
public class l003_RootToLeafPaths {
    class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    public ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> smallAns = new ArrayList<>();
        Paths(root, ans, smallAns);
        return ans;
    }

    public void Paths(Node node, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> smallAns) {

        if (node == null)
            return;

        if (node.left == null && node.right == null) {
            smallAns.add(node.data);
            ArrayList<Integer> base = new ArrayList<>(smallAns);
            ans.add(base);
            smallAns.remove(smallAns.size() - 1);
            return;
        }

        smallAns.add(node.data);
        Paths(node.left, ans, smallAns);
        Paths(node.right, ans, smallAns);
        smallAns.remove(smallAns.size() - 1);
    }
}