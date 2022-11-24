public class l027_BinaryTreeToBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode binaryTreeToBST(TreeNode root) {

        if (root == null)
            return null;

        TreeNode head = convertBinaryTreeToDLL(root); // Binary Tree To DLL

        displayDLL(head);
        head = convertDLLToSortedDLL(head); // DLL to sorted DLL
        displayDLL(head);
        head = convertSDLLToBST(head); // sorted DLL to BST
        displayTree(head);

        return head; // root of BST
    }

    // will be doing it using morris traversal - Binary tree to DLL
    private TreeNode convertBinaryTreeToDLL(TreeNode root) {
        TreeNode curr = root, dummy = new TreeNode(-1), prev = dummy;

        while (curr != null) {
            TreeNode left = curr.left;
            if (left == null) {
                // inorder region
                prev.right = curr;
                curr.left = prev;

                prev = prev.right;
                curr = curr.right;
            } else {
                TreeNode rightMostNode = getRightMostNode(left, curr);
                if (rightMostNode.right == null) {
                    // thread creation block
                    rightMostNode.right = curr; // thraed created
                    curr = curr.left;
                } else {
                    // thread destroy block - inorder region
                    rightMostNode.right = null;// thread cut

                    prev.right = curr;
                    curr.left = prev;

                    prev = prev.right;
                    curr = curr.right;
                }
            }
        }

        TreeNode head = dummy.right;

        dummy.right = head.left = null;
        return head;

    }

    private TreeNode getRightMostNode(TreeNode node, TreeNode curr) {
        while (node.right != null && node.right != curr)
            node = node.right;

        return node;
    }

    // DLL to sorted DLL
    private TreeNode convertDLLToSortedDLL(TreeNode head) {
        return mergeSortLinkedList(head);
    }

    private TreeNode mergeSortLinkedList(TreeNode head) {

        if (head == null || (head.left == null && head.right == null))
            return head;

        TreeNode midNode = getMidNode(head);
        TreeNode forwHead = midNode.right;

        midNode.right = forwHead.left = null;

        return mergeTwoSortedList(mergeSortLinkedList(head), mergeSortLinkedList(forwHead));
    }

    private TreeNode getMidNode(TreeNode head) {
        if (head == null || head.right == null)
            return head;

        TreeNode slow = head, fast = head;
        while (fast.right != null && fast.right.right != null) {
            slow = slow.right;
            fast = fast.right.right;
        }

        return slow;
    }

    private TreeNode mergeTwoSortedList(TreeNode list1, TreeNode list2) {
        if (list1 == null || list2 == null)
            return list1 == null ? list2 : list1;

        TreeNode dummy = new TreeNode(-1), prev = dummy;

        TreeNode ptr1 = list1, ptr2 = list2;

        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val <= ptr2.val) {
                prev.right = ptr1;
                ptr1.left = prev;
                ptr1 = ptr1.right;
            } else {
                prev.right = ptr2;
                ptr2.left = prev;
                ptr2 = ptr2.right;
            }

            prev = prev.right;
        }

        if (ptr1 != null) {
            prev.right = ptr1;
            ptr1.left = prev;
        } else {
            prev.right = ptr2;
            ptr2.left = prev;
        }

        TreeNode head = dummy.right;
        head.left = dummy.right = null;
        return head;
    }

    // convert Sorted DLL to BST
    private TreeNode convertSDLLToBST(TreeNode head) {

        if (head == null || (head.left == null && head.right == null))
            return head;

        TreeNode midNode = getMidNode(head);
        TreeNode prev = midNode.left, forw = midNode.right;

        midNode.left = midNode.right = forw.left = null;
        if (prev != null)
            prev.right = null;

        midNode.left = convertSDLLToBST(head == midNode ? null : head);
        midNode.right = convertSDLLToBST(forw);

        return midNode;
    }

    // dipslay DLL
    private void displayDLL(TreeNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.right;
        }
        System.out.println("null");
    }

    // display binary tree inorder
    private void displayTree(TreeNode root) {
        if (root == null)
            return;

        String str = "";
        str += root.left != null ? root.left.val : ".";
        str += " <- " + root.val + " -> ";
        str += root.right != null ? root.right.val : ".";
        System.out.println(str);
        displayTree(root.left);
        displayTree(root.right);
    }
}
