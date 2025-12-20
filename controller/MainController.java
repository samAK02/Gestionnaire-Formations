package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class MainController {

    @FXML
    private BorderPane rootPane; // lien avec le BorderPane du FXML

    @FXML
    private Button btnEtudiants, btnFormateurs, btnFormations, btnInscriptions, btnAffichage, btnQuitter;

    @FXML
    public void initialize() {
        // Actions des boutons
        btnEtudiants.setOnAction(e -> setCenterLabel("Écran Gestion Étudiants"));
        btnFormateurs.setOnAction(e -> setCenterLabel("Écran Gestion Formateurs"));
        btnFormations.setOnAction(e -> setCenterLabel("Écran Gestion Formations"));
        btnInscriptions.setOnAction(e -> setCenterLabel("Écran Inscriptions"));
        btnAffichage.setOnAction(e -> setCenterLabel("Écran Affichage"));
        btnQuitter.setOnAction(e -> System.exit(0));
    }

    private void setCenterLabel(String text) {
        Label label = new Label(text);
        label.setStyle("-fx-font-size: 18px; -fx-padding: 20px;");
        rootPane.setCenter(label);
    }
}
