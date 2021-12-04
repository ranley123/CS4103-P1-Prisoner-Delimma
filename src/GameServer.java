import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class GameServer {

    public static void main(String[] args) {
        try {
            IServer hello = new ServerImpl();
            LocateRegistry.createRegistry(8888);

            Naming.bind("rmi://localhost:8888/server", hello);

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
