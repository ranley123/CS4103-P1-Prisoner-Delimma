import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class PrisonerClient {
    static int num;


    public static void main(String[] args){
        if(args.length != 1){
            System.out.println("Invalid arguments");
            System.exit(0);
        }

        num = Integer.parseInt(args[0]);

        System.out.println("input C for cooperation, input B for betray");

        try{
            IServer serverStub = (IServer) Naming.lookup("rmi://localhost:8888/server");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.next();
            String result = "";

            if(choice.equals("C") || choice.equals("B")){
                result = serverStub.processChoice(num, choice);
            }
            else{
                System.out.println("Invalid Choice");
                System.exit(0);
            }

            while(result.equals("")){
                Thread.sleep(1000);
                result = serverStub.processChoice(num, choice);
            }
            System.out.println(result);

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
