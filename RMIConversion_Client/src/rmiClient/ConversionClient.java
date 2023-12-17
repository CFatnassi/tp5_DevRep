package rmiClient;

import java.rmi.Naming;

import rmiService.IConversion;

public class ConversionClient {

	public static void main(String[] args) {
        try {
            // Récupérer le service distant du registre RMI
            IConversion conversionService = 
            		(IConversion) Naming.lookup("//localhost/ConversionService");

            // Utiliser le service distant
            double montantOrigin = 100.0;
            double montantConverti = conversionService.convertirMontant(montantOrigin);

            // Afficher le résultat
            System.out.println
            (montantOrigin + " dollars équivalent à " + montantConverti + " euros.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
