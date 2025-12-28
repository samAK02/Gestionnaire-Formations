package controller;

import gestionPersonnes.Formateur;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import service.GestionFormateursService;
import gestionPersonnes.PersonneDejaExistanteException;
import gestionPersonnes.AgeInvalideException;

public class FormateurController {

    //private GestionFormateursService service = GestionFormateursService.getInstance();
    private GestionFormateursService formateurService = GestionFormateursService.getInstance();
    private AffichageController affichageController;
    @FXML private TextField idField;
    @FXML private TextField nomField;
    @FXML private TextField ageField;
    @FXML private TextField specialiteField;

    public void setAffichageController(AffichageController controller) {
        this.affichageController = controller;
    }


    @FXML
    private void ajouterFormateur() {
        try {
            Formateur f = new Formateur(
                    idField.getText(),
                    nomField.getText(),
                    Integer.parseInt(ageField.getText()),
                    specialiteField.getText()
            );
            formateurService.ajouterFormateur(f); // ← ici, exception levée si ID existe
            showInfo("Formateur ajouté !");
        } catch (AgeInvalideException ex) {
            showError(ex.getMessage());
        } catch (PersonneDejaExistanteException ex) {
            showError(ex.getMessage());
        } catch (Exception ex) {
            showError(ex.getMessage());
        }
    }
    @FXML
    private void supprimerFormateur() {
        formateurService.supprimerFormateur(idField.getText());
        refresh();
        showInfo("Formateur supprimé !");
    }
    private void refresh() {
        if (affichageController != null) {
            affichageController.refreshTables();
        }
    }

    @FXML
    private void modifierFormateur() {
        try {
            formateurService.modifierFormateur(
                    idField.getText(),
                    nomField.getText(),
                    Integer.parseInt(ageField.getText()),
                    specialiteField.getText()
            );
            refresh();
            showInfo("Formateur modifié !");
        } catch (Exception e) {
            showError(e.getMessage());
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
