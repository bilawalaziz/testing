import java.rmi.registry.Registry; 
import java.rmi.registry.LocateRegistry; 
import java.rmi.RemoteException; 
import java.rmi.server.UnicastRemoteObject; 

public class PokemonServer extends Pokemon { 
   public PokemonServer() {} 
   public static void main(String args[]) { 
      try { 
         // Instantiating the implementation class 
         Pokemon obj = new Pokemon();
      
         // Exporting the object of implementation class  
         // (here we are exporting the remote object to the stub) 
         RemotePokemon stub = (RemotePokemon) UnicastRemoteObject.exportObject(obj, 0);  
      
         // Binding the remote object (stub) in the registry 
         Registry registry = LocateRegistry.getRegistry(); 
         
         registry.bind("RemotePokemon", stub);  
         System.err.println("Server ready"); 
      } catch (Exception e) { 
         System.err.println("Server exception: " + e.toString()); 
         e.printStackTrace(); 
      } 
   } 
}