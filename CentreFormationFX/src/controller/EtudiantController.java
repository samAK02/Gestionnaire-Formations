package controller;

import gestionPersonnes.Etudiant;
import gestionPersonnes.AgeInvalideException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import service.GestionEtudiantsService;

public class EtudiantController {

    // Services singleton
    private GestionEtudiantsService etudiantService = GestionEtudiantsService.getInstance();

    // Référence vers le controller d'affichage (à injecter après le chargement du FXML)
    private AffichageController affichageController;

    // Champs texte
    @FXML private TextField idField;
    @FXML private TextField nomField;
    @FXML private TextField ageField;
    @FXML private TextField niveauField;

    // Setter pour injecter le controller Affichage
    public void setAffichageController(AffichageController controller) {
        this.affichageController = controller;
    }

    // Ajouter un étudiant
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

        } catch (AgeInvalideException ex) {
            showError(ex.getMessage());
        } catch (Exception ex) {
            showError(ex.getMessage());
        }
    }

    // Alertes
    private void showInfo(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, msg);
        alert.show();
    }

    private void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR, msg);
        alert.show();
    }
}
