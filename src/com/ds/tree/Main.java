package com.ds.tree;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by was on 29/05/17.
 */
public class Main {
    public static void main(String args[]){
    Node n=createTree();
        Stack<Node> s=new Stack<>();
        Node temp=null;
        TreeUtility.printInorderTraversal(n,s,temp);
        System.out.print("Linklist--");
        while (temp!=null){
            System.out.print(temp.value+"  ");
            temp=temp.right;
        }
       // TreeUtility.printPreOrderTraversal(n);
      //  TreeUtility.printPostOrderTraversal(n);
        LinkedList<Node> l=new LinkedList<Node>();
       // l.add(n);
      //  TreeUtility.breadthFirstSearch(n,l);
      //  System.out.println(TreeUtility.sizeOfTree(n));
       TreeUtility.levelOrderTraversalPrintLineByLine(n,0,1,l);
      //  TreeUtility.inOrderTreeTraversalWithOutRecursion(n);
    //  System.out.print(TreeUtility.maxDepth(n));
      //  TreeUtility.createMirrorTree(n);
       // System.out.println("After mirroring ");
       // TreeUtility.levelOrderTraversalPrintLineByLine(n,0,1,l);
       // TreeUtility.printPathForLeafNode(n,"");
        // head refers to the head of the Link List
       // Node head = TreeUtility.bTreeToCList(n);
        Node n1=new Node(0);
        //    TreeUtility.convertTreeToDoublyLinkedList(n,n1);
        // Display the Circular LinkedList
        TreeUtility.display(n1);
    }

    /*
    * Create Tree Mentioned in Image
    * 	                    0
	             1                     2
	        3         4          5           6
	           7         11  12                 8
	        9     13
	    10     14
	              15
    */
    public static Node createTree() {
        Node n_left_left_right_left_left = new Node(10, null, null);

        Node n_left_left_right_right_left_right = new Node(15, null, null);

        Node n_left_left_right_right_left = new Node(14, null, n_left_left_right_right_left_right);

        Node n_left_left_right_left = new Node(9, n_left_left_right_left_left, null);
        Node n_left_left_right_right = new Node(13, n_left_left_right_right_left, null);

        Node n_left_left_right = new Node(7, n_left_left_right_left, n_left_left_right_right);
        Node n_right_right_right = new Node(8, null, null);

        Node n_left_right_right = new Node(11, null, null);
        Node n_right_left_left = new Node(12, null, null);

        Node n_left_left = new Node(3, null, n_left_left_right);
        Node n_left_right = new Node(4, null, n_left_right_right);
        Node n_right_left = new Node(5, n_right_left_left, null);
        Node n_right_right = new Node(6, null, n_right_right_right);

        Node n_left = new Node(1, n_left_left, n_left_right);
        Node n_right = new Node(2, n_right_left, n_right_right);

        Node n = new Node(0, n_left, n_right);
        return n;
    }



}
