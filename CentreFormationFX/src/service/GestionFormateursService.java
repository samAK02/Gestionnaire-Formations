package service;

import gestionPersonnes.Formateur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.HashMap;
import java.util.Map;

public class GestionFormateursService {

    // Instance unique du service
    private static GestionFormateursService instance = null;

    private Map<String, Formateur> formateurs = new HashMap<>();

    // Constructeur privé pour empêcher l'instanciation externe
    private GestionFormateursService() { }

    // Méthode pour récupérer l'instance unique
    public static GestionFormateursService getInstance() {
        if (instance == null) {
            instance = new GestionFormateursService();
        }
        return instance;
    }

    public void ajouterFormateur(Formateur f) {
        formateurs.put(f.getId(), f);
    }

    public Formateur getFormateur(String id) {
        return formateurs.get(id);
    }

    public ObservableList<Formateur> getAllFormateurs() {
        return FXCollections.observableArrayList(formateurs.values());
    }
}
