import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClient extends Remote {
    String hello(String message) throws RemoteException;
}