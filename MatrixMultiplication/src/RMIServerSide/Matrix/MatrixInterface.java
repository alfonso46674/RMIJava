package RMIServerSide.Matrix;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MatrixInterface extends Remote {

    //multiply two matrixes and return the result matrix
    //it takes the two matrixes as parameters, as well as the number of rows and columns for each matrix
    public int[][] multiply_matrix(int A[][], int B[][], int rowA, int colA, int rowB, int colB) throws RemoteException;

    //display the result matrix
    public void display_matrix(int [][] matrix) throws RemoteException;

}

