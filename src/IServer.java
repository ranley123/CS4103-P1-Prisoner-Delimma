import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServer extends Remote {

    public String processChoice(int i, String choice) throws RemoteException;
}
