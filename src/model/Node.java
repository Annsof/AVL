package model;

public class Node<K extends Comparable<K>,V> implements Comparable<Node<K,V>> {

    private V value;

    private K key;

    private int height=1;

    private Node<K,V> right;

    private Node<K,V> left;

    public Node(K key,V value) {
        this.value = value;
        this.key = key;
    }
    public String print(){
        return "Key: "+key+", Value: "+value;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Node<K, V> getRight() {
        return right;
    }

    public void setRight(Node<K, V> right) {
        this.right = right;
    }

    public Node<K, V> getLeft() {
        return left;
    }

    public void setLeft(Node<K, V> left) {
        this.left = left;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    @Override
    public int compareTo(Node<K, V> o) {
        return 0;
    }
}
