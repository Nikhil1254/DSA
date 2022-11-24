import java.util.ArrayList;
import java.util.LinkedList;

//Function to return a list containing the bottom view of the given tree.
// input - 20 8 22 5 3 4 25 N N 10 N N 14
//           20
//         /    \
//       8        22
//     /   \     /   \
//   5       3 4     25
//          /    \      
//      10       14

// if we have multiple nodes at any level - storing all of them to solve all variation : min/max/mid and many more
public class l051_BottomViewOfBinaryTree2 {
    class Node {
        int data;
        Node left, right;
    }

    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (root == null)
            return new ArrayList<>();

        int[] minMax = new int[2];
        getShadowWidth(root, 0, minMax);
        int width = minMax[1] - minMax[0] + 1;

        int[] hLevel = new int[width];

        for (int idx = 0; idx < width; idx++) {
            ans.add(new ArrayList<>());
            hLevel[idx] = -1;
        }

        LinkedList<Pair> que = new LinkedList<>();
        que.addLast(new Pair(root, Math.abs(minMax[0])));
        int level = 0; // horizontal level

        while (que.size() > 0) {
            int size = que.size();

            while (size-- > 0) {
                Pair rp = que.removeFirst();
                Node node = rp.node;
                int vl = rp.vl;

                if (hLevel[vl] < level) {
                    ans.get(vl).clear();
                    hLevel[vl] = level;
                }
                ans.get(vl).add(node.data);

                if (node.left != null)
                    que.addLast(new Pair(node.left, vl - 1));
                if (node.right != null)
                    que.addLast(new Pair(node.right, vl + 1));
            }

            level++;
        }

        System.out.println(ans);
        return new ArrayList<Integer>();
    }

    private static void getShadowWidth(Node root, int vl, int[] minMax) {
        if (root == null)
            return;

        minMax[0] = Math.min(minMax[0], vl);
        minMax[1] = Math.max(minMax[1], vl);

        getShadowWidth(root.left, vl - 1, minMax);
        getShadowWidth(root.right, vl + 1, minMax);
    }

    static class Pair {
        Node node;
        int vl;

        Pair(Node node, int vl) {
            this.node = node;
            this.vl = vl;
        }
    }
}
