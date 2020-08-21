package com.hugh.datastructure.binarytree.leecode;

import com.hugh.datastructure.binarytree.utils.TreeNode;

/**
 * @Author Fly.Hugh
 * @Date 2020/8/21 3:12 下午
 * @Version 1.0
 **/
public class KthSmallestElementInABST {
    public static void main(String[] args) {

    }

    /**
     * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
     * <p>
     * 说明：
     * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: root = [3,1,4,null,2], k = 1
     * 3
     * / \
     * 1   4
     * \
     * 2
     * 输出: 1
     * 示例 2:
     * <p>
     * 输入: root = [5,3,6,2,4,null,null,1], k = 3
     * 5
     * / \
     * 3   6
     * / \
     * 2   4
     * /
     * 1
     * 输出: 3
     * 进阶：
     * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return back;
    }

    private int count = 0;
    private int back;

    private void inOrder(TreeNode root, int k) {
        if (root == null) return;
        inOrder(root.left, k);
        count++;
        if (count == k) {
            back = root.val;
            return;
        }
        inOrder(root.right, k);
    }

    //==================================================分割符>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    /**
     * 说实话 上面的解法，我刚开始看LeeCOde的时候还感觉挺有意思，到了现在已经没有任何惊喜了
     * 简单的中序遍历
     * 下面的这个解法别有新意。
     * 从Count入手。
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallestNiu(TreeNode root, int k) {
        int leftCnt = count(root.left);
        if (leftCnt == k-1) return root.val;
        if (leftCnt > k-1) return kthSmallestNiu(root.left, k);
        return kthSmallestNiu(root.right, k - leftCnt - 1);
    }

    private int count(TreeNode root) {
        if (root == null) return 0;
        return 1 + count(root.left) + count(root.right);
    }

}
