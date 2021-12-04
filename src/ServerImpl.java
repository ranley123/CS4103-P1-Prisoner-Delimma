import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl extends UnicastRemoteObject implements IServer {
    String P2Choice = "C";
    String P1Choice;

    public ServerImpl() throws RemoteException {

    }

    @Override
    public String processChoice(String choice) throws RemoteException {
        P1Choice = choice;

        if(P1Choice.equals("C") && P2Choice.equals("C")){
            return "reduce 5 years";
        }
        else if(P1Choice.equals("C") && P2Choice.equals("B")){
            return "reduce 2 years";
        }
        else if(P1Choice.equals("B") && P2Choice.equals("C")){
            return "reduce 3 years";
        }
        else{
            return "reduce 1 year";
        }
    }


}
