package controller;

import gestionPersonnes.Formateur;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import service.GestionFormateursService;

public class FormateurController {

    private GestionFormateursService service = GestionFormateursService.getInstance();

    @FXML private TextField idField;
    @FXML private TextField nomField;
    @FXML private TextField ageField;
    @FXML private TextField specialiteField;

    @FXML
    private void ajouterFormateur() {
        try {
            Formateur f = new Formateur(
                    idField.getText(),
                    nomField.getText(),
                    Integer.parseInt(ageField.getText()),
                    specialiteField.getText()
            );
            service.ajouterFormateur(f);
            showInfo("Formateur ajouté !");
        } catch (Exception ex) {
            showError(ex.getMessage());
        }
    }

    private void showInfo(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, msg);
        alert.show();
    }

    private void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR, msg);
        alert.show();
    }
}
