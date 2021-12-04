import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl implements IServer{
    @Override
    public String hello(String message) throws RemoteException {
        return "hello client";
    }

    public static void main(String args[]) {

        try {
            ServerImpl obj = new ServerImpl();
            IServer stub = (IServer) obj;

            Registry registry = LocateRegistry.createRegistry(1888);
            registry.rebind("Hello", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
