import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Integer, Integer> map = new HashMap<>();
    private int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int inLeft, int inRight) {
        if (inLeft > inRight) return null;

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);
        int mid = map.get(rootVal);

        root.left = build(preorder, inLeft, mid - 1);
        root.right = build(preorder, mid + 1, inRight);
        return root;
    }
}

class TreeNode {
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
