package trie;

/**
 * @Author Fly.Hugh
 * @Date 2020/9/3 11:08
 * @Version 1.0
 **/
public class TrieNode {

    TrieNode[] child;

    boolean isEnd;

    public TrieNode() {
        this.child = new TrieNode[26];
        this.isEnd = false;
    }
}
