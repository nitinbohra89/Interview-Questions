package com.ds.tree;

import java.util.LinkedList;
import java.util.Stack;
/**
 * Created by was on 29/05/17.
 */
public class TreeUtility {

    public static Node printInorderTraversal(Node n,Stack<Node> s,Node root){
       Node left=n,right=null;
        if(n.left!=null){
            left=printInorderTraversal(n.left,s,root);

        }
        if(n.right!=null){
           right= printInorderTraversal(n.right,s,root);
        }
            left.right=right;
        if(right!=null)
            right.left=left;
        return left;
    }

    public static void printPreOrderTraversal(Node n){
        System.out.println(n.value);
        if(n.left!=null){
            printPreOrderTraversal(n.left);
        }
        if(n.right!=null){
            printPreOrderTraversal(n.right);
        }
    }
    public static void printPostOrderTraversal(Node n){
        if(n.left!=null){
            printPostOrderTraversal(n.left);
        }
        if(n.right!=null){
            printPostOrderTraversal(n.right);
        }
        System.out.println(n.value);

    }


    public static void breadthFirstSearch(Node n, LinkedList<Node> list){
        if(n.left!=null){
            list.add(n.left);
        }
        if(n.right!=null){
            list.add(n.right);
        }
        System.out.print(n.value+"  ");
        n=list.poll();
        if(n!=null) {
            breadthFirstSearch(n, list);
        }
    }

    public  static int sizeOfTree(Node n){
        int i=1;
        if(n.left!=null)
            i+=sizeOfTree(n.left);
        if(n.right!=null)
            i+=sizeOfTree(n.right);

        return i;
    }

    public static void levelOrderTraversalPrintLineByLine(Node n, int currentCount, int prevCount, LinkedList<Node> list){
        if(n.left!=null) {
            currentCount += 1;
            list.add(n.left);
        }
        if(n.right!=null){
            currentCount += 1;
            list.add(n.right);
        }
        System.out.print(n.value+"  ");
        n=list.poll();
        prevCount--;
        if(prevCount==0){
            System.out.println();
            prevCount=currentCount;
            currentCount=0;
        }
        if(n!=null)
            levelOrderTraversalPrintLineByLine(n,currentCount,prevCount,list);
    }

    public static void inOrderTreeTraversalWithOutRecursion(Node root){
        Node current =root;
          while(current!=null){
            if(current.left!=null){
                Node predecessor =current.left;
                while(predecessor.right!=null &&predecessor.right!=current){
                    predecessor=predecessor.right;
                }
                if(predecessor==null) {
                    predecessor.right = current;
                    current = current.left;
                }else{
                    predecessor.right=null;
                    System.out.print(predecessor.value+"  ");
                    current=current.right;
                }
            }else{
                System.out.print(current.value+"  ");
                current=current.right;
            }
        }
    }

    public static int maxDepth(Node n){
        int left=0,right=0;
        if(n.left!=null)
            left=maxDepth(n.left)+1;
        if(n.right!=null)
            right=maxDepth(n.right)+1;
        if(left>right)
            return  left;
        else
            return right;
    }
    /*
    Write an Efficient Function to Convert a Binary Tree into its Mirror Tree
    Mirror of a Tree: Mirror of a Binary Tree T is another Binary Tree M(T) with left and right children of all non-leaf nodes interchanged.
    Algorithm – Mirror(tree):

    (1)  Call Mirror for left-subtree    i.e., Mirror(left-subtree)
    (2)  Call Mirror for right-subtree  i.e., Mirror(right-subtree)
    (3)  Swap left and right subtrees.
          temp = left-subtree
          left-subtree = right-subtree
          right-subtree = temp
    */
    public  static  void createMirrorTree(Node n){
        if(n.left!=null)
            createMirrorTree(n.left);
        if(n.right!=null)
            createMirrorTree(n.right);
        Node temp=n.left;
        n.left=n.right;
        n.right=temp;
    }


    /*
    * Given a binary tree, print out all of its root-to-leaf paths one per line.
    *
    */
    public static void printPathForLeafNode(Node n,String path){
        path+=n.value+" ";
        if(n.left!=null)
            printPathForLeafNode(n.left,path);
        if(n.right!=null)
            printPathForLeafNode(n.right,path);
        if(n.left==null&&n.right==null)
            System.out.println(path);
    }

    public static void convertTreeToDoublyLinkedList(Node n,Stack<Node> s){

    }


  // concatenate both the lists and returns the head
        // of the List
        public static Node concatenate(Node leftList,Node rightList)
        {
            // If either of the list is empty, then
            // return the other list
            if (leftList == null)
                return rightList;
            if (rightList == null)
                return leftList;

            // Store the last Node of left List
            Node leftLast = leftList.left;

            // Store the last Node of right List
            Node rightLast = rightList.left;

            // Connect the last node of Left List
            // with the first Node of the right List
            leftLast.right = rightList;
            rightList.left = leftLast;

            // left of first node refers to
            // the last node in the list
            leftList.left = rightLast;

            // Right of last node refers to the first
            // node of the List
            rightLast.right = leftList;

            // Return the Head of the List
            return leftList;
        }

        // Method converts a tree to a circular
        // Link List and then returns the head
        // of the Link List
        public static Node bTreeToCList(Node root)
        {
            if (root == null)
                return null;

            // Recursively convert left and right subtrees
            Node left = bTreeToCList(root.left);
            Node right = bTreeToCList(root.right);

            // Make a circular linked list of single node
            // (or root). To do so, make the right and
            // left pointers of this node point to itself
            root.left = root.right = root;

            // Step 1 (concatenate the left list with the list
            //         with single node, i.e., current node)
            // Step 2 (concatenate the returned list with the
            //         right List)
            return concatenate(concatenate(left, root), right);
        }

        // Display Circular Link List
        public static void display(Node head)
        {
            System.out.println("Circular Linked List is :");
            Node itr = head;
            do
            {
                System.out.print(itr.value+ " " );
                itr = itr.right;
            }
            while (itr != head);
            System.out.println();
        }
    }


