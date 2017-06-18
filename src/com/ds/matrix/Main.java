package com.ds.matrix;

/**
 * Created by was on 09/06/17.
 */
public class Main {

    public  static void main(String args[]){
       // Character matrix[][]=Pattern.printMatrixInRectanglePattern(4,4);
/*        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++)
                System.out.print(matrix[i][j]+"  ");
            System.out.println();
        }*/
        int counter=0;
        int matrix[][]=new int[5][10];
      for(int i=0;i<5;i++){
            for(int j=0;j<10;j++) {
                matrix[i][j] = counter++;
                System.out.print(matrix[i][j] + "  ");
            }
          System.out.println();
        }

        Pattern.printMatrixInSpiralPattern(matrix);
        System.out.println();
        Pattern.printCenterOfSpiral(matrix);



    }
}
