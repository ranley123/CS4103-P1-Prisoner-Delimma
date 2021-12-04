import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientImpl implements IClient {

    @Override
    public String hello(String message) throws RemoteException {
        return "hello server";
    }

    public static void main(String[] args) {

        try {

            Registry registry = LocateRegistry.getRegistry(8081);
            IServer stub = (IServer) registry.lookup("Hello");

            String response = stub.hello("hello server");
            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
