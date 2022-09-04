package lc_tree;

public class LC_654_MaxBinaryTree {


    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return build(nums,0,nums.length-1);
    }

    private TreeNode build(int[] nums, int lo, int hi) {

        if (lo > hi) {
            return null;
        }
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }

        TreeNode root = new TreeNode(max);
        root.left = build(nums, lo, index - 1);
        root.right = build(nums, index + 1, hi);

        return root;

    }


}
