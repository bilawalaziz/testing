
import java.rmi.Remote; 
import java.rmi.RemoteException;  

// Creating Remote interface for our application 
public interface RemotePokemon extends Remote { 
   void animation() throws RemoteException; 
}