import java.rmi.*;

public interface ServerInterface extends Remote{
    public String getName() throws RemoteException;
    public void send(String msg) throws RemoteException;
    public void setClient(ServerInterface c)throws RemoteException;
    public ServerInterface getClient() throws RemoteException;
}