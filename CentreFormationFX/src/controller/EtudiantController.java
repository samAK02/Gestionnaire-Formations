package controller;

import gestionPersonnes.Etudiant;
import gestionPersonnes.AgeInvalideException;
import gestionPersonnes.FormationPleineException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import service.GestionEtudiantsService;
import service.GestionFormationsService;

public class EtudiantController {

    // Services singleton
    private GestionEtudiantsService etudiantService = GestionEtudiantsService.getInstance();
    private GestionFormationsService formationService = GestionFormationsService.getInstance();

    // Champs texte
    @FXML private TextField idField;
    @FXML private TextField nomField;
    @FXML private TextField ageField;
    @FXML private TextField niveauField;
    @FXML private TextField formationField; // ID formation pour inscrire/désinscrire

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

    // Inscrire un étudiant à une formation
    @FXML
    private void inscrire() {
        try {
            String idEtudiant = idField.getText();
            String idFormation = formationField.getText();
            formationService.inscrireEtudiant(idFormation, idEtudiant);
            showInfo("Inscription réussie !");
        } catch (FormationPleineException ex) {
            showError(ex.getMessage());
        } catch (Exception ex) {
            showError("Erreur inscription : " + ex.getMessage());
        }
    }

    // Désinscrire un étudiant d'une formation
    @FXML
    private void desinscrire() {
        try {
            String idEtudiant = idField.getText();
            String idFormation = formationField.getText();
            formationService.desinscrireEtudiant(idFormation, idEtudiant);
            showInfo("Désinscription réussie !");
        } catch (Exception ex) {
            showError("Erreur désinscription : " + ex.getMessage());
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
