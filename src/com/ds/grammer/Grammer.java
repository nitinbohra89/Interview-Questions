package com.ds.grammer;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Nitin on 03/06/17.
 *
 */
public class Grammer {



    /*
    * PROBLEM- Write a program to print all permutations of a given string
    * INPUT- ABC, 0 ,ABC.length()-1
    * OUTPUT - ABC ACB BAC BCA CBA CAB
    * LINK - http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
    * */
    public static  void printAlPermutations(String s,int first,int last){
        if(first==last){
           System.out.print(s+" ");
        }else {
            for (int i = first; i <= last; i++) {
                printAlPermutations(swap(s, first,i), first+1, last);
            }
        }

    }
    /*
    * PROBLEM- Write a program to print all permutations of a given string without Recursion(Using Loop only)
    * INPUT- ABC
    * OUTPUT - ABC ACB BAC BCA CAB CBA
    * LINK - http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
    * */
    public static  void printAlPermutationsWithoutRecursion(String s){
        int totalCharacters=s.length();                 //Total no. of characters present in String
        int factorial[]=factorial(totalCharacters);     //Getting factorial for all integers from 0 to totalCharacters in String
        int totalWords=factorial[totalCharacters];      //Calculating total no. of words generated from permutation of characters of String
        String word,temp;                               //Temporary String for manipulation word
        int remainingChars,wordsPerChar,index;
        for(int i=1;i<=totalWords;i++){                 //Looping to total no. of words generated from String
             word="";                                   //Initialization
             temp=s;
            int wordIndex=i;                            //Position of the word in grammer generated from characters of String
            for(int j=0;j<totalCharacters;j++){         //Looping to extract character on each index of word
                if(wordIndex==0){                       //If WordIndex=0 then no manipulation just return the word and temp
                    word+=temp;
                    break;
                }
                remainingChars=totalCharacters-j;                       //Calculating remaining chracters
                wordsPerChar=factorial[remainingChars]/remainingChars;  //Calculating total words which will start from character
                if(wordIndex%wordsPerChar==0){
                    index=(wordIndex/wordsPerChar);
                    wordIndex=factorial[remainingChars-1];
                }
                else{
                    index=(wordIndex/wordsPerChar)+1;
                    wordIndex=wordIndex%wordsPerChar;
                }
                word+=temp.charAt(index-1);
                temp=removeCharacter(temp,index-1);

            }
            System.out.print(word+" ");

        }
    }

    /*
    * PROBLEM- Write a program to print all words derived from the characters of a given string
    * INPUT- ABC, ""
    * OUTPUT - A AB ABC AC ACB B BA BAC BC BCA C CA CAB CB CBA
    *
    * LINK -
    * */
    public static  void deriveAllPossibleWordsUsingWordsOfGivenString(String s,String temp){
       for(int i=0;i<s.length();i++){
            System.out.print(temp+s.charAt(i)+" ");
           deriveAllPossibleWordsUsingWordsOfGivenString(removeCharacter(s,i),temp+s.charAt(i));

       }

    }

    /*
    *SUPPORTIVE FUNCTION
    * PROBLEM- Write a program to swap a character from another in a String
    * INPUT- ABC,0,2
    * OUTPUT - CBA
    * */
    public static  String swap(String s,int first,int second){
        StringBuffer sb=new StringBuffer(s);
        char c=s.charAt(first);
        sb.replace(first,first+1,String.valueOf(s.charAt(second)));
        sb.replace(second,second+1,String.valueOf(c));
        return  sb.toString();
    }

    /*
    *SUPPORTIVE FUNCTION
    * PROBLEM- Write a program to remove character from particuar Index in a String
    * INPUT- ABC,0
    * OUTPUT - BC
    * */
    public static String removeCharacter(String s,int index){
        StringBuffer temp=new StringBuffer(s);
       return temp.replace(index,index+1,"").toString();
    }


    /*
    *SUPPORTIVE FUNCTION
    * PROBLEM- Write a program to calculate the factorial of all numbers starting from 0 to input number
    * INPUT- 5
    * OUTPUT - Array of Integer having factorial of all numbers from 0 to 5
    * */
    public static int[] factorial(int index){

        int tempArray[]= new int[index+1];
        tempArray[0]=1;
        for(int i=1;i<=index;i++){
            tempArray[i]=tempArray[i-1]*i;
        }
        return tempArray;
    }

}
