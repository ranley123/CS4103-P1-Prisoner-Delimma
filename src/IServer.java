import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServer extends Remote{
    String hello(String message) throws RemoteException;
}
