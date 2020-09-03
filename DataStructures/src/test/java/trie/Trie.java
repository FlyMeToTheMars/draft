package trie;

/**
 * @Author Fly.Hugh
 * @Date 2020/9/3 11:08
 * @Version 1.0
 **/
public class Trie {

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode p = root;
        for(int i = 0; i < word.length(); i ++) {
            char c = word.charAt(i);
            // 对应位置上只要不是空就代表有值，并不需要填入某个确定的char，[c - 'a'] 代表了index
            if(p.child[c - 'a'] == null) {
                p.child[c - 'a'] = new TrieNode();
            }
            // 有点类似与二叉树的node = node.next;
            p = p.child[c - 'a'];
        }
        p.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode p = root;
        for(int i = 0; i < word.length(); i ++) {
            char c = word.charAt(i);
            if(p.child[c - 'a'] == null) {
                return false;
            }
            p = p.child[c - 'a'];
        }
        /*if(p.isEnd == true) {
            return true;
        }
        return false;*/
        return p.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for(int i = 0; i < prefix.length(); i ++) {
            char c = prefix.charAt(i);
            if(p.child[c - 'a'] == null) {
                return false;
            }
            p = p.child[c - 'a'];
        }
        return true;
    }
}
