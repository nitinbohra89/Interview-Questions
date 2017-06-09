package com.ds.grammer;

/**
 * Created by was on 04/06/17.
 */
public class Main {
    public static void main(String args[]){

        System.out.println("----------------printAlPermutations--------------------");
       Grammer.printAlPermutations("ABC",0,2);
        System.out.println();
        System.out.println("----------------deriveAllPossibleWordsUsingWordsOfGivenString--------------------");

        Grammer.deriveAllPossibleWordsUsingWordsOfGivenString("ABC","");
        System.out.println();
        System.out.println("----------------printAlPermutationsWithoutRecursion--------------------");
        Grammer.printAlPermutationsWithoutRecursion("ABCD");
    }
}
