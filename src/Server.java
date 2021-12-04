import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements IServer {

    public Server() throws RemoteException {

    }

    @Override
    public String helloWord() throws RemoteException {
        return "hello world";
    }

    public static void main(String[] args) {
        try {
            IServer hello = new Server();
            LocateRegistry.createRegistry(8888);

            Naming.bind("rmi://localhost:8888/RHello", hello);

            System.out.println("Server Ready");


        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
