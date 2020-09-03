package com.hugh.datastructure.binarytree.leecode;

/**
 * @Author Fly.Hugh
 * @Date 2020/9/3 9:41 上午
 * @Version 1.0
 **/
public class Trie {
    public static void main(String[] args) {
        final Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(        trie.search("apple"));
        System.out.println(        trie.search("app"));
    }

    // Implement Trie (Prefix Tree) 字典树 前缀树

    /**
     * 实现一个 Trie (前缀树)，包含insert,search, 和startsWith这三个操作。
     *
     * 示例:
     *
     * Trie trie = new Trie();
     *
     * trie.insert("apple");
     * trie.search("apple");   // 返回 true
     * trie.search("app");     // 返回 false
     * trie.startsWith("app"); // 返回 true
     * trie.insert("app");   
     * trie.search("app");     // 返回 true
     * 说明:
     *
     * 你可以假设所有的输入都是由小写字母a-z构成的。
     * 保证所有输入均为非空字符串。
     *
     */

    private class Node {
        Node[] childs = new Node[26];
        boolean isLeaf;
    }

    private Node root = new Node();

    public Trie() {
    }

    public void insert(String word) {
        insert(word, root);
    }

    private void insert(String word, Node node) {
        if (node == null) return;
        if (word.length() == 0) {
            node.isLeaf = true;
            return;
        }
        int index = indexForChar(word.charAt(0));
        if (node.childs[index] == null) {
            node.childs[index] = new Node();
        }
        insert(word.substring(1), node.childs[index]);
    }

    public boolean search(String word) {
        return search(word, root);
    }

    private boolean search(String word, Node node) {
        if (node == null) return false;
        if (word.length() == 0) return node.isLeaf;
        int index = indexForChar(word.charAt(0));
        return search(word.substring(1), node.childs[index]);
    }

    public boolean startsWith(String prefix) {
        return startWith(prefix, root);
    }

    private boolean startWith(String prefix, Node node) {
        if (node == null) return false;
        if (prefix.length() == 0) return true;
        int index = indexForChar(prefix.charAt(0));
        return startWith(prefix.substring(1), node.childs[index]);
    }

    private int indexForChar(char c) {
        return c - 'a';
    }
}
