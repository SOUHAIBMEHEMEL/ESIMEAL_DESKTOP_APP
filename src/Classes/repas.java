package Classes;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class repas extends met {
	private ArrayList <String> ingredient ;
	public ArrayList <supplement> liste_supplement ;
	private ERepas typeRepas;

	public ArrayList<String> getIngredients() {
		return this.ingredient;
	}
	public void setIngredients(ArrayList<String> ingredients) {
		this.ingredient = ingredients;
	}

	public void setSupplements(ArrayList<supplement> supplements) {
		this.liste_supplement = supplements;
	}
	public ArrayList<supplement> getSupplements() {
		return this.liste_supplement;
	}

	public ERepas getTypeRepas() {
		return typeRepas;
	}
	public void setTypeRepas(ERepas typeRepas) {
		this.typeRepas = typeRepas;
	}

	public Set<String> getSupplementsNoms(){
		Set<String> set = new HashSet<String>();
		try {
			for (supplement s : this.liste_supplement) {
				set.add(s.nom);
			}
		}catch (Exception e){}
		return set;
	}

	public long prix_met() {
		int pr=this.prix;
		for(supplement l: liste_supplement){
			pr+=l.prix;
		}
		this.prix+=pr;
		return this.prix;
	}

	public repas(){
		ingredient=new ArrayList<String>();
		liste_supplement=new ArrayList<supplement>();
	}
	/*public repas(String nom,int prix,int disp,int nbCal,ArrayList<String> ingredients,ArrayList<supplement> supplements){
		this.nom = nom;
		this.prix = prix;
		this.disponibilite = disp;
		this.nbCalories = nbCal;
		this.ingredient = ingredients;
		this.liste_supplement= supplements;
	}*/
	public repas(String nom,int prix,int disp,int nbCal,ArrayList<String> ingredients,ArrayList<supplement> supplements){
		this.nom = nom;
		this.prix = prix;
		this.disponibilite = disp;
		this.nbCalories = nbCal;
		this.ingredient = ingredients;
		this.liste_supplement =supplements;
	}
}
