package Classes;
import java.util.ArrayList;

public class menu {
	private ArrayList <met> menu_personne = new ArrayList <met>();
	public long facture=0;
	public long facture_red=0;
	public ArrayList<met> getListeDesMets() {
		return this.menu_personne;
	}
	public void setListeDesMets(ArrayList<met> listeDesMets) {
		this.menu_personne = listeDesMets;
	}

	public long calcul_facture_menu(){
		long prix_met=0;
		for(int i=0;i<this.menu_personne.size();i++) {
			prix_met+=this.menu_personne.get(i).prix;	
		}
		return prix_met;	
	}

	public int nbCaloriesTotal(){
		int i=0;
		for(met m : this.menu_personne){
			i+= m.getNbCalories();
		}
		return i;
	}
	
}
