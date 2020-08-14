package com.hugh.datastructure.binarytree.leecode;

import com.hugh.datastructure.binarytree.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author Fly.Hugh
 * @Date 2020/8/14 11:53
 * @Version 1.0
 **/
public class BFS {
    public static void main(String[] args) {

    }

    /**
     * 广度优先搜索算法 广度优先遍历
     * 又叫宽度优先搜索，或横向优先搜索
     * 是从根节点开始，沿着树的宽度遍历树的节点。如果所有节点均被访问，则算法中止。
     *                  A
     *                /   \
     *               B     C
     *             /  \  /  \
     *            D   E F   G
     * 如右图所示的二叉树，A 是第一个访问的，然后顺序是 B、C，然后再是 D、E、F、G。
     *
     * 广度优先遍历的递归写法太麻烦了。。。。
     * 还不如迭代写法简单
     * @param root
     */
    public List<List<TreeNode>> breadthFirstSearch(TreeNode root) {
        if (root == null) return null;
        List<List<TreeNode>> list = new ArrayList<>();
        dfs(root, 0, list);
        return list;
    }

    private void dfs(TreeNode root, int level, List<List<TreeNode>> list) {
        if (root == null) return;
        if (level >= list.size()) {
            ArrayList<TreeNode> subList = new ArrayList<>();
            subList.add(root);
            list.add(subList);
        } else {
            list.get(level).add(root);
        }
        dfs(root.left, level + 1, list);
        dfs(root.right, level + 1, list);
    }

    public static void broadFirstSearchIter(TreeNode tree) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");

            // queue先进先出，所以先左后右
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        System.out.println();
    }
}
