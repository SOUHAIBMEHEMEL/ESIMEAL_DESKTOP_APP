package Classes;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Table {
    public String nom;
    public int nbPlacesEnUneTable;
    public int nbTablesExistantes;

    public static TreeMap<String,Table> dictionnaireTables;
    public Table(){}
    public Table(String nom, int nbPlaces,int nbTablesExistantes){
        this.nom = nom;
        this.nbPlacesEnUneTable = nbPlaces;
        this.nbTablesExistantes = nbTablesExistantes;
        try{
            dictionnaireTables.put(this.nom,this);
        }catch (Exception e){
            dictionnaireTables = new TreeMap<String,Table>();
            dictionnaireTables.put(this.nom,this);
        }
    }
}
