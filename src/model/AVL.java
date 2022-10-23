package model;

public class AVL<K extends Comparable<K>,V> implements ABB<Node<K,V>,K  >{

    private Node<K,V> root;

    @Override
    public Node<K, V> treeSearch(Node<K, V> x, K k) {
        if(x==null || k.equals(x.getKey())){
            return x;
        }
        if(k.compareTo(x.getKey())>0){ //Si la llave el mayor que la llave actual
            return treeSearch(x.getRight(),k);
        }else {
            return treeSearch(x.getLeft(),k);
        }
    }

    @Override
    public Node<K, V> treeMinimum(Node<K, V> x) {
        while(x.getLeft()!=null){
            return x.getLeft();
        }

    }

    @Override
    public Node<K, V> treeMaximum(Node<K, V> kvNode) {
        return null;
    }

    @Override
    public Node<K, V> treeSuccessor(Node<K, V> kvNode) {
        return null;
    }

    @Override
    public void treeInsert(Node<K, V> kvNode) {

    }

    @Override
    public void treeDelete(Node<K, V> kvNode) {

    }
}
