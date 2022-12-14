package model;

public class AVL<K extends Comparable<K>,V> implements ABB<Node<K,V>,K  >{

    private Node<K,V> root;
    @Override
    public String inOrder(){
        return inOrder(root);
    }
    private String inOrder(Node<K,V> node){
        String out = "";
        if(node!=null){
            out += inOrder(node.getLeft());
            out +=node.print();
            out +=inOrder(node.getRight());
        }
        return out;
    }
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
    public void treeInsert(Node<K, V> node) {
        root = treeInsert(node,root);
    }
    private Node<K,V> treeInsert(Node<K,V> node, Node<K, V> current) {
        if(current==null){
            return node;
        }
        if(node.getKey().compareTo(current.getKey())<0){
            current.setLeft(treeInsert(node,current.getLeft()));
        } else if (node.getKey().compareTo(current.getKey())>0) {
            current.setRight(treeInsert(node,current.getRight()));
        }else {
            return current;
        }
        updateHeight(current);
        return toRotate(current);
    }

    @Override
    public void treeDelete(K value) {
        Node<K,V> tem = treeSearch(root,value);
        if(tem!=null) {
            root = treeDelete(tem, root);
        }
    }

    private Node<K,V> treeDelete(Node<K,V> node, Node<K, V> current) {
        if(current==null){
            return null;
        }
        if(node.getKey().compareTo(current.getKey())<0){
            current.setLeft(treeDelete(node,current.getLeft()));
        } else if (node.getKey().compareTo(current.getKey())>0) {
            current.setRight(treeDelete(node,current.getRight()));
        }else { // significa que lo encontro
            if(current.getLeft()==null){
                return current.getRight();
            } else if (current.getRight()==null) {
                return current.getLeft();
            }
            Node<K,V> predecessor = getMaximum(current.getLeft());
            current.setKey(predecessor.getKey());
            current.setValue(predecessor.getValue());
            current.setLeft(treeDelete(node,current.getLeft()));
        }
        updateHeight(current);
        return toRotate(current);
    }
    @Override
    public Node<K,V> getMinimum(Node<K,V> node){
        if(node.getLeft()!=null){
            return getMinimum(node.getLeft());
        }
        return node;
    }
    @Override
    public Node<K,V> getMaximum(Node<K,V> node){
        if(node.getRight()!=null){
            return getMaximum(node.getRight());
        }
        return node;
    }
    private void updateHeight(Node<K,V> node){
        if(node!=null) {
            node.setHeight((Math.max(height(node.getLeft()), height(node.getRight()))) + 1);
        }
    }
    private int height(Node<K,V> node){
        return node != null ? node.getHeight() : 0;
    }
    private int balance(Node<K,V> node){
        return node != null ? height(node.getLeft())-height(node.getRight()) : 0;
    }
    public Node<K,V> toRotate(Node<K,V> node){
        int balance = balance(node);
        if(balance>1){//Esta pesado a la izquierda
            if(balance(node.getLeft())<0){ //Caso 3
                node.setLeft(rotatingLeft(node.getLeft()));
            }
            return rotatingRight(node);
        }
        if (balance < -1){//Esta pesado a la derecha
            if(balance(node.getRight())>0){ //Caso 4
                node.setRight(rotatingRight(node.getRight()));
            }
            return rotatingLeft(node);
        }
        return node;
    }
    public Node<K,V> rotatingRight(Node<K,V> node){
        Node<K,V> nodesLeftChild = node.getLeft();
        Node<K,V> nodesLeftRightChild = nodesLeftChild.getRight();
        nodesLeftChild.setRight(node);
        node.setLeft(nodesLeftRightChild);
        updateHeight(node);
        updateHeight(nodesLeftChild);
        return nodesLeftChild;
    }
    public Node<K,V> rotatingLeft(Node<K,V> node){
        Node<K,V> nodesRightChild = node.getRight();
        Node<K,V> nodesRightLeftChild = nodesRightChild.getLeft();
        nodesRightChild.setLeft(node);
        node.setRight(nodesRightLeftChild);
        updateHeight(node);
        updateHeight(nodesRightLeftChild);
        return nodesRightChild;
    }

    public Node<K, V> getRoot() {
        return root;
    }

    public void setRoot(Node<K, V> root) {
        this.root = root;
    }
}
