package wdw.classic.shortestPath.BST;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int N;

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    public boolean contains(Key key) {
        return contains(root, key);
    }

    private boolean contains(Node node, Key key) {
        if (node == null)
            return false;
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            return contains(node.left, key);
        else if (cmp > 0)
            return contains(node.right, key);
        else
            return true;
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null)
            return 0;
        else
            return node.N;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {

        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            return get(node.left, key);
        else if (cmp > 0)
            return get(node.right, key);
        else
            return node.value;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null)
            return new Node(key, value, 1);
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = put(node.left, key, value);
        else if (cmp > 0)
            node.right = put(node.right, key, value);
        else
            node.value = value;
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    private Node min(Node node) {
        if (node.left == null)
            return node;
        return min(node.left);
    }

    public Key min() {
        return min(root).key;
    }

    public Key max() {
        return max(root).key;
    }

    private Node max(Node node) {
        if (node.right == null)
            return node;
        return max(node.right);
    }

    public void deleteMin() {
        deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null)
            return node.right;
        node.left = deleteMin(node.left);
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void deleteMax() {
        deleteMax(root);
    }

    private Node deleteMax(Node node) {
        if (node.right == null)
            return node.left;
        node.right = deleteMax(node.right);
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }
    /**
     * 删除一个有两个子节点的节点，在删除节点x后用他的后继子节点填补它的位置
     * 后继子节点：右子树中的最小节点
     */
    private Node delete(Node node,Key key){
        if(node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if(cmp < 0)
            node.left = delete(node.left,key);
        else if(cmp > 0)
            node.right = delete(node.right,key);
        else{
            if(node.left == null)
                return node.right;
            if(node.right == null)
                return node.left;
            Node t = node;
            node = min(t.right);
            node.right = deleteMin(t.right);
            node.left = t.left;
        }
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }


    public static void main(String[] args) {
        BST<Integer, Integer> map = new BST<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(-1, -1);
        map.put(-2, -3);
        System.out.println(map.get(-1));
        System.out.println(map.size());
        System.out.println(map.get(map.max()));
        System.out.println(map.get(map.min()));
        System.out.println(map.contains(-2));
        map.deleteMin();
        System.out.println(map.get(map.min()));
        System.out.println(map.contains(-2));
    }
}
