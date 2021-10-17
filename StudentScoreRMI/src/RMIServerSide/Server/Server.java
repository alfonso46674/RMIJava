package RMIServerSide.Server;

import RMIServerSide.Promotion.PromotionImpl;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject {
    public Server() throws RemoteException {
    }

    public static void main(String[] args) {
        try{
            //Must start the rmiRegistry before trying to run the server file, for that we can execute the startServer.bat file
            //Register the Promotion object in the rmi registry
            Naming.rebind("//localhost/promotion",new PromotionImpl("Math"));
            System.err.println("Server ready");


        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
