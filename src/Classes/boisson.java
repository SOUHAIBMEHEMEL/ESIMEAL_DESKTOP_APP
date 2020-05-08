package Classes;

public class boisson extends met {

    private EBoissons typeBoisson;
    public EBoissons getTypeBoisson() {
        return typeBoisson;
    }
    public void setTypeBoisson(EBoissons typeBoisson) {
        this.typeBoisson = typeBoisson;
    }

    private String marque;
    public String getMarque() {
        return marque;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }

    private String gout;
    public String getGout() {
        return gout;
    }
    public void setGout(String gout) {
        this.gout = gout;
    }

    public boisson(){}
    public boisson(String nom,int prx,int dispo,int nbCal,String mar,String gou,EBoissons typeBoisso ){
        this.nom = nom;
        this.prix = prx;
        this.disponibilite = dispo;
        this.nbCalories = nbCal;
        this.marque = mar;
        this.gout = gou;
        this.typeBoisson = typeBoisso;
    }
    public boisson(String nom,int prx,int dispo,int nbCal){
        this.nom = nom;
        this.prix = prx;
        this.disponibilite = dispo;
        this.nbCalories = nbCal;
        this.marque = "Aucune Marque";
        this.gout = "Aucun gout";
        this.typeBoisson = EBoissons.boissonGazeuze;
    }
}
