import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {


    //    private class BSTIterator<Key> implements Iterator<Key>{
//
//        @Override
//        public boolean hasNext() {
//            return false;
//        }
//
//        @Override
//        public Key next() {
//            return null;
//        }
//    }
    private class Node {
        private K key;
        private V value;
        private Node father, left, right;
        private int size;

        public Node(K key, V value, Node father, int size) {
            this.father = father;
            this.key = key;
            this.value = value;
            this.size = size;
            this.left = null;
            this.right = null;
        }

        public StringBuilder printInOrder() {
            StringBuilder sb = new StringBuilder();
            if (this.left != null) {
                sb.append(this.left.printInOrder());
            }
            sb.append(this.value + ",");
            if (this.right != null) {
                sb.append(this.right.printInOrder());
            }
            return sb;
        }
    }

    private Node root;

    public BSTMap() {
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    @Override
    public V get(K key) {
        Node n = getNodeByKey(key);
        if (n == null) {
            return null;
        }
        return n.value;
    }

    @Override
    public int size() {
        if (root == null) {
            return 0;
        }
        return root.size + 1;
    }

    @Override
    public void put(K key, V value) {
        if (root == null) {
            root = new Node(key, value, null, 0);
            return;
        }
        Node ptr = root;
        while (true) {
            int cmp = key.compareTo(ptr.key);
            ptr.size += 1;
            if (cmp > 0) {
                if (ptr.right != null) {
                    ptr = ptr.right;
                } else {
                    ptr.right = new Node(key, value, ptr, 0);
                    return;
                }
            } else if (cmp < 0) {
                if (ptr.left != null) {
                    ptr = ptr.left;
                } else {
                    ptr.left = new Node(key, value, ptr, 0);
                    return;
                }
            } else {
                ptr.size -= 1;
                ptr.value = value;
                return;
            }
        }
    }


    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException("unsupported keySet operation in this version");
    }

    @Override
    public V remove(K key) {
        if (!containsKey(key)) {
            return null;
        }
        Node node = getNodeByKey(key);
        Node nodeFather = node.father;
        V value = node.value;
        if (nodeFather == null) {
            if(node.right == null && node.left == null){
                root = null;
                return node.value;
            }
            if (node.right == null) {
                root = node.left;
                node.left.father = null;
                node.left = null;
            } else if (node.left == null) {
                root = node.right;
                node.right.father = null;
                node.right = null;
            } else {
                Node replaceNode = node.right;
                while (replaceNode.left != null) {
                    replaceNode.size -= 1;
                    replaceNode = replaceNode.left;
                }
                replaceNode.left = node.left;
                node.left.father = replaceNode;
                replaceNode.father = null;
                replaceNode.size = node.size - 1;
                node.left = null;
                node.right = null;
                root = replaceNode;
            }
        } else {
            if (node.left != null && node.right != null) {
                Node replaceNode = node.left;
                while (replaceNode.right != null) {
                    replaceNode = replaceNode.right;
                }
                replaceNode.right = node.right;
                node.right.father = replaceNode;
                replaceNode.father = node.father;
            } else if (node.left != null) {
                if (nodeFather.left == node) {
                    nodeFather.left = node.left;
                } else {
                    nodeFather.right = node.left;
                }
                node.left.father = nodeFather;
            } else if (node.right != null) {
                if (nodeFather.left == node) {
                    nodeFather.left = node.right;
                } else {
                    nodeFather.right = node.right;
                }
                node.right.father = nodeFather;
            } else {
                if (nodeFather.left == node) {
                    nodeFather.left = null;
                } else {
                    nodeFather.right = null;
                }
            }
            Node ptr = nodeFather;
            while (ptr != null){
                ptr.size -= 1;
                ptr = ptr.father;
            }
            node.left = null;
            node.right = null;
            node.father = null;
        }
        return value;
    }

    public Node getNodeByKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException("calls get() with a null key");
        }
        Node ptr = root;
        while (ptr != null) {
            int cmp = key.compareTo(ptr.key);
            if (cmp < 0) {
                ptr = ptr.left;
            } else if (cmp > 0) {
                ptr = ptr.right;
            } else {
                return ptr;
            }
        }
        return null;
    }

    @Override
    public V remove(K key, V value) {
        if (get(key) == value) {
            return remove(key);
        }
        return null;
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException("unsupported keySet operation in this version");
    }

    public void printInOrder() {
        if (root == null) {
            return;
        }
        StringBuilder sb = root.printInOrder();
        System.out.println(root.printInOrder().substring(0, sb.length() - 1));
    }

    public static void main(String[] args) {
        BSTMap<Integer, String> map = new BSTMap<>();
        map.put(2, "hello");
        System.out.println(map.size());
        map.put(1, "hi");
        System.out.println(map.size());
        map.put(3, "fuck");
        System.out.println(map.size());
        map.put(-1, "caocap");
        System.out.println(map.size());
        map.put(5, "goog");
        System.out.println(map.size());
        map.printInOrder();
    }
}
