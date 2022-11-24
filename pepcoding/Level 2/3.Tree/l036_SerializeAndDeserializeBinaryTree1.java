// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

// solution1 - 1.serialize -> converting to preorder string using recursion
// 2. deserialize -> converting that preorder string to tree using recursion 
public class l036_SerializeAndDeserializeBinaryTree1 {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int data) {
            this.val = data;
        }
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("# ");
            return;
        }

        sb.append(root.val + " ");
        serialize(root.left, sb);
        serialize(root.right, sb);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(" ");
        return deserialize(arr);
    }

    int idx = 0;

    private TreeNode deserialize(String[] data) {
        if (idx >= data.length || data[idx].equals("#")) {
            idx++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(data[idx++]));
        root.left = deserialize(data);
        root.right = deserialize(data);

        return root;
    }
}
