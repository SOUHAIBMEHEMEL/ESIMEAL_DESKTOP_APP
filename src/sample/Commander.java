package sample;

import Classes.*;
import Classes.menu;
import Classes.UtilGerant;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.time.LocalDateTime;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Commander {
    @FXML protected TextField nom;
    @FXML protected TextField prenom;
    @FXML protected TextField numTelephone;
    @FXML protected DatePicker date=new DatePicker();
    @FXML protected DatePicker date1=new DatePicker();
    @FXML protected DatePicker date2=new DatePicker();
    @FXML protected TextField heure;
    @FXML protected TextField minutes;
    @FXML protected TextField nbPersonnes;
    @FXML protected ChoiceBox<String> natureCommande=new ChoiceBox<String>();
    @FXML protected ComboBox<String> type_met=new ComboBox<String>();
    @FXML protected ComboBox<String> type_repas=new ComboBox<String>();
    @FXML protected ComboBox<String> type_boisson=new ComboBox<String>();
    @FXML protected TextField Nom_met;
    @FXML protected TextField Prix_met;
    @FXML protected TextField Nbr_cal;
    @FXML protected TextField Met_disponibilite;
    @FXML protected TextField repas_plus_commande=new TextField();
    @FXML protected TextField codeFidelite;
    @FXML protected AnchorPane parent;
    @FXML protected TextField pswd_Gerant;
    @FXML protected AnchorPane parent_gerant;
    protected client clientDeLaCommande;
    protected Stage fenetreCourante;
    protected InterfaceGerant interfaceGerant1=new InterfaceGerant();
    protected LocalDate date_debut,date_fin;
    @FXML protected Scene scene;
    protected boolean deconnecter=false;
    protected String met_plus_decmd;
    protected String met_moins_decmd;
    protected int prix_commande=0;


    @FXML protected void Ajoutermet(ActionEvent event){
        try{
            //this.typemet();
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Ajoutermet.fxml"));
            Scene scene = new Scene(root,600,400);
            stage.setTitle("Ajouter nouveau mets a votre restaurant");
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

    @FXML public  void visualiser_clients(ActionEvent event ){
        String titre;
        titre="AFFICHAGE DES CLIENTS";
        Stage stage = new Stage();
        stage.setTitle(titre);
        VBox root = new VBox(10);
        root.setAlignment(Pos.TOP_LEFT);
        String entete="NOM DU CLIENT"+"\t\t\t\t\t\t"+"PRENOM DU CLIENT"+"\t\t\t\t\t"+"NUM DE TELEPHONE";
        Label labe22 =new Label(entete);
        root.getChildren().addAll(labe22);
       for (client c: UtilGerant.listeDesClients){
          String nom_cl;
          nom_cl=c.getNom()+"\t\t\t\t\t\t\t\t"+c.getPrenom()+"\t\t\t\t\t\t\t\t"+c.getNumeroTelephone();
           Label label1 =new Label(nom_cl);
           root.getChildren().addAll(label1);
       }
        stage.setScene(new Scene(root,900,500));
        stage.show();
    }
    @FXML public  void visualiser_commandes(ActionEvent event ){
        String titre;
        titre="AFFICHAGE DES COMMANDES";
        Stage stage = new Stage();
        stage.setTitle(titre);
        VBox root = new VBox(10);
        root.setAlignment(Pos.TOP_LEFT);
        String entete="NOM DU CLIENT"+"\t\t\t\t\t"+"PRENOM DU CLIENT"+"\t\t\t\t\t"+"NOMBRE DE PRESONNE"+"\t\t\t\t"+"HEURE DE CONSOM"+"\t\t\t\t\t\t";
        Label labe22 =new Label(entete);
        root.getChildren().addAll(labe22);
        for (commande c: UtilGerant.listeDesCommandesEnAttente){
            String nom_cl;
            client cl=c.getClientAssocie();
            nom_cl=cl.getNom()+"\t\t\t\t\t\t\t\t"+cl.getPrenom()+"\t\t\t\t\t\t\t\t\t"+c.nbr_personne+"\t\t\t\t\t\t\t\t\t"+c.heure_cons+"\t\t\t\t\t";
            Label label1 =new Label(nom_cl);
            root.getChildren().addAll(label1);
        }
        stage.setScene(new Scene(root,1100,500));
        stage.show();

    }

    @FXML public  void Afficher_stat(ActionEvent event ){
        String titre, message1,message2;
        titre="stat";

        Stage stage = new Stage();
        stage.setTitle(titre);
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        Button button = new Button("Ok");
        LocalDate date11,date22;
        date1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                date_debut = date1.getValue();
                System.out.println("Selected date1: " + date1.getValue());
            }
        });

        date2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                date_fin = date2.getValue();
                System.out.println("Selected date2: " + date2.getValue().toString());
            }
        });

        met met1;
        met1=UtilGerant.metLePlusOuMoinsCommande(date_debut,date_fin,true);
        met_plus_decmd=met1.getNom();
        met1=UtilGerant.metLePlusOuMoinsCommande(date_debut,date_fin,false);
        met_moins_decmd=met1.getNom();
        message1=met_plus_decmd;
        message2=met_moins_decmd;
        Label label1 =new Label(message1);
        System.out.println(message1);
        System.out.println(message2);
        Label label2 =new Label(message2);
        button.setOnAction(new javafx.event.EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.close();
            }
        });
        button.setAlignment(Pos.CENTER);
        root.getChildren().addAll(label1,label2,button);
        stage.setScene(new Scene(root,600,500));
        stage.show();

    }

    @FXML public void Modegerant(ActionEvent event){
       if(pswd_Gerant.getText().compareTo("souhaib")==0){
           fenetreCourante = (Stage) parent_gerant.getScene().getWindow();
           try {
               FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceGerantFXml.fxml"));
               Parent root = loader.load();
               fenetreCourante.setScene(new Scene(root,600,600));
           }catch (IOException e){}
           fenetreCourante.show();
       }
    }
/*
    @FXML  public void Afficher_stat(ActionEvent event){
        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Gerant_stat.fxml"));
            Scene scene = new Scene(root,600,400);
            stage.setTitle("STATISTIQUES ENTRE DATE1 ET DATE2");
            stage.setScene(scene);

            stage.show();

        }
        catch (IOException e){}

    }*/

    @FXML  public void Gerantsedeconnecter(ActionEvent event){
            /*fenetreCourante = (Stage) parent_gerant.getScene().getWindow();
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceGerantFXml.fxml"));
                Parent root = loader.load();
                fenetreCourante.setScene(new Scene(root,600,600));
            }catch (IOException e){}
            fenetreCourante.show();*/

    }

   // public void deconnecter(ActionEvent event){}
    @FXML public void initialize() {
        natureCommande.getItems().addAll("À domicile","Sur place","Événement");
        type_met.getItems().addAll("Repas","Boisson");
        type_repas.getItems().addAll("Entree","Plat","Dessert");
        type_boisson.getItems().addAll("Eau Mineral","Boisson gazeuse","Jus","The","Cafe");
    }



    @FXML public void validationAuthentification(ActionEvent event){
        client c ;//= UtilGerant.clientExistant(nom.getText(),prenom.getText(),numTelephone.getText());
        //if(c == null){
            c = new client(nom.getText(),prenom.getText(),numTelephone.getText(),false);
        //}
        clientDeLaCommande = c;
        fenetreCourante = (Stage) parent.getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Commander.fxml"));
            Parent root = loader.load();
            Commander controller =loader.getController();
            controller.clientDeLaCommande= c;
            controller.nom = nom;
            controller.prenom = prenom;
            controller.numTelephone = numTelephone;
            fenetreCourante.setScene(new Scene(root,600,400));
        }catch (IOException e){}
        fenetreCourante.show();
    }
    @FXML public void boutonAnnuler(ActionEvent event){
        fenetreCourante = (Stage) parent.getScene().getWindow();
        fenetreCourante.close();
    }
    static private met metAAjouter;
    @FXML public void boutonSuivant1(ActionEvent event){
        if(type_met.getValue().equals("Repas")){
            ArrayList<String> ingredients=new ArrayList<>();
            ArrayList<supplement> supplements=new ArrayList<>();
            repas r = new repas(Nom_met.getText(),Integer.parseInt(Prix_met.getText()),Integer.parseInt(Nbr_cal.getText()),Integer.parseInt(Met_disponibilite.getText()), ingredients, supplements);
            TitledPane menusupplement = new TitledPane();
            r.setTypeRepas(ERepas.dessert);

            UtilGerant.dictionnaireDesMets.put(r,1);

        }
        if(type_met.getValue().equals("Boisson")){}
    }
    @FXML public void boutonAnnuler1(ActionEvent event){
        if(type_met.getValue().equals("Repas")){
            TitledPane menusupplement = new TitledPane();
        }
        if(type_met.getValue().equals("Boisson")){}
    }
    @FXML public void boutonSuivant(ActionEvent event){
        boolean v = false;
        if(!((Utilitaire.isInteger(heure.getText()))&& (Integer.parseInt(heure.getText())<24)&&(Integer.parseInt(heure.getText())>0)&&(Utilitaire.isInteger(minutes.getText()))&&(Integer.parseInt(minutes.getText())>0)&&(Integer.parseInt(minutes.getText())<60))){
            Utilitaire.messageBox("attention","Attention, veuillez entrer une heure valide");
        }else{
            if((clientDeLaCommande.getClass() == client_fidele.class)&&(!((client_fidele)clientDeLaCommande).getCodeFidelite().equals(codeFidelite.getText()))&&(!((client_fidele)clientDeLaCommande).getCodeFidelite().equals(""))){
                Utilitaire.messageBox("Attention","Code de fidélité incorrect");
            }else{
                if(natureCommande.getSelectionModel().isEmpty()){Utilitaire.messageBox("Attention","Veuillez choisir la nature de la commande");}
                else{
                    VBox parent = new VBox();
                    parent.setAlignment(Pos.CENTER);
                    Stage lastFenetre = new Stage();
                    if(natureCommande.getValue().equals("À domicile")){
                        HBox hboxZoneEntreeAdresse = new HBox(20);
                        parent.getChildren().add(hboxZoneEntreeAdresse);
                        TextField zoneEntreeAdresse = new TextField();
                        Label labelEntreeAdresse = new Label("Adresse");
                        hboxZoneEntreeAdresse.getChildren().addAll(labelEntreeAdresse,zoneEntreeAdresse);
                        if(clientDeLaCommande.getClass().equals(client_fidele.class)){
                            Button boutonAjouterNouvelleAdresse =  new Button("Enregistrer");
                            hboxZoneEntreeAdresse.getChildren().add(boutonAjouterNouvelleAdresse);
                            ComboBox<String> adresses = new ComboBox<String>();
                            adresses.getItems().addAll(((client_fidele)clientDeLaCommande).getListeAdresses());
                            parent.getChildren().addAll(adresses);
                        }
                    }
                    else if(natureCommande.getValue().equals("Sur place")){
                        HBox hboxTables = new HBox(20);
                        Label typeTableLabel = new Label("Type de table");
                        ComboBox<String> comboBoxTypesTable = new ComboBox<String>();
                        comboBoxTypesTable.getItems().addAll(Table.dictionnaireTables.keySet());
                        hboxTables.getChildren().addAll(typeTableLabel,comboBoxTypesTable);
                        parent.getChildren().add(hboxTables);
                    }
                    else if(natureCommande.getValue().equals("Événement")){
                        HBox hboxTypeEvent = new HBox(20);
                        Label labelTypeEvent = new Label("Type d'événement");
                        ComboBox<String> comboBoxTypeEvent = new ComboBox<String>();
                        comboBoxTypeEvent.getItems().addAll(Utilitaire.typesEvents());
                        parent.getChildren().add(hboxTypeEvent);
                    }
                    try{
                        Accordion accordeon = new Accordion();

                        for(int i = 0;i<Integer.parseInt(nbPersonnes.getText());i++){
                            TitledPane menuIeme = new TitledPane();
                            menuIeme.setText("Menu numero "+i);
                            menuIeme.setExpanded(false);
                            accordeon.getPanes().add(menuIeme);
                            VBox vboxInterne = new VBox(5);
                            vboxInterne.setAlignment(Pos.TOP_CENTER);
                            TableView menuTableView = new TableView();
                            vboxInterne.getChildren().add(menuTableView);
                            menuIeme.setContent(vboxInterne);

                            TableColumn colonneNom = new TableColumn("Nom");
                            colonneNom.setCellValueFactory(new PropertyValueFactory<met,String>("nom"));
                            TableColumn colonneCalories = new TableColumn("Calories");
                            colonneCalories.setCellValueFactory(new PropertyValueFactory<met,String>("nbCalories"));
                            TableColumn colonneDisponibilite = new TableColumn("Disponibilité");
                            colonneDisponibilite.setCellValueFactory(new PropertyValueFactory<met,String>("disponibilite"));
                            TableColumn colonnePrix = new TableColumn("Prix");
                            colonnePrix.setCellValueFactory(new PropertyValueFactory<met,String>("prix"));
                            menuTableView.getColumns().addAll(colonneNom,colonnePrix,colonneDisponibilite,colonneCalories);
                            ObservableList<met> metsCommandes = FXCollections.observableArrayList();
                            menuTableView.setItems(metsCommandes);
                            parent.getChildren().add(menuIeme);
                            HBox barreBoutonsDuBas = new HBox(15);
                            barreBoutonsDuBas.setAlignment(Pos.CENTER_RIGHT);
                            Button boutonAjouterMet = new Button("Ajouter");
                            Button boutonSupprimer = new Button("Supprimer");
                            barreBoutonsDuBas.getChildren().addAll(boutonAjouterMet,boutonSupprimer);
                            vboxInterne.getChildren().add(barreBoutonsDuBas);

                            boutonAjouterMet.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent actionEvent) {
                                    Stage fenetreDAjout = new Stage();
                                    VBox premierNiveau = new VBox(5);

                                    ComboBox choixTypeMet = new ComboBox();
                                    choixTypeMet.getItems().addAll("Repas","Boisson");

                                    VBox deuxiemeNiveau = new VBox(3);
                                    premierNiveau.getChildren().addAll(choixTypeMet,deuxiemeNiveau);

                                    choixTypeMet.setOnAction(new EventHandler<ActionEvent>() {
                                        @Override
                                        public void handle(ActionEvent actionEvent) {
                                            String choix =(String) choixTypeMet.getSelectionModel().getSelectedItem();
                                            deuxiemeNiveau.getChildren().clear();
                                            if(choix.equals("Repas")){
                                                metAAjouter = new repas();
                                                ComboBox choixTypeRepas = new ComboBox();
                                                for(String s :Utilitaire.typesRepas())choixTypeRepas.getItems().add(s);
                                                VBox troisiemeNiveau = new VBox(5);
                                                deuxiemeNiveau.getChildren().addAll(choixTypeRepas,troisiemeNiveau);
                                                choixTypeRepas.setOnAction(new EventHandler<ActionEvent>() {
                                                    @Override
                                                    public void handle(ActionEvent actionEvent) {
                                                        troisiemeNiveau.getChildren().clear();
                                                        ComboBox choixRepas = new ComboBox();
                                                        ComboBox choixSupplements = new ComboBox();
                                                        Button ajouterSupplement = new Button("Ajouter");
                                                        VBox vboxSupplementsAjoutes = new VBox(4);



                                                        for(String s:Utilitaire.recupererNomsRepas((String)choixTypeRepas.getSelectionModel().getSelectedItem()))choixRepas.getItems().add(s);

                                                        HBox hboxSupplements = new HBox(20);
                                                        hboxSupplements.getChildren().addAll(choixSupplements,ajouterSupplement);
                                                        choixRepas.setOnAction(new EventHandler<ActionEvent>() {
                                                            @Override
                                                            public void handle(ActionEvent actionEvent) {
                                                                choixSupplements.getItems().clear();
                                                                vboxSupplementsAjoutes.getChildren().clear();
                                                                //String ess=(String)choixRepas.getSelectionModel().getSelectedItem();System.out.println(ess);
                                                                repas repasChoisi =(repas) met.dictionnaireMetsParNom.get((String) choixRepas.getSelectionModel().getSelectedItem());
                                                                metAAjouter = repasChoisi;
                                                                System.out.println(repasChoisi.getNom());
                                                               // for(String s : repasChoisi.getSupplementsNoms()){ choixSupplements.getItems().add(s);}
                                                            }
                                                        });
                                                        choixSupplements.setOnAction(new EventHandler<ActionEvent>() {
                                                            @Override
                                                            public void handle(ActionEvent actionEvent) {
                                                                Label labelSupplementAjoute = new Label((String)choixSupplements.getSelectionModel().getSelectedItem());
                                                                vboxSupplementsAjoutes.getChildren().add(labelSupplementAjoute);
                                                                //((repas)metAAjouter).getSupplements().add( met.dictionnaireMetsParNom.get((String)choixSupplements.getSelectionModel().getSelectedItem()));

                                                            }
                                                        });

                                                        Label supplementsChoisisTitre = new Label("Supplements choisis");
                                                        troisiemeNiveau.getChildren().addAll(choixRepas,hboxSupplements,supplementsChoisisTitre,vboxSupplementsAjoutes);

                                                        }
                                                });
                                            }
                                            else if(choix.equals("Boisson")){
                                                metAAjouter = new boisson();
                                                ComboBox choixDeBoisson = new ComboBox();

                                                for(String s : Utilitaire.typesBoissons())choixDeBoisson.getItems().add(s);
                                                deuxiemeNiveau.getChildren().add(choixDeBoisson);
                                                choixDeBoisson.setOnAction(new EventHandler<ActionEvent>() {
                                                    @Override
                                                    public void handle(ActionEvent actionEvent) {
                                                        metAAjouter = met.dictionnaireMetsParNom.get(((String)choixDeBoisson.getSelectionModel().getSelectedItem()));
                                                    }
                                                });
                                            }
                                        }
                                    });
                                    Button boutonValiderAjoutMet = new Button("Valider");
                                    Button boutonAnnulerAjoutMet = new Button("Annuler");
                                    HBox hbAjoutAnnul = new HBox(20);
                                    hbAjoutAnnul.getChildren().addAll(boutonValiderAjoutMet,boutonAnnulerAjoutMet);

                                    boutonValiderAjoutMet.setOnAction(new EventHandler<ActionEvent>() {
                                        @Override
                                        public void handle(ActionEvent actionEvent) {
                                            System.out.println(metAAjouter.getNom()+"\n"+metAAjouter.getClass()+"\n"+metAAjouter.getPrix());
                                            metsCommandes.add(metAAjouter);
                                            prix_commande+=metAAjouter.getPrix();

                                        }
                                    });
                                    boutonAnnulerAjoutMet.setOnAction(new EventHandler<ActionEvent>() {
                                        @Override
                                        public void handle(ActionEvent actionEvent) {
                                            metAAjouter = null;
                                            fenetreDAjout.close();
                                        }
                                    });

                                    premierNiveau.getChildren().add(hbAjoutAnnul);

                                    fenetreDAjout.setScene(new Scene(premierNiveau,400,500));
                                    fenetreDAjout.show();

                                }
                            });
                            boutonSupprimer.setOnAction((event2)->{
                               // public void handle(ActionEvent actionEvent){

                               // }
                            });
                        }

                        Button boutonAnnulerAjoutMenus = new Button("Annuler");
                        boutonAnnulerAjoutMenus.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                fenetreCourante.close();
                            }
                        });
                        parent.getChildren().add(boutonAnnulerAjoutMenus);

                        lastFenetre.setScene(new Scene(parent,500,600));
                        lastFenetre.show();
                    }catch (NumberFormatException e){
                        Utilitaire.messageBox("Attention","Veuillez vérifier le format des données entrées");
                    }
                }
            }
        }

        //public void construire_cmd(){
           LocalDate date3=date.getValue();
           commande cmd11=new commande(clientDeLaCommande,Integer.parseInt(nbPersonnes.getText()),date3.atTime(Integer.parseInt(heure.getText()),Integer.parseInt(minutes.getText())));
           cmd11.prix_facture=prix_commande;
           String aaaa= cmd11.getClientAssocie().getNom();
           System.out.println(aaaa);
           UtilGerant.listeDesCommandesEnAttente.add(cmd11);//}
           ArrayList<commande> cmd_date;
           cmd_date=UtilGerant.dictionnaireCommandesParDate.get(date3);
           if(cmd_date==null) cmd_date=new ArrayList<>();
           cmd_date.add(cmd11);
           UtilGerant.dictionnaireCommandesParDate.put(date3,cmd_date);
           UtilGerant.listeDesClients.add(clientDeLaCommande);

    }



}
