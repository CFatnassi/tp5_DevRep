package métier;

import java.io.Serializable;
import java.util.Date;

public class Compte implements Serializable{

	private int code;
	private double solde;
	private Date dateCreation;
	
	public int getCode() {
		return code;
	}
	
	public double getSolde() {
		return solde;
	}
	
	public Date getDateCreation() {
		return dateCreation;
	}
	
	public Compte(int code, double solde, Date dateCreation) {
		this.code = code;
		this.solde = solde;
		this.dateCreation = dateCreation;
	}
	
}
