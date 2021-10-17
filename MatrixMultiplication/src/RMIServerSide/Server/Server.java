package RMIServerSide.Server;

import RMIServerSide.Matrix.MatrixImpl;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

//must start the rmi registry before trying to run the server
public class Server extends UnicastRemoteObject {
    public Server() throws RemoteException{
        try{
            //register the matrixImpl in the rmi registry
            Naming.rebind("//localhost/matrix", new MatrixImpl());
            System.err.println("Server ready");

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws RemoteException {
        new Server();
    }
}
