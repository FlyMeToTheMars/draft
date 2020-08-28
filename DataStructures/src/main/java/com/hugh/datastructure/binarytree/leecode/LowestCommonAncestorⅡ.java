package com.hugh.datastructure.binarytree.leecode;

import com.hugh.datastructure.binarytree.utils.TreeNode;

/**
 * @program: draft
 * @description: 二叉树的最近公共祖先
 * @author: Fly.Hugh
 * @create: 2020-08-29 06:56
 **/
public class LowestCommonAncestorⅡ {
    public static void main(String[] args) {

    }

    /**
    * @author Fly.Hugh
    * @Description
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     * 例如，给定如下二叉树: root =[3,5,1,6,2,0,8,null,null,7,4]
     *
     * 示例 1:
     *
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * 输出: 3
     * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
     * 示例2:
     *
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
     * 输出: 5
     * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
     * 
     *
     * 说明:
     *
     * 所有节点的值都是唯一的。
     * p、q 为不同节点且均存在于给定的二叉树中。
     *
    * @Date 6:57 2020/8/29
    * @Param [root, p, q]
    * @return com.hugh.datastructure.binarytree.utils.TreeNode
    **/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
        * @author Fly.Hugh
        * @Description
         * 首先想到的是链表相交，求第一个交点的算法思想。
         *
         * 如果每个节点有指向父节点的指针的话，我们就可以把给的两个节点当做链表头，树的根是链表尾部。
         * 这样问题就转化为了求两个相交链表的第一个交点。
         *
         * 但是题目给的是一个普通的二叉树，没有父节点指针，所以就需要想其他方法了。
         *
         * 然后是初级递归
         *
         * 先判断公共祖先是否在左子树，是则找到
         * 再判断公共祖先是否在右子树，是则找到
         * 当前根是不是公共祖先，是则找到
         * 当前树没有公共祖先
         *
         * 这里有一个关键问题：怎么判断当前根是不是公共祖先呢？
         * 这个貌似又是一个递归题，可以拆解为根是不是节点A的祖先和根是不是节点B的祖先。
         * 两个同时满足了，根就是这两个节点的公共祖先。
         *
         * 这样这道题我们就做出来了，但是复杂度貌似有点高。
         * 对于每个子树，都进行了判断根是不是祖先，这样就相当于双层循环，复杂度是O(n^2)。
         *
         * 高级递归
         *
         * 其实，在初级递归的时候，复杂度之所高，就是需要在每个子树里判断一个根是不是两个节点的祖先。
         *
         * 这个判断在每个子树里是独立的，但是实际上树与树之间是有关系的。
         * 比如当前树的左儿子是节点A的祖先，那当前树的根肯定也是节点A的祖先。
         *
         * 递归的时候，如果能服用这个信息，则可以将复杂度降低到O(n)。
         *
         * -----
         *
         * 最近公共祖先的定义： 设节点 rootroot 为节点 p, qp,q 的某公共祖先，若其左子节点 root.leftroot.left 和右子节点 root.rightroot.right 都不是 p,qp,q 的公共祖先，则称 rootroot 是 “最近的公共祖先” 。
         *
         * 根据以上定义，若 rootroot 是 p, qp,q 的 最近公共祖先 ，则只可能为以下情况之一：
         *
         * p 和 q 在 rootroot 的子树中，且分列 rootroot 的 异侧（即分别在左、右子树中）；
         * p = rootp=root ，且 qq 在 rootroot 的左或右子树中；
         * q = rootq=root ，且 pp 在 rootroot 的左或右子树中；
         *
        **/
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
        // 后序遍历二叉树，如果找到了p或者q或者null（已经遍历完了这条线路），那么就返回这个本身
        // 然后活到整体的逻辑，最后一个判断非常关键，如果左右都不为空的话返回root根节点 也就是最近公共祖先。
    }
}
