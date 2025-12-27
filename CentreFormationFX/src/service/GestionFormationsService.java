package service;

import gestionPersonnes.Formation;
import gestionPersonnes.FormationPleineException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.HashMap;
import java.util.Map;
import gestionPersonnes.EtudiantDejaInscritException;


public class GestionFormationsService {

    private static GestionFormationsService instance = null;
    private Map<String, Formation> formations = new HashMap<>();

    private GestionFormationsService() { }

    public static GestionFormationsService getInstance() {
        if (instance == null) {
            instance = new GestionFormationsService();
        }
        return instance;
    }

    public void ajouterFormation(Formation f) {
        formations.put(f.IdFormation, f);
    }
    public void supprimerFormation(String id) {
        formations.remove(id);
    }

    public void modifierFormation(String id, String intitule, int capacite) {
        Formation f = formations.get(id);
        if (f == null) {
            throw new IllegalArgumentException("Formation introuvable");
        }
        f.setIntitule(intitule);
        f.setCapacite(capacite);
    }


    public Formation getFormation(String id) {
        return formations.get(id);
    }

    // Inscrire un étudiant à une formation
    public void inscrireEtudiant(String idFormation, String idEtudiant)
            throws FormationPleineException, EtudiantDejaInscritException {

        Formation f = formations.get(idFormation);

        if (f == null) {
            throw new IllegalArgumentException("Formation inexistante");
        }

        f.ajouterEtudiant(idEtudiant);
    }


    // Désinscrire un étudiant d'une formation
    public void desinscrireEtudiant(String idFormation, String idEtudiant) {
        Formation f = formations.get(idFormation);
        if (f != null) {
            f.retirerEtudiant(idEtudiant);
        }
    }

    public ObservableList<Formation> getAllFormations() {
        return FXCollections.observableArrayList(formations.values());
    }
}
