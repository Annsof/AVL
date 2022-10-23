package model;

public interface ABB<X extends Comparable<X>,K extends Comparable<K>> {
    X treeSearch(X x,K k);
    X treeMinimum(X x);
    X treeMaximum(X x);
    X treeSuccessor(X x);
    void treeInsert(X x);
    void treeDelete(X x);

}
