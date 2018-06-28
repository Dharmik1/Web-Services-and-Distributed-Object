import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class MainServer {
    public static void main (String[] argv) {
     try {
        //  System.setProperty("java.rmi.server.hostname","127.0.0.0");
        System.setSecurityManager(new SecurityManager());
        Scanner s=new Scanner(System.in);
        System.out.println("Enter Your name and press Enter:");
        String name=s.nextLine().trim();

        Server server = new Server(name);


        Registry registry = LocateRegistry.createRegistry(2121);
        registry.bind("rmi://localhost/ABC", server);
        //Naming.rebind("rmi://localhost/ABC", server);

        System.out.println("[System] Chat Remote Object is ready:");

        while(true){
            String msg=s.nextLine().trim();
            if (server.getClient()!=null){
                ServerInterface client=server.getClient();
                msg="["+server.getName()+"] "+msg;
                client.send(msg);
            }
        }

    }catch (Exception e) {
        System.out.println("[System] Server failed: " + e);
    }
}
}
