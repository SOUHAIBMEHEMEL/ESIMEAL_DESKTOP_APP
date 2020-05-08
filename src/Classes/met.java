package Classes;

import java.util.HashMap;

public abstract class met {
    public static HashMap<String,met> dictionnaireMetsParNom;

    protected String nom;
    protected int prix;
    protected int nbCalories;
    protected int disponibilite;

    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getNom() {
        return this.nom;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
    public int getPrix() {
        return prix;
    }


    public int getNbCalories() {
        return nbCalories;
    }
    public void setNbCalories(int nbCalories) {
        this.nbCalories = nbCalories;
    }


    public int getDisponibilite() {
        return disponibilite;
    }
    public void setDisponibilite(int disponibilite) {
        this.disponibilite = disponibilite;
    }
    public met(){}
}

