package RMIClientSide;

import RMIServerSide.Matrix.MatrixInterface;

import java.rmi.Naming;

public class Client {
    private static MatrixInterface matrix;

    public static void main(String[] args) {
        try{
            //lookup for the remote matrix object in the rmi registry
            matrix = (MatrixInterface) Naming.lookup("//localhost/matrix");

            //test the matrix functions
            int A[][] = {
                            { 1, 1, 1 },
                            { 2, 2, 2 },
                            { 3, 3, 3 },
                            { 4, 4, 4 }
                        };

            int B[][] = {
                            { 9, 9, 9, 9 },
                            { 8, 8, 8, 8 },
                            { 7, 7, 7, 7 }
                        };

            int C[][] = matrix.multiply_matrix(A,B,4,3,3,4);

            //display the result matrix
            for(int[] row : C){
                for(int column : row){
                    System.out.print(column + "  ");
                }
                System.out.println();
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
