import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
// if multiple ele are their on same level we want them in sorted manner

public class l056_VerticalOrderTraversal2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null)
            return ans;

        // getting width - no of vertical levels
        int minMax[] = new int[2];
        widthOfShadow(root, 0, minMax);
        int width = minMax[1] - minMax[0] + 1;

        // filling arrayList
        for (int idx = 0; idx < width; idx++)
            ans.add(new ArrayList<>());

        PriorityQueue<Pair> pq = new PriorityQueue(new MyPriority());
        pq.add(new Pair(root, 0, Math.abs(minMax[0]))); // new Pair(node,hl,vl)

        while (pq.size() > 0) {
            int size = pq.size();
            while (size-- > 0) {
                Pair rp = pq.remove();
                TreeNode node = rp.node;
                int hl = rp.hl;
                int vl = rp.vl;

                ans.get(vl).add(node.val);

                if (node.left != null)
                    pq.add(new Pair(node.left, hl + 1, vl - 1));
                if (node.right != null)
                    pq.add(new Pair(node.right, hl + 1, vl + 1));
            }
        }

        return ans;

    }

    private void widthOfShadow(TreeNode root, int vl, int[] minMax) {
        if (root == null)
            return;

        minMax[0] = Math.min(vl, minMax[0]);
        minMax[1] = Math.max(vl, minMax[1]);

        widthOfShadow(root.left, vl - 1, minMax);
        widthOfShadow(root.right, vl + 1, minMax);
    }

    class Pair {
        TreeNode node;
        int hl;
        int vl;

        Pair(TreeNode node, int hl, int vl) {
            this.node = node;
            this.vl = vl;
            this.hl = hl;
        }
    }

    class MyPriority implements Comparator<Pair> {
        @Override
        public int compare(Pair obj1, Pair obj2) {
            // priority order : hl then vl and if both are same then value of node
            if (obj1.hl != obj2.hl)
                return obj1.hl - obj2.hl;
            else if (obj1.vl != obj2.vl)
                return obj1.vl - obj2.vl;
            else
                return obj1.node.val - obj2.node.val;
        }
    }
}
