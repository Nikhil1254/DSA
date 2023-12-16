// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

// solution2 - using level order to serialize and deserialize binary tree
// leetcode makes binary tree from levelOrder input only

import java.util.LinkedList;

// using level order solution
public class l037_SerializeAndDeserializeBinaryTree2 {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int data) {
            this.val = data;
        }
    }

    public String serialize(TreeNode root) {
        // serializing to levelorder
        if (root == null)
            return "";

        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode> list = new LinkedList<>(); // queue
        list.addLast(root);

        while (list.size() > 0) {
            TreeNode node = list.removeFirst();
            sb.append((node != null ? node.val : "#") + " ");

            if (node == null)
                continue;

            list.addLast(node.left);
            list.addLast(node.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // deserializing from levelorder
        if (data.length() == 0)
            return null;

        String[] levelOrder = data.split(" ");

        LinkedList<TreeNode> list = new LinkedList<>(); // queue
        TreeNode root = new TreeNode(Integer.parseInt(levelOrder[0]));
        list.addLast(root);

        int idx = 1;
        while (list.size() > 0) {
            TreeNode node = list.removeFirst();

            if (!levelOrder[idx].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(levelOrder[idx]));
                node.left = left;
                list.addLast(left);
            }

            idx++;

            if (!levelOrder[idx].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(levelOrder[idx]));
                node.right = right;
                list.addLast(right);
            }

            idx++;
        }

        return root;
    }
}
