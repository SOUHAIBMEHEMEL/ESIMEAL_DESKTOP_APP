package sample;

import Classes.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.*;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("ESI Meal");
        primaryStage.setScene(new Scene(root, 670, 320));
        primaryStage.show();

        UtilGerant.listeDesClients = new ArrayList<client>();
        UtilGerant.dictionnaireCommandesParDate = new TreeMap<LocalDate, ArrayList<commande>>();
        UtilGerant.dictionnaireDesMets = new HashMap<met, Integer>();
        UtilGerant.listeDesCommandesEnAttente=new ArrayList<commande>();
        Table.dictionnaireTables = new TreeMap<String,Table>();
        met.dictionnaireMetsParNom = new HashMap<String,met>();

        //client c1=new client("Aziz", "Aziz","00",)
        ArrayList<String> ingredients=new ArrayList<>();
        ArrayList<supplement> supplements=new ArrayList<>();
        supplement s1 = new supplement("Concombres",50,30,true);
        supplement s2 = new supplement("poivron",40,50,true);

        supplements.add(s1);
        supplements.add(s2);
        ingredients.add("Laitue");
        ingredients.add("tomate");
        ingredients.add("oignon");
        ingredients.add("feta");
        ingredients.add("huile");
        ingredients.add("olives");
        repas r1 = new repas("Salade",800,5,510,ingredients,supplements);
        r1.setTypeRepas(ERepas.entree);
        UtilGerant.dictionnaireDesMets.put(r1,1);
        met.dictionnaireMetsParNom.put("Salade",r1);


        ingredients.clear();
        supplements.clear();
        s1 = new supplement("Champignons",90,190,true);
        s2 = new supplement("poulet",100,180,true);
        supplement s3 = new supplement("anchois",85,160,true);

        supplements.add(s1);
        supplements.add(s2);
        supplements.add(s3);
        ingredients.add("Pate feuillete");
        ingredients.add("oeufs");
        ingredients.add("fromage rape");
        r1 = new repas("Quiche",150,4,540,ingredients,supplements);
        r1.setTypeRepas(ERepas.entree);
        UtilGerant.dictionnaireDesMets.put(r1,2);
        met.dictionnaireMetsParNom.put("Quiche",r1);


        ingredients.clear();
        supplements.clear();
        s1 = new supplement("Naves",35,20,true);
        s2 = new supplement("Courgettes",45,25,true);

        supplements.add(s1);
        supplements.add(s2);
        ingredients.add("Couscous");
        ingredients.add("tomate");
        ingredients.add("boueuf");
        ingredients.add("haricots vert");
        ingredients.add("carotte");
        r1 = new repas("Couscous",2200,4,800,ingredients,supplements);
        r1.setTypeRepas(ERepas.plat);
        UtilGerant.dictionnaireDesMets.put(r1,3);
        met.dictionnaireMetsParNom.put("Couscous",r1);


        ingredients.clear();
        supplements.clear();
        s1 = new supplement("Gruyere",60,140,true);
        s2 = new supplement("Olives",50,120,true);
        s3 = new supplement("thon",80,150,true);
        supplement s4 = new supplement("champignons",90,190,true);

        supplements.add(s1);
        supplements.add(s2);
        supplements.add(s3);
        supplements.add(s4);
        ingredients.add("Pate a pizza");
        ingredients.add("tomate");
        ingredients.add("parmesan");
        ingredients.add("basilic");
        r1 = new repas("Pizza",700,3,570,ingredients,supplements);
        r1.setTypeRepas(ERepas.plat);
        UtilGerant.dictionnaireDesMets.put(r1,4);
        met.dictionnaireMetsParNom.put("Pizza",r1);



        ingredients.clear();
        supplements.clear();

        ingredients.add("Oeufs");
        ingredients.add("caramel");
        ingredients.add("vanille");
        ingredients.add("sucre");
        r1 = new repas("Creme brulee",700,2,900,ingredients,supplements);
        r1.setTypeRepas(ERepas.dessert);
        UtilGerant.dictionnaireDesMets.put(r1,5);
        met.dictionnaireMetsParNom.put("Creme brulee",r1);


        ingredients.clear();
        supplements.clear();

        ingredients.add("Amandes");
        ingredients.add("sucre");
        ingredients.add("zeste de citron");
        ingredients.add("oeufs");
        r1 = new repas("Makrout El Louz",200,4,500,ingredients,supplements);
        r1.setTypeRepas(ERepas.dessert);
        UtilGerant.dictionnaireDesMets.put(r1,6);
        met.dictionnaireMetsParNom.put("Makrout El Louz",r1);

        boisson b1 = new boisson("Boisson gazeuze",120,5,400);
        b1.setMarque("Hamoude Boualem");
        b1.setGout("Orange");
        b1.setTypeBoisson(EBoissons.boissonGazeuze);
        UtilGerant.dictionnaireDesMets.put(b1,7);
        met.dictionnaireMetsParNom.put("Boisson gazeuze",b1);

        b1 = new boisson("Eau minérale",50,4,0);
        b1.setMarque("Ifri");
        b1.setGout(" ");
        b1.setTypeBoisson(EBoissons.eauMinerale);
        UtilGerant.dictionnaireDesMets.put(b1,8);
        met.dictionnaireMetsParNom.put("Eau minérale",b1);

        /*repas r2 = new repas("batata2",10,10,10,ingredients,supplements);
        boisson b1 = new boisson("Jus",10,10,10);

        r2.setTypeRepas(ERepas.dessert);


        UtilGerant.dictionnaireDesMets.put(r1,2);
        UtilGerant.dictionnaireDesMets.put(r2,1);

        met.dictionnaireMetsParNom.put("batata1",r1);
        met.dictionnaireMetsParNom.put("batata2",r2);
        met.dictionnaireMetsParNom.put("Jus",b1);

        System.out.println((r1.getNom()));
        for(String s : r1.getSupplementsNoms()) System.out.println(s);*/




    }




    public static void main(String[] args) {
        launch(args);
    }
}
