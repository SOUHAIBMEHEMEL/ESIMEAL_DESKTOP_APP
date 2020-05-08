package Classes;

public enum ETypeEvenement {
    anniversaire("Anniversaire"),obtentionDiplome("Diner d'obtention du diplôme"),dinerMariage("Diner de mariage"),dinerDepartRetraite("Diner de départ à la retraite");
    private String nom;
    ETypeEvenement(String n){
        nom = n;
    }

}
