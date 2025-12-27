class Solution {
    public boolean isValidBST(TreeNode root) {
        long lowerBound = -4294967296l;
        long upperBound = 4294967296l;
        return solve(root, lowerBound, upperBound);
    }

    public boolean solve(TreeNode root, long lb, long ub){
        if(root == null){
            return true;
        }

        if(root.val > lb && root.val < ub) {
            boolean leftAns = solve(root.left, lb, root.val);
            boolean rightAns = solve(root.right, root.val, ub);
            return leftAns && rightAns;
        }
        return false;
    }
}