package Classes;
import java.util.ArrayList;
import java.time.*;
import java.util.Date;
import java.time.LocalDateTime;

public class commande {
 public int distance;
 public int nbr_personne;
 public LocalDateTime heure_cons;
 public ArrayList <menu> liste_menu;
 public long prix_facture;
 //Double reduction_total=this.reduction_etudiant()+this.reduction_fidelite()+this.reduction_grp_domicile()+this.reduction_evenement();
 client cl;
// int indice_demandeur;

 public client getClientAssocie(){return this.cl;}

	public LocalDateTime getHeureDeConsommation() {
		return heure_cons;
	}
 public int getNbPersonnes(){return this.nbr_personne;}
 public commande(client cl, int nbr_personne, LocalDateTime heure_cons){
	 this.cl=cl;
	 this.nbr_personne=nbr_personne;
	 this.heure_cons=heure_cons;
	 this.liste_menu = new ArrayList <menu>();
 }

 public LocalDateTime DateDeCommande(){return this.heure_cons;}
 /*
 public double reduction_fidelite(){
	 double reduct=0;
	 if (this.cl instanceof client_fidele ){reduct=0.05;}
	 return reduct; 
  }
 
 public double reduction_etudiant(){
	 double reduct=0;
	 if (this.cl.etudiant ){reduct=0.08;}
	 return reduct; 
  }
 
 public double reduction_grp_domicile(){
	 double reduct=0;
	 if ((this instanceof cmd_domicile)&&(this.nbr_personne>3)){reduct=0.07;}
	 return reduct; 
  }
 
 public double reduction_evenement(){
	 double reduct=0;
	 if ((this instanceof evenement)&&(this.nbr_personne>50)){reduct=0.1;}
	 return reduct; 
  }
 
 public long calfact_cmd_sans_red(){
		long pr=0; 
		long prix_menu;
		for(int i=0;i<liste_menu.size();i++) {
			prix_menu=this.liste_menu.get(i).calcul_facture_menu();
			pr+=prix_menu;
		}
		return pr;	 
	 }
 
 public long montant_red_fidelite(){
		long pr=0; 
		long prix_menu;
		for(int i=0;i<liste_menu.size();i++) {
			prix_menu=this.liste_menu.get(i).calcul_facture_menu();
			if(i==this.indice_demandeur){prix_menu-=prix_menu*this.reduction_fidelite();}
			pr+=prix_menu;
		}
		return (this.calfact_cmd_sans_red()-pr);	 
	 }
 
 public long montant_red_etudiant(){
		long pr=0; 
		long prix_menu;
		for(int i=0;i<liste_menu.size();i++) {
			prix_menu=this.liste_menu.get(i).calcul_facture_menu();
			if(i==this.indice_demandeur){prix_menu-=prix_menu*this.reduction_etudiant();}
			pr+=prix_menu;
		}
		return (this.calfact_cmd_sans_red()-pr);	 
	 }

 public long montant_red_grpdomicile(){
		long pr=0; 
		long prix_menu;
		for(int i=0;i<liste_menu.size();i++) {
			prix_menu=this.liste_menu.get(i).calcul_facture_menu();
			if(i==this.indice_demandeur){prix_menu-=prix_menu*this.reduction_grp_domicile();}
			pr+=prix_menu;
		}
		return (this.calfact_cmd_sans_red()-pr);	 
	 }
 
 public long montant_red_evenement(){
		long pr=0; 
		long prix_menu;
		for(int i=0;i<liste_menu.size();i++) {
			prix_menu=this.liste_menu.get(i).calcul_facture_menu();
			if(i==this.indice_demandeur){prix_menu-=prix_menu*this.reduction_evenement();}
			pr+=prix_menu;
		}
		return (this.calfact_cmd_sans_red()-pr);	 
	 }
 /
 public long  calculPrix(){
	long pr=0; 
	long prix_menu;
	for(int i=0;i<liste_menu.size();i++) {
		prix_menu=this.liste_menu.get(i).calcul_facture_menu();
		if(i==this.indice_demandeur){prix_menu-=prix_menu*this.reduction_total;}
		pr+=prix_menu;
	}
	this.prix_facture=pr;
	return this.prix_facture;
	 
 }
 */

	public long  calculPrix(){
		long pr=0;

		this.prix_facture=pr;
		return this.prix_facture;

	}
	public long calfact_cmd_sans_red(){
		long pr=0;
		long prix_menu;
		for(int i=0;i<liste_menu.size();i++) {
			prix_menu=this.liste_menu.get(i).calcul_facture_menu();
			pr+=prix_menu;
		}
		this.prix_facture=pr;
		return this.prix_facture;
	}
 
}
