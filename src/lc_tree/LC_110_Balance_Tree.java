package lc_tree;

public class LC_110_Balance_Tree {
    private boolean result = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return false;
        }
        chargeHigh(root);
        return result;
        //二叉平衡树定义为左右两个子树的高度差不超过1

    }

    public int chargeHigh(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = chargeHigh(root.left);
        int r = chargeHigh(root.right);
        if (Math.max(l,r)-1>0)result=false;
        return Math.max(l,r)+1;
    }
}

