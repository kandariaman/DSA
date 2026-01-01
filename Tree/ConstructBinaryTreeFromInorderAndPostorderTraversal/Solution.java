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

    public int findPosition(int[] arr, int n, int element) {
        for(int i=0; i<n; i++){
            if(arr[i] == element){
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int[] postIndex = {postorder.length  - 1};
        return buildTreeSol(inorder, postorder, postorder.length, postIndex, 0, postorder.length - 1);
    }

    public TreeNode buildTreeSol(int[] inorder, int[] postorder, int size, int[] postIndex, int inorderStart, int inorderEnd){
        if(postIndex[0] < 0 || inorderStart > inorderEnd) {
            return null;
        }

        int element = postorder[postIndex[0]];
        postIndex[0]--;

        TreeNode root = new TreeNode(element);

        int pos = findPosition(inorder, size, element);
        root.right = buildTreeSol(inorder, postorder, size, postIndex, pos + 1, inorderEnd);
        root.left = buildTreeSol(inorder, postorder, size, postIndex, inorderStart, pos - 1);

        return root;
    }
}