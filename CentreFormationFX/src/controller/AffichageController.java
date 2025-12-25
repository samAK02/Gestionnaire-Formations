package controller;

import gestionPersonnes.Etudiant;
import gestionPersonnes.Formateur;
import gestionPersonnes.Formation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.GestionEtudiantsService;
import service.GestionFormateursService;
import service.GestionFormationsService;
import javafx.beans.property.SimpleIntegerProperty;


public class AffichageController {

    @FXML private TableView<Etudiant> tableEtudiants;
    @FXML private TableColumn<Etudiant, String> colIdEtudiant;
    @FXML private TableColumn<Etudiant, String> colNomEtudiant;
    @FXML private TableColumn<Etudiant, Integer> colAgeEtudiant;
    @FXML private TableColumn<Etudiant, String> colNiveauEtudiant;

    @FXML private TableView<Formateur> tableFormateurs;
    @FXML private TableColumn<Formateur, String> colIdFormateur;
    @FXML private TableColumn<Formateur, String> colNomFormateur;
    @FXML private TableColumn<Formateur, Integer> colAgeFormateur;
    @FXML private TableColumn<Formateur, String> colSpecialiteFormateur;

    @FXML private TableView<Formation> tableFormations;
    @FXML private TableColumn<Formation, String> colIdFormation;
    @FXML private TableColumn<Formation, String> colIntitule;
    @FXML private TableColumn<Formation, Integer> colCapacite;
    @FXML private TableColumn<Formation, Integer> colInscrits;

    // Références aux services (les mêmes que utilisés dans les autres controllers)
    private GestionEtudiantsService etudiantService = GestionEtudiantsService.getInstance();
    private GestionFormateursService formateurService = GestionFormateursService.getInstance();
    private GestionFormationsService formationService = GestionFormationsService.getInstance();

    @FXML
    public void initialize() {
        // Colonnes Étudiants
        colIdEtudiant.setCellValueFactory(new PropertyValueFactory<>("Id"));
        colNomEtudiant.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colAgeEtudiant.setCellValueFactory(new PropertyValueFactory<>("age"));
        colNiveauEtudiant.setCellValueFactory(new PropertyValueFactory<>("niveau"));

        // Colonnes Formateurs
        colIdFormateur.setCellValueFactory(new PropertyValueFactory<>("Id"));
        colNomFormateur.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colAgeFormateur.setCellValueFactory(new PropertyValueFactory<>("age"));
        colSpecialiteFormateur.setCellValueFactory(new PropertyValueFactory<>("specialite"));

        // Colonnes Formations
        colIdFormation.setCellValueFactory(new PropertyValueFactory<>("IdFormation"));
        colIntitule.setCellValueFactory(new PropertyValueFactory<>("intitule"));
        colCapacite.setCellValueFactory(new PropertyValueFactory<>("capacite"));
        colInscrits.setCellValueFactory(cellData ->
                new SimpleIntegerProperty(cellData.getValue().etudiantsInscrits.size()).asObject()
        );

        // Charger les données
        tableEtudiants.setItems(FXCollections.observableArrayList(etudiantService.getAllEtudiants()));
        tableFormateurs.setItems(FXCollections.observableArrayList(formateurService.getAllFormateurs()));
        tableFormations.setItems(FXCollections.observableArrayList(formationService.getAllFormations()));
    }
}
