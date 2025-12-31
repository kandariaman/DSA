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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] preIndex = {0};
        return buildTreeSol(preorder, inorder, preorder.length, preIndex, 0, preorder.length - 1);
    }

    public TreeNode buildTreeSol(int[] preorder, int[] inorder, int size, int[] preIndex, int inorderStart, int inorderEnd){
        if(inorderStart > inorderEnd) {
            return null;
        }

        int element = preorder[preIndex[0]];
        preIndex[0]++;
        TreeNode root = new TreeNode(element);

        int pos = findPosition(inorder, size, element);

        root.left = buildTreeSol(preorder, inorder, size, preIndex, inorderStart, pos - 1);
        root.right = buildTreeSol(preorder, inorder, size, preIndex, pos + 1, inorderEnd);

        return root;
    }
}