package model;

public interface ABB<X,K extends Comparable<K>> {
    X treeSearch(X x,K k);
    X getMinimum(X x);
    X getMaximum(X x);
    void treeInsert(X x);
    void treeDelete(X x);

}
