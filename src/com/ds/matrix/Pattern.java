package com.ds.matrix;

/**
 * Created by was on 07/06/17.
 */
public class Pattern {

    public static  Character[][]printMatrixInRectanglePattern(int row,int column){
        Character matrix[][]=new Character[row][column];
        Character c='X';
        int i=0,j=0;
        return matrix;

    }

    public static void printMatrixInSpiralPattern(int array[][]){
        int row=array.length-1;
        int column=array[0].length-1;
       int i=0,j=0;
        while (i<=row&&j<=column){
            System.out.println("i--"+i+"--j--"+j+"--row--"+row+"--column--"+column);
            for(int k=j;k<=column;k++)
                System.out.print(array[i][k]+"    ");
            System.out.println("i--"+i+"--j--"+j+"--row--"+row+"--column--"+column);

            for(int k=i+1;k<=row;k++)
                System.out.print(array[k][column]+"    ");
            System.out.println("i--"+i+"--j--"+j+"--row--"+row+"--column--"+column);

            for(int k=column-1;k>=i;k--)
                System.out.print(array[row][k]+"    ");
            System.out.println("i--"+i+"--j--"+j+"--row--"+row+"--column--"+column);

            for(int k=row-1;k>i;k--)
                System.out.print(array[k][j]+"    ");
            row=row-1;
            column=column-1;
            i++;
            j++;
        }

    }

    public  static void printCenterOfSpiral(int array[][]){
        int row=array.length;
        int column=array[0].length;
        int rowIndex=0,columnIndex=0;
        if(row<=column){
            rowIndex=row/2;
            columnIndex=rowIndex-1;
        }else{

        }

        System.out.println(array[rowIndex][columnIndex]);
    }

}