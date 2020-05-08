package sample;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.io.IOException;
import javafx.scene.Scene;

public class Controller {
    @FXML protected Button bt1,btgerant;
    @FXML protected void GerantSeConnecter(ActionEvent event){
        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("ConnecterGerant.fxml"));
            Scene scene = new Scene(root,600,175);
            stage.setTitle("Authentification Gerant");
            stage.setScene(scene);
            stage.show();

        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
    @FXML protected void BoutonCommander(ActionEvent event){
        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("AuthentificationCommande.fxml"));
            Scene scene = new Scene(root,600,500);
            stage.setTitle("Authentification");
            stage.setScene(scene);
            stage.show();

        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
    @FXML protected void BoutonSinscrire(ActionEvent event){
        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Inscription.fxml"));
            Scene scene = new Scene(root,600,400);
            stage.setTitle("S'inscrire");
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
    @FXML protected void BoutonSeConnecter(ActionEvent event){
        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Connecter.fxml"));
            Scene scene = new Scene(root,491,400);
            stage.setTitle("Se Connecter");
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

}
