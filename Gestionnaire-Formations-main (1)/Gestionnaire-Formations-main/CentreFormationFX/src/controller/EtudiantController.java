package controller;

import gestionPersonnes.Etudiant;
import gestionPersonnes.AgeInvalideException;
import gestionPersonnes.PersonneDejaExistanteException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import service.GestionEtudiantsService;

public class EtudiantController {

    private GestionEtudiantsService etudiantService = GestionEtudiantsService.getInstance();

    @FXML private TextField idField;
    @FXML private TextField nomField;
    @FXML private TextField ageField;
    @FXML private TextField niveauField;

    // Ajouter
    @FXML
    private void ajouterEtudiant() {
        try {
            Etudiant e = new Etudiant(
                    idField.getText(),
                    nomField.getText(),
                    Integer.parseInt(ageField.getText()),
                    niveauField.getText()
            );
            etudiantService.ajouterEtudiant(e);
            showInfo("Étudiant ajouté !");
        } catch (PersonneDejaExistanteException | AgeInvalideException ex) {
            showError(ex.getMessage());
        } catch (Exception ex) {
            showError("Erreur de saisie");
        }
    }

    // Supprimer
    @FXML
    private void supprimerEtudiant() {
        try {
            etudiantService.supprimerEtudiant(idField.getText());
            showInfo("Étudiant supprimé !");
        } catch (Exception ex) {
            showError(ex.getMessage());
        }
    }

    // Modifier
    @FXML
    private void modifierEtudiant() {
        try {
            etudiantService.modifierEtudiant(
                    idField.getText(),
                    nomField.getText(),
                    Integer.parseInt(ageField.getText()),
                    niveauField.getText()
            );
            showInfo("Étudiant modifié !");
        } catch (Exception ex) {
            showError(ex.getMessage());
        }
    }

    private void showInfo(String msg) {
        new Alert(Alert.AlertType.INFORMATION, msg).show();
    }

    private void showError(String msg) {
        new Alert(Alert.AlertType.ERROR, msg).show();
    }
}
