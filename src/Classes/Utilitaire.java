package Classes;

//import com.sun.corba.se.impl.logging.POASystemException;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.beans.EventHandler;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Utilitaire {
    public static boolean isInteger(String s) {
        return isInteger(s,10);
    }

    public static boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }
    public static void messageBox(String titre,String message){
        Stage stage = new Stage();
        stage.setTitle(titre);
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        Label label =new Label(message);
        Button button = new Button("Ok");
        button.setOnAction(new javafx.event.EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.close();
            }
        });
        button.setAlignment(Pos.CENTER);
        root.getChildren().addAll(label,button);
        stage.setScene(new Scene(root,300,100));
        stage.show();
        return;
    }
    public static Set<String> typesEvents(){
        Set<String> s = new HashSet<String>();
        for(ETypeEvenement ete: ETypeEvenement.values()){
            s.add(ete.name());
        }
        return s;
    }
    public static Set<String> typesRepas(){
        Set<String> s = new HashSet<String>() ;
        for(ERepas rep : ERepas.values()){
            s.add(rep.nom);
        }
        return s;
    }
    public static Set<String> typesBoissons(){
        Set<String> s = new HashSet<String>() ;
        for(EBoissons rep : EBoissons.values()){
            s.add(rep.nom);
        }
        return s;
    }
    public static Set<repas> recupererRepas(String type){
        Set<repas> ensembleDesRepas = new HashSet<repas>();
        for(met m : met.dictionnaireMetsParNom.values()){
            if(m.getClass()==repas.class){
                if(((repas)m).getTypeRepas().nom.equals(type)) ensembleDesRepas.add((repas) m);
            }
        }
        return  ensembleDesRepas;
    }
    public static Set<String> recupererNomsRepas(String type){
        Set<String> resultat = new HashSet<String>();
        for(repas r : recupererRepas(type)){
            resultat.add(r.nom);
        }
        return resultat;
    }
}
