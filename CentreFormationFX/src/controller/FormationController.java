package controller;

import gestionPersonnes.Formation;
import gestionPersonnes.FormationPleineException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import service.GestionFormationsService;

public class FormationController {

    private GestionFormationsService service = GestionFormationsService.getInstance();

    @FXML private TextField idField;
    @FXML private TextField intituleField;
    @FXML private TextField capaciteField;
    @FXML private TextField idEtudiantField;

    @FXML
    private void ajouterFormation() {
        try {
            Formation f = new Formation(
                    idField.getText(),
                    intituleField.getText(),
                    Integer.parseInt(capaciteField.getText())
            );
            service.ajouterFormation(f);
            showInfo("Formation ajoutée !");
        } catch (Exception ex) {
            showError(ex.getMessage());
        }
    }

    @FXML
    private void inscrireEtudiant() {
        try {
            service.inscrireEtudiant(idField.getText(), idEtudiantField.getText());
            showInfo("Étudiant inscrit !");
        } catch (FormationPleineException ex) {
            showError(ex.getMessage());
        } catch (Exception ex) {
            showError(ex.getMessage());
        }
    }

    @FXML
    private void desinscrireEtudiant() {
        service.desinscrireEtudiant(idField.getText(), idEtudiantField.getText());
        showInfo("Étudiant désinscrit !");
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
