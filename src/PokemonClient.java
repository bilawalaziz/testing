import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry;  

public class PokemonClient { 
   private PokemonClient() {} 
   public static void main(String[] args) {  
      try { 
         // Getting the registry 
         Registry registry = LocateRegistry.getRegistry(null); 
    
         // Looking up the registry for the remote object 
         RemotePokemon stub = (RemotePokemon) registry.lookup("RemotePokemon"); 
         
         // Calling the remote method using the obtained object 
         stub.animation(); 
         
         System.out.println("Remote method invoked"); 
      } catch (Exception e) {
         System.err.println("Client exception: " + e.toString()); 
         e.printStackTrace(); 
      } 
   } 
}