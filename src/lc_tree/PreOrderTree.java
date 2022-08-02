package lc_tree;

import java.util.ArrayList;
import java.util.List;

public class PreOrderTree {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {

        if (root == null) return list;
        //list.add(root.val);
        preorderTraversal(root.left);
        //list.add(root.val);
        preorderTraversal(root.right);
        list.add(root.val);
        return list;
    }
}

