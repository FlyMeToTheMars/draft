package com.hugh.datastructure.binarytree.leecode;

import com.hugh.datastructure.binarytree.utils.TreeNode;
import com.hugh.datastructure.binarytree.utils.TreeUtils;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author Fly.Hugh
 * @Date 2020/8/14 11:37
 * @Version 1.0
 **/
public class DFS {
    public static void main(String[] args) {
        TreeNode root = TreeUtils.generateTreeFromArray(1, 2, 3, 4, 5, 6, 7);
        List<TreeNode> treeNodes = new DFS().depthFirstSearch(root);
        for (TreeNode node:
             treeNodes) {
            System.out.println(node.val);
        }
    }

    /**
     * 深度优先搜索算法（Depth First Search）
     * DFS是搜索算法的一种。它沿着树的深度遍历树的节点，尽可能深的搜索树的分支。
     * 当节点v的所有边都己被探寻过，搜索将回溯到发现节点v的那条边的起始节点。这一过程一直进行到已发现从源节点可达的所有节点为止。
     * 如果还存在未被发现的节点，则选择其中一个作为源节点并重复以上过程，整个进程反复进行直到所有节点都被访问为止。
     *                  A
     *                /   \
     *               B     C
     *             /  \  /  \
     *            D   E F   G
     * A 是第一个访问的，然后顺序是 B、D，然后是 E。接着再是 C、F、G。
     * 在遍历了根结点后，就开始遍历左子树，最后才是右子树。
     * 因此可以借助堆栈的数据结构，由于堆栈是后进先出的顺序，由此可以先将右子树压栈，然后再对左子树压栈，
     * 这样一来，左子树结点就存在了栈顶上，因此某结点的左子树能在它的右子树遍历之前被遍历。
     *
     * 前序、中序、后续遍历三种遍历方式都是DFS（深度优先遍历的三种方式）
     * 这里给出的是通过引入DFS
     * @param root
     */
    public List<TreeNode> depthFirstSearch(TreeNode root) {
        dfs(root);
        return list;
    }

    List<TreeNode> list = new ArrayList<>();

    private void dfs(TreeNode root) {
        if (root == null) return;
        list.add(root);
        dfs(root.left);
        dfs(root.right);
    }
}
