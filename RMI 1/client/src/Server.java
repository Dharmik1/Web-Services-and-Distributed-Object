
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements ServerInterface  {


    public String name;
    public ServerInterface client=null;

    public Server(String n)  throws RemoteException {
        this.name=n;
    }
    public String getName() throws RemoteException {
        return this.name;
    }

    public void setClient(ServerInterface c){
        client=c;
    }

    public ServerInterface getClient(){
        return client;
    }

    public void send(String s) throws RemoteException{
        System.out.println(s);
    }
}