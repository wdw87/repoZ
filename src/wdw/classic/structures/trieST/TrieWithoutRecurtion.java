package wdw.classic.structures.trieST;

public class TrieWithoutRecurtion {
    private static final int R = 256;
    private Node root = new Node();

    private class Node{
        private boolean hasWord;
        private Node[] next = new Node[R];
    }
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = root;
        for(char c : word.toCharArray()){
            if(node.next[c] == null) node.next[c] = new Node();
            node = node.next[c];
        }
        node.hasWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = root;
        for(char c : word.toCharArray()){
            if(node.next[c] == null) return false;
            node = node.next[c];
        }
        return node.hasWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node = root;
        for(char c : prefix.toCharArray()){
            if(node.next[c] == null) return false;
            node = node.next[c];
        }
        return true;
    }

    /** Initialize your data structure here. */
    public TrieWithoutRecurtion() {

    }

}
