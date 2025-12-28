package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Node;


public class MainController {

    @FXML
    private BorderPane rootPane; // lien avec le BorderPane du FXML

    @FXML
    private Button btnEtudiants, btnFormateurs, btnFormations, btnInscriptions, btnAffichage, btnQuitter;

    @FXML
    public void initialize() {
        // Actions des boutons
        btnEtudiants.setOnAction(e -> loadView("EtudiantView.fxml"));
        btnFormateurs.setOnAction(e -> loadView("FormateurView.fxml"));
        btnFormations.setOnAction(e -> loadView("FormationView.fxml"));
        btnAffichage.setOnAction(e -> loadView("AffichageView.fxml"));
        btnQuitter.setOnAction(e -> System.exit(0));
    }

    private void setCenterLabel(String text) {
        Label label = new Label(text);
        label.setStyle("-fx-font-size: 18px; -fx-padding: 20px;");
        rootPane.setCenter(label);
    }
    private void loadView(String fxml) {
        try {
            Parent view = FXMLLoader.load(
                    getClass().getResource("/view/" + fxml)
            );
            rootPane.setCenter(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}