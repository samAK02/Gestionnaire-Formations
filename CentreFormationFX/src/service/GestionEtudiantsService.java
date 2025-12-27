package service;

import gestionPersonnes.Etudiant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.HashMap;
import java.util.Map;
import gestionPersonnes.PersonneDejaExistanteException;


public class GestionEtudiantsService {

    // Instance unique
    private static GestionEtudiantsService instance = null;

    private Map<String, Etudiant> etudiants = new HashMap<>();

    // Constructeur privé
    private GestionEtudiantsService() { }

    // Méthode pour récupérer l'instance unique
    public static GestionEtudiantsService getInstance() {
        if (instance == null) {
            instance = new GestionEtudiantsService();
        }
        return instance;
    }

    public void ajouterEtudiant(Etudiant e) throws PersonneDejaExistanteException {
        if (etudiants.containsKey(e.getId())) {
            throw new PersonneDejaExistanteException(
                    "Un étudiant avec l'ID " + e.getId() + " existe déjà."
            );
        }
        etudiants.put(e.getId(), e);
    }
    public void supprimerEtudiant(String id) {
        if (!etudiants.containsKey(id)) {
            throw new IllegalArgumentException("Étudiant inexistant");
        }
        etudiants.remove(id);
    }

    public void modifierEtudiant(String id, String nom, int age, String niveau) {
        Etudiant e = etudiants.get(id);
        if (e == null) {
            throw new IllegalArgumentException("Étudiant inexistant");
        }
        e.nom = nom;
        e.age = age;
        e.niveau = niveau;
    }

    public Etudiant getEtudiant(String id) {
        return etudiants.get(id);
    }

    public ObservableList<Etudiant> getAllEtudiants() {
        return FXCollections.observableArrayList(etudiants.values());
    }
}
