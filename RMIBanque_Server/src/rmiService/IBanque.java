package rmiService;

import métier.Compte;

public interface IBanque {

	String creerCompte(Compte c);
	String getInfoCompte(int code);

}
