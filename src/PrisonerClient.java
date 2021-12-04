import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class PrisonerClient {

    public static void main(String[] args){
        try{
            IServer rhello = (IServer) Naming.lookup("rmi://localhost:8888/RHello");
            System.out.println(rhello.helloWord());
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
