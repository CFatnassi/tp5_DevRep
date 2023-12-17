package rmiServer;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import métier.Compte;
import rmiService.BanqueImpl;
import rmiService.IBanque;

public class BanqueServer {

	public static void main(String[] args) {

		try {
            // Créer une instance de BanqueImpl
            IBanque banqueService = new BanqueImpl();

            // Exporter l'objet pour qu'il puisse être appelé à distance
            IBanque stub = (IBanque) UnicastRemoteObject.exportObject((Remote) banqueService, 0);

            // Démarrer le registre RMI sur le port 1099
            LocateRegistry.createRegistry(1099);

            // Enregistrer le service dans le registre RMI
            Naming.rebind("//localhost/BanqueService", (Remote) stub);

            System.out.println("Serveur RMI prêt.");

            // Exemple d'utilisation local du service
            Compte compte = new Compte(123, 200.00, new java.util.Date());
            String creerCompteResult = banqueService.creerCompte(compte);
            System.out.println("Résultat de la création du compte : " + creerCompteResult);

            int codeCompte = 123;
            String getInfoCompteResult = banqueService.getInfoCompte(codeCompte);
            System.out.println("Résultat de l'obtention des informations du compte : " + getInfoCompteResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
