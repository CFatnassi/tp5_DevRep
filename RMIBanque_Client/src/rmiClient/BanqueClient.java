package rmiClient;

import java.rmi.Naming;

import métier.Compte;
import rmiService.IBanque;

public class BanqueClient {

	public static void main(String[] args) {
        try {
            // Rechercher le service RMI distant en utilisant l'URL du registre RMI
            IBanque banqueService = (IBanque) Naming.lookup("//localhost/BanqueService");

            // Exemple d'utilisation des méthodes à distance
            // Créer un compte
            String creerCompteResult = 
            		banqueService.creerCompte(new Compte(456, 500.0, new java.util.Date()));
            System.out.println("Résultat de la création du compte à distance : " + creerCompteResult);

            // Obtenir des informations sur un compte
            int codeCompte = 456;
            String getInfoCompteResult = banqueService.getInfoCompte(codeCompte);
            System.out.println
            ("Résultat de l'obtention des informations du compte à distance : "+ getInfoCompteResult);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
