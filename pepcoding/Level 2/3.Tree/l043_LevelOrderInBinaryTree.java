import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

// https://leetcode.com/problems/binary-tree-level-order-traversal/
// Done using BFS

public class l043_LevelOrderInBinaryTree {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int data) {
            this.val = data;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>() ;
        levelOrderDFS(root,0,ans);
        return ans ;
    }

    
    // Solution 1 -  using BFS (This template we will be using in all view set questions)
    private List<List<Integer>> levelOrderBFS(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null)
            return ans;
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);

        int level = 0;
        while (que.size() > 0) {
            int size = que.size(); // current level size
            ans.add(new ArrayList<Integer>());

            while (size-- > 0) {
                // processing all current level elements
                TreeNode rn = que.removeFirst();

                ans.get(level).add(rn.val);

                if (rn.left != null)
                    que.addLast(rn.left);
                if (rn.right != null)
                    que.addLast(rn.right);
            }

            level++;
        }

        return ans;
    }

    // solutin 2 - using DFS(recursion)
    private void levelOrderDFS(TreeNode root, int hl, List<List<Integer>> ans) {
        if (root == null)
            return;

        if (hl == ans.size())
            ans.add(new ArrayList<>());

        ans.get(hl).add(root.val);

        levelOrderDFS(root.left, hl + 1, ans);
        levelOrderDFS(root.right, hl + 1, ans);
    }
}