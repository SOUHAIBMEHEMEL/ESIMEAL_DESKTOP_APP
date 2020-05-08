package Classes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;


public class UtilGerant {
    public static TreeMap<LocalDate,ArrayList<commande>> dictionnaireCommandesParDate;
    public static ArrayList<client> listeDesClients;

    public static ArrayList<commande> listeDesCommandesEnAttente;

    public static HashMap<met,Integer> dictionnaireDesMets;
    public static HashMap<met,Integer> getDictionnaireDesMets() {
        return dictionnaireDesMets;
    }
    public static void setDictionnaireDesMets(HashMap<met, Integer> dictionnaireDesMets) {
        UtilGerant.dictionnaireDesMets = dictionnaireDesMets;
    }
    public static void Set_nv_Met(met met1) {
        UtilGerant.dictionnaireDesMets.put(met1,UtilGerant.dictionnaireDesMets.size());
        met1.dictionnaireMetsParNom.put(met1.nom,met1);
    }

    public static boolean validation(commande commande1) throws CommandeNonValideException{

        try{
            if(commande1 == null) throw new CommandeNonValideException();
            else if(commande1.DateDeCommande().plusMinutes(90).isAfter(commande1.DateDeCommande()))throw new CommandeNonValideException();
            else if((commande1.getClass()==cmd_domicile.class) && commande1.DateDeCommande().plusHours(1).isAfter(commande1.DateDeCommande())) throw new CommandeNonValideException();
            else if((commande1.getClass()==cmd_domicile.class) && (commande1.DateDeCommande().getHour()>22))throw new CommandeNonValideException();
            else if((!(commande1.getClass()==cmd_domicile.class))&&(commande1.DateDeCommande().getHour()<8))throw new CommandeNonValideException();
            else if((!(commande1.getClass()==cmd_domicile.class))&&(commande1.distance>20))throw new CommandeNonValideException();
            else if((commande1.getClass()==cmd_restaurant.class)&&(!assezDeChaisesEtDeTables((cmd_restaurant) commande1)))throw new CommandeNonValideException();
            }
        catch(CommandeNonValideException ex){return false;}

        return true;
    }
    public static boolean validation(evenement evenement) throws CommandeNonValideException{
        try {
            if ((evenement.getNbInvites() >= 30) && (evenement.getNbInvites() <= 80)) throw new CommandeNonValideException();
            if (restaurantLibre(evenement.getHeureDeConsommation().toLocalDate())){}
        }catch (CommandeNonValideException ex){return false;}
        return true;

    }

    public static boolean assezDeChaisesEtDeTables(cmd_restaurant commande){
        int nbTablesDispo = nombreDeTablesDisponibles(commande);
        if(commande.getTable().nbPlacesEnUneTable*nbTablesDispo>=commande.getNbPersonnes()) return true;
        else return false;
    }
    public static int nombreDeTablesDisponibles(cmd_restaurant commandeSurPlace){
        String nomTable = commandeSurPlace.getTable().nom;
        int i = 0;
        ArrayList<commande> listeCommandesDeCeMoment = UtilGerant.dictionnaireCommandesParDate.get(commandeSurPlace.getHeureDeConsommation().toLocalDate());
        if(listeCommandesDeCeMoment == null){
            return Table.dictionnaireTables.get(nomTable).nbTablesExistantes;
        }else{
            for(commande c : listeCommandesDeCeMoment){
                if(c.getClass()==cmd_restaurant.class){
                    if(!(c.getHeureDeConsommation().plusHours(2).compareTo(commandeSurPlace.getHeureDeConsommation())<0)&&(c.getHeureDeConsommation().compareTo(commandeSurPlace.getHeureDeConsommation().plusHours(2))>0)){
                        i+=(((cmd_restaurant)c).getNbPersonnes())/((cmd_restaurant)c).getTable().nbPlacesEnUneTable;
                    }
                }
            }
            return Table.dictionnaireTables.get(nomTable).nbTablesExistantes-i;
        }
    }



    public static SortedSet<commande> listeDesCommandes;
    public static SortedSet<commande> getListeDesCommandes() {
        return listeDesCommandes;
    }
    public static void setListeDesCommandes(SortedSet<commande> listeDesCommandes) {
        UtilGerant.listeDesCommandes = listeDesCommandes;
    }

    public static int montantTotalReductions;
    public static int getMontantTotalReductions() {
        return montantTotalReductions;
    }
    public static void setMontantTotalReductions(int montantTotalReductions) {
        UtilGerant.montantTotalReductions = montantTotalReductions;
    }

    public static int nbReductions;

    public static int montantReductionsFidelite;
    public static int getMontantReductionsFidelite() {
        return montantReductionsFidelite;
    }
    public static void setMontantReductionsFidelite(int montantReductionsFidelite) {
        UtilGerant.montantReductionsFidelite = montantReductionsFidelite;
    }

    public static int nbReductionsFidelite;

    public static int montantReductionsEtudiant;
    public static int getMontantReductionsEtudiant() {
        return montantReductionsEtudiant;
    }
    public static void setMontantReductionsEtudiant(int montantReductionsEtudiant) {
        UtilGerant.montantReductionsEtudiant = montantReductionsEtudiant;
    }

    public static int nbReductionsEtudiant;

    public static int montantReductionsGrpDomicile;
    public static int getMontantReductionsGrpDomicile() {
        return montantReductionsGrpDomicile;
    }
    public static void setMontantReductionsGrpDomicile(int montantReductionsGrpDomicile) {
        UtilGerant.montantReductionsGrpDomicile = montantReductionsGrpDomicile;
    }

    public static int nbReductionsGrpDomicile;

    public static int montantReductionsEvenement;
    public static int getMontantReductionsEvenement() {
        return montantReductionsEvenement;
    }
    public static void setMontantReductionsEvenement(int montantReductionsEvenement) {
        UtilGerant.montantReductionsEvenement = montantReductionsEvenement;
    }

    public static int nbReductionsEvenement;


    public static int montantToutesLesCommandesParDate(LocalDate de,LocalDate a){
         int sum = 0;
         ArrayList<commande> liste;
         for(LocalDate date : dictionnaireCommandesParDate.keySet() ){
            if((date.compareTo(de)>0)&&(date.compareTo(a)<0)){
                liste = dictionnaireCommandesParDate.get(date);
                if(liste != null) {
                    for (commande objetCalendrier : liste){
                        //Traitements
                        sum += objetCalendrier.calculPrix();
                    }
                }
            }
         }
         return sum;
    }
    public static int nombreDeToutesLesCommandesParDate(LocalDate de,LocalDate a){
        int sum = 0;
        ArrayList<commande> liste;
        for(LocalDate date : dictionnaireCommandesParDate.keySet() ){
            if((date.compareTo(de)>0)&&(date.compareTo(a)<0)){
                liste = dictionnaireCommandesParDate.get(date);
                if(liste != null) {
                    for (commande objetCalendrier : liste){
                        //Traitements
                        sum ++;
                    }
                }
            }
        }
        return sum;
    }
    public static int montantDeToutesLesCommandesParDateEtParType(LocalDate de,LocalDate a,commande type){
        int sum = 0;
        ArrayList<commande> liste;
        for(LocalDate date : dictionnaireCommandesParDate.keySet() ){
            if((date.compareTo(de)>0)&&(date.compareTo(a)<0)){
                liste = dictionnaireCommandesParDate.get(date);
                if(liste != null) {
                    for (commande objetCalendrier : liste){
                        //Traitements
                        if(objetCalendrier.getClass().equals(type.getClass())) sum += objetCalendrier.calculPrix();
                    }
                }
            }
        }
        return sum;
    }
    public static int nombreDeToutesLesCommandesParDateEtParType(LocalDate de,LocalDate a,commande type){
        int sum = 0;
        ArrayList<commande> liste;
        for(LocalDate date : dictionnaireCommandesParDate.keySet() ){
            if((date.compareTo(de)>0)&&(date.compareTo(a)<0)){
                liste = dictionnaireCommandesParDate.get(date);
                if(liste != null) {
                    for (commande objetCalendrier : liste){
                        //Traitements
                        if(objetCalendrier.getClass().equals(type.getClass())) sum ++;
                    }
                }
            }
        }
        return sum;
    }

    public static boolean restaurantLibre(LocalDate date){
        if(dictionnaireCommandesParDate.get(date).isEmpty())return true;
        else {
            for(commande c : dictionnaireCommandesParDate.get(date)){
                if(c.getClass().equals(cmd_restaurant.class))return false;
            }
            return true;
        }
    }

//Partie mets
    public static met metLePlusOuMoinsCommande(LocalDate de,LocalDate s ,boolean lePlus){
        HashMap<met,Integer> map=new HashMap<met, Integer>();
        met metCandidat=new repas();
        LinkedList<met> metsSelectionnes = new LinkedList<met>();
        int valReference = 0;
        ArrayList<menu> panier = new ArrayList<menu>();
        ArrayList<commande> liste;
        for(LocalDate date : dictionnaireCommandesParDate.keySet() ){
            System.out.println(date.toString());
            System.out.println(s.toString());
            if((date.isAfter(s))&&(date.isBefore(de))){
                liste = dictionnaireCommandesParDate.get(date);
                if(liste != null) {
                    for (commande objetCalendrier : liste){
                        //Traitements
                        if(objetCalendrier.getClass()==evenement.class){
                            panier.add(((evenement)objetCalendrier).getMenu());
                        }
                        else{
                            panier = ((commande)objetCalendrier).liste_menu;
                        }
                        for(menu menu : panier) {
                            for (met met1 : menu.getListeDesMets()) {
                                map.putIfAbsent(met1,0);
                                map.put(met1, map.get(met1) + 1);
                            }
                        }
                        if(lePlus){
                            for(met met1 : map.keySet()){
                                if(map.get(met1).intValue()>valReference){
                                    valReference = map.get(met1).intValue();
                                    metCandidat = met1;
                                }
                            }
                            metsSelectionnes.add(metCandidat);
                        }
                        else{
                            metCandidat = map.keySet().iterator().next();
                            valReference = map.get(metCandidat);
                            for(met met1 : map.keySet()){
                                if(map.get(met1)<valReference){
                                    valReference = map.get(met1);
                                    metCandidat = met1;
                                }
                            }
                            metsSelectionnes.add(metCandidat);
                        }
                    }
                    if(lePlus) {
                        for ( met met1: metsSelectionnes) {
                            if(map.get(met1)>valReference){
                                valReference = map.get(met1);
                                metCandidat = met1;
                            }
                        }
                    }else{
                        for ( met met1: metsSelectionnes){
                            if(map.get(met1)<valReference){
                                valReference = map.get(met1);
                                metCandidat = met1;
                            }
                        }
                    }
                }
            }
        }
        return metCandidat;
    }

//Partie statistiques clients









    public static client_fidele codeDeFideliteValide(String src){
        for(client c : listeDesClients){
            if(c instanceof client_fidele){
                if(((client_fidele) c).getCodeFidelite().equals(src))return (client_fidele)c;
            }
        }
        return null;
    }
    public static client clientExistant(String nom, String prenom,String numTel){
        for(client c:listeDesClients){
            if(c.getNom().equals(nom)&&c.getPrenom().equals(prenom)&&c.getNumeroTelephone().equals(numTel))return c;
        }
        return null;
    }
}
