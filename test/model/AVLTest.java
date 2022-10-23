package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AVLTest {
    AVL<Integer,String> tree;
    public void setUp1(){
        tree= new AVL<>();
    }
    public void setUp2(){
        tree= new AVL<>();
        tree.treeInsert(new Node<>(10,"Julia"));
        tree.treeInsert(new Node<>(5,"Fabricio"));
        tree.treeInsert(new Node<>(13,"Ricardo"));
        tree.treeInsert(new Node<>(6,"Juana"));
    }

    @Test
    public void insertTest1(){
        setUp1();
        tree.treeInsert(new Node<>(8,"Patricia"));
        assertEquals(tree.inOrder(),"Key: 8, Value: Patricia");
    }
    @Test
    public void insertTest2(){
        setUp1();
        tree.treeInsert(new Node<>(8,"Patricia"));
        tree.treeInsert(new Node<>(12,"Eunice"));
        tree.treeInsert(new Node<>(20,"Lorena"));
        tree.treeInsert(new Node<>(2,"Javier"));
        assertEquals(tree.inOrder(),"Key: 2, Value: JavierKey: 8, Value: PatriciaKey: 12, Value: EuniceKey: 20, Value: Lorena");
    }
    @Test
    public void insertTest3(){
        setUp1();
        tree.treeInsert(new Node<>(2,"Javier"));
        tree.treeInsert(new Node<>(8,"Patricia"));
        tree.treeInsert(new Node<>(20,"Lorena"));
        tree.treeInsert(new Node<>(12,"Eunice"));
        assertEquals(tree.getRoot().getKey(),8);
    }
    @Test
    public void deleteTest1(){
        setUp2();
        tree.treeDelete(10);
        assertEquals(tree.getRoot().getKey(),6);
    }
    @Test
    public void deleteTest2(){
        setUp2();
        tree.treeDelete(11);
        assertEquals(tree.getRoot().getKey(),10);
    }
    @Test
    public void deleteTest3(){
        setUp2();
        tree.treeInsert(new Node<>(8,"Patricia"));
        tree.treeInsert(new Node<>(12,"Eunice"));
        tree.treeInsert(new Node<>(20,"Lorena"));
        tree.treeInsert(new Node<>(2,"Javier"));
        tree.treeDelete(10);
        assertEquals(tree.inOrder(),"Key: 2, Value: JavierKey: 5, Value: FabricioKey: 6, Value: JuanaKey: 8, Value: PatriciaKey: 12, Value: EuniceKey: 13, Value: RicardoKey: 20, Value: Lorena");
    }

}