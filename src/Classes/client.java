package Classes;
// import java.util.ArrayList;

public class client {
   private String nom;
   private String prenom;
   private String num_tfn;
   protected boolean etudiant;
   // ArrayList <commande> liste_cmd = new ArrayList <commande>();
public client(String nom, String prenom, String num_tfn, boolean etudiant){
	 this.nom=nom;
	 this.prenom=prenom;
	 this.num_tfn=num_tfn;
	 this.etudiant=etudiant;
} 

public String getNom(){return this.nom;}
public String getPrenom(){return this.prenom;}
public String getNumeroTelephone() { return this.num_tfn; }
/*public void ajouter_commande(int nb_per, String heure){
	 commande cmd =new commande(nb_per, heure);
	 this.liste_cmd.add(cmd);	 
}

public void supprimer_commande(int i){
	 this.liste_cmd.remove(i);	 
}

public void valider_commande(int i){
	 commande cmd=this.liste_cmd.get(i);	
	 // list.valider()
}*/

}
