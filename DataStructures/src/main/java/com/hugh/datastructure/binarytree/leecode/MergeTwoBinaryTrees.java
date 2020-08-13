package com.hugh.datastructure.binarytree.leecode;

import com.hugh.datastructure.binarytree.utils.TreeNode;
import com.hugh.datastructure.binarytree.utils.TreeUtils;

/**
 * @program: draft
 * @description: 归并两棵树
 * @author: Fly.Hugh
 * @create: 2020-08-14 00:44
 **/
public class MergeTwoBinaryTrees {
    public static void main(String[] args) {
        TreeNode t1 = TreeUtils.generateTreeFromArray(1, 3, 2, 5);
        TreeNode t2 = TreeUtils.generateTreeFromArray(2, 1, 3, null, 4, null, 7);
        TreeNode root = new MergeTwoBinaryTrees().mergeTrees(t1, t2);
        TreeUtils.preOrderTraverse(root);
    }

    /**
    * @author Fly.Hugh
    * @Description 这题，总的来说还是在公式里面，有个特点就是输入是两个，输出却只有一个
     * 这种多输入 单输出的递归，值得注意一下
     * 可以新建一个TreeNode或者直接在原先的某一个树上直接修改。
     * 原理也很简单，直接从t1最左边的节点，继续往下（不够从t2左边拉），到了最下面之后然后回到上一层，再讨论右边，就这样逐层递归。
    * @Date 0:46 2020/8/14
    * @Param [t1, t2]
    * @return com.hugh.datastructure.binarytree.utils.TreeNode
    **/
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right); // 这边的left 和 right还容易写错。。。。
        return t1;
    }
}
