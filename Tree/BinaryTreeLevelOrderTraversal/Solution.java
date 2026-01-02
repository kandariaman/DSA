public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> outerList = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int len = q.size() - 1;
            List<Integer> innerList = new ArrayList<>();
            for(int i = 0; i<=len; i++){
                TreeNode temp = q.poll();
                if(temp != null) {
                    innerList.add(temp.val);
                    if(temp.left != null){
                        q.add(temp.left);
                    }
                    if(temp.right != null){
                        q.add(temp.right);
                    }
                }
            }
            if(!innerList.isEmpty()){
                outerList.add(innerList);
            }
        }
        return outerList;
    }
}