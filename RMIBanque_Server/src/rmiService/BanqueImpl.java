package rmiService;

import java.sql.Date;

import métier.Compte;

public class BanqueImpl implements IBanque{

	public String creerCompte(Compte c) {
		c = new Compte(123,200.00, new Date(12, 12, 2020));
		return c.toString();
	}
	public String getInfoCompte(int code) {

        return "Compte " + code + ": Solde = 1000€";
	
	}
}
