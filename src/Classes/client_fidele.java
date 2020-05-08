package Classes;
import java.util.ArrayList;

public class client_fidele extends client {
	public String code_fidelite;
    public client_fidele(String nom, String prenom, String num_tfn,String code_fidelite,boolean etudiant) {
		super(nom, prenom, num_tfn,etudiant);
		this.code_fidelite=code_fidelite;
		this.liste_adresse.removeAll(liste_adresse);
	}

	private ArrayList<String> liste_adresse;
	public ArrayList<String> getListeAdresses() {
		return this.liste_adresse;
	}
	public void setListeAdresses(ArrayList<String> listeAdresses) {
		this.liste_adresse = listeAdresses;
	}
	public String getCodeFidelite(){return this.code_fidelite;}
}
