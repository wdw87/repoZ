package wdw.classic.structures.trieST;

public class Trie {
    private static int R = 256; //基数
    private Node root;

    private static class Node {
        private boolean hasWord;
        private Node[] nexts = new Node[R];
    }

    public boolean get(String s) {
        Node node = get(s, root, 0);
        if (node == null) return false;
        return node.hasWord;
    }

    private Node get(String s, Node node, int index) {
        if (node == null)
            return null;
        if (index == s.length())
            return node;
        char c = s.charAt(index);
        return get(s, node.nexts[c], index + 1);
    }

    public void put(String s, boolean val) {
        root = put(s, root, val, 0);
    }

    private Node put(String s, Node node, boolean val, int index) {
        if (node == null)
            node = new Node();
        if (index == s.length()) {
            node.hasWord = val;
            return node;
        }
        char c = s.charAt(index);
        node.nexts[c] = put(s, node.nexts[c], val, index + 1);
        return node;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.put("wdw",true);
        trie.put("wxj",true);
        System.out.println(trie.get("wdw"));
        System.out.println(trie.get("wxj"));

    }
}
