package rmiServer;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;

import rmiService.ConversionImpl;
import rmiService.IConversion;

public class ConversionServer {

	public static void main(String[] args) {
        try {
            // Créer un objet de service
            IConversion conversionService = new ConversionImpl();

            // Démarrer le registre RMI sur le port 1099
            LocateRegistry.createRegistry(1099);

            // Enregistrer le service dans le registre RMI
            Naming.rebind("//localhost/ConversionService", (Remote) conversionService);

            System.out.println("Serveur RMI prêt.");
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
}
