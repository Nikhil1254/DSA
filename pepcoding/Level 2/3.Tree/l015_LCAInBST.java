public class l015_LCAInBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root ;
        TreeNode lca = null ;
        
        while(curr!=null){
            if(curr.val<p.val && curr.val<q.val)
                curr = curr.right ;
            else if(curr.val>p.val && curr.val>q.val)
                curr = curr.left ;
            else{
                lca = curr ;
                break ;
            }
        }
        
        return (lca!=null && find(lca,p) && find(lca,q)) ? lca : null ;
    }
    
    public boolean find(TreeNode root,TreeNode tar){
        TreeNode curr = root ;
        while(curr!=null){
            if(curr.val==tar.val)
                return true ;
            else if(curr.val<tar.val)
                curr = curr.right ;
            else
                curr = curr.left ;
        }
        return false;
    }
}
