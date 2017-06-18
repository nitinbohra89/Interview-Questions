package com.ds.pattern;

/**
 * Created by was on 04/06/17.
 */
public class PrintAllCombinationToComposeNumber {
    public static void getAllCombinations(int index,int s){
        if(index==0){
            System.out.println(s);
            String s2="";
            while(s>0){
                int temp=s%10;
                s=s/10;
                s2=PrintAllCombinationToComposeNumber.getPattern(temp)+s2;
            }
            System.out.println(s2);
        }
        else{
            for(int i=1;i<=index;i++)
                getAllCombinations(index-i,s*10+i);
        }
    }

    public static void getAllCombinationsUsingString(int index,String s){
        if(index==0){
            System.out.println(s);
        }else{
            for(int i=1;i<=index;i++){
                getAllCombinationsUsingString(index-i,s+i);
            }
        }
    }

public  static String LCS(String s1,String s2,int s1length,int s2Length){
   int matrix[][] =new int[s1length+1][s2Length+1];
    for(int i=0;i<=s1length;i++){
        for(int j=0;j<=s2Length;j++){
            if(i==0||j==0){
                matrix[i][j]=0;
            }else if(s1.charAt(i-1)==s2.charAt(j-1)){
                matrix[i][j]=matrix[i-1][j-1]+1;
            }else{
                matrix[i][j]=(matrix[i-1][j]>matrix[i][j-1]?matrix[i-1][j]:matrix[i][j-1]);
            }
        }
    }

    for(int i=0;i<=s1length;i++){
        for(int j=0;j<=s2Length;j++){
            System.out.print(matrix[i][j]+" ");
        }
        System.out.println();
    }

    String s="";
    int i=s1length,j=s2Length;
    while(matrix[i][j]>0){
        if(matrix[i][j]>matrix[i-1][j]&&matrix[i][j]>matrix[i][j-1]){
            s=s1.charAt(i-1)+s;
            i=i-1;
            j=j-1;
        }else if(matrix[i][j]==matrix[i-1][j]){
            i=i-1;
        }else if(matrix[i][j]==matrix[i][j-1]){
            j=j-1;
        }
    }
    System.out.println("String---"+s);



    return "";
}


    public static String getPattern(int counter){
        String temp="";
        for(int i=0;i<counter;i++){
            temp=temp+"(";
        }
        for(int i=0;i<counter;i++){
            temp=temp+")";
        }
        return temp;
    }
}
