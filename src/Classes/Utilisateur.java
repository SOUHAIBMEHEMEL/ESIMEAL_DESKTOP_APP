package Classes;


import java.util.HashMap;

public abstract class Utilisateur {
    protected String nom;
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    protected String prenom;
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getPrenom() {
        return prenom;
    }

    public Utilisateur(){}
    public Utilisateur(String nom,String prenom){
        this.nom = nom;
        this.prenom = prenom;
    }

    public static String crypt(String chaine){return "";}
    public static String deCrypt(String chaine){return "";}
    public static HashMap<String,String> recupDictionnaireUsers(){return null;}

    public boolean loginAccorde(String nomUser,String password){
        HashMap<String,String> dico = recupDictionnaireUsers();
        if(dico.keySet().contains(nomUser)){
            return dico.get(nomUser).equals(crypt(password));
        }return false;
    }
}
