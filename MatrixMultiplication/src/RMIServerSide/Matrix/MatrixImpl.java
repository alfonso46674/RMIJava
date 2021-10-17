package RMIServerSide.Matrix;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MatrixImpl extends UnicastRemoteObject implements MatrixInterface {

    public MatrixImpl() throws RemoteException {
        super();
    }

    @Override
    public int[][] multiply_matrix(int[][] A, int[][] B, int rowA, int colA, int rowB, int colB) throws RemoteException {

        //check if the multiplication is even possible
        if(rowB != colA){
            System.out.println("Multiplication is not possible\n");
            return null;
        }

        //matrix to store the result. The result matrix will be of size rowA x colB
        int C[][] = new int [rowA][colB];

        //Multiply both matrixes
        for(int i = 0; i < rowA; i++){
            for(int j = 0; j < colB; j++){
                for(int k = 0; k < rowB; k++){
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }
}
