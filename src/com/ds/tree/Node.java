package com.ds.tree;

/**
 * Created by was on 29/05/17.
 */
public class Node {
    int value;
    Node left, right;
    public Node(int value){
        this.value=value;
        left=null;
        right=null;
    }

    public Node(int value, Node left, Node right){
        this.value=value;
        this.left=left;

        this.right=right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

}
