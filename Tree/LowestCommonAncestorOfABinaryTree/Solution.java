package LowestCommonAncestorOfABinaryTree;

public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }

        if(root.val == p.val) {
            return p;
        }

        if(root.val == q.val) {
            return q;
        }

        TreeNode leftAns = lowestCommonAncestor(root.left, p, q);
        TreeNode rightAns =  lowestCommonAncestor(root.right, p, q);

        if(leftAns == null && rightAns == null) {
            return null;
        }
        else if(leftAns != null && rightAns == null) {
            return leftAns;
        }
        else if(leftAns == null && rightAns != null) {
            return rightAns;
        }
        else  {
            return root;
        }
    }
}