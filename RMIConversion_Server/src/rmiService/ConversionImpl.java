package rmiService;

public class ConversionImpl implements IConversion{


	public double convertirMontant(double mt){
        // Supposons un taux de change fixe
        final double tauxDeChange = 0.85;
        // Conversion du montant
        double montantConverti = mt * tauxDeChange;

        return montantConverti;
    }
}


