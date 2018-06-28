import java.rmi.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;
import java.util.*;

import static java.rmi.registry.Registry.REGISTRY_PORT;

public class MainClient {
    public static void main (String[] argv) {
        try {
            System.setSecurityManager(new SecurityManager());
            Scanner s=new Scanner(System.in);
            System.out.println("Enter Your name and press Enter:");
            String name=s.nextLine().trim();
            ServerInterface client = new Server(name);
            //    System.setProperty("java.rmi.server.hostname","rmi://localhost/ABC");
            Registry registry = LocateRegistry.getRegistry(2121);
            ServerInterface server = (ServerInterface) registry.lookup("rmi://localhost/ABC");

            // (ChatInterface)Registry.lookup("rmi://localhost/ABC");
            String msg="["+client.getName()+"] got connected";
            server.send(msg);
            System.out.println("[System] Chat Remote Object is ready:");
            server.setClient(client);

            while(true){
                msg=s.nextLine().trim();
                msg="["+client.getName()+"] "+msg;
                server.send(msg);
            }

        }catch (Exception e) {
            System.out.println("[System] Server failed: " + e);
        }
    }
}