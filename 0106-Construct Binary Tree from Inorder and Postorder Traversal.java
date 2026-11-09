import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Integer, Integer> map = new HashMap<>();
    private int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int inLeft, int inRight) {
        if (inLeft > inRight) return null;
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);
        int mid = map.get(rootVal);
        root.right = build(postorder, mid + 1, inRight);
        root.left = build(postorder, inLeft, mid - 1);
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
