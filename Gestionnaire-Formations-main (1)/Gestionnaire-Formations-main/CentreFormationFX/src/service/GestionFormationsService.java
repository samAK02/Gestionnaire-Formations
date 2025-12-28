package service;

import gestionPersonnes.Etudiant;
import service.GestionEtudiantsService;
import gestionPersonnes.FormationDejaExistanteException;
import gestionPersonnes.Formation;
import gestionPersonnes.FormationPleineException;
import gestionPersonnes.PersonneDejaExistanteException;
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

    public void ajouterFormation(Formation f) throws FormationDejaExistanteException {
        if (formations.containsKey(f.getIdFormation())) {
            throw new FormationDejaExistanteException(
                "Une formation avec l'ID " + f.getIdFormation() + " existe déjà."
            );
        }
        formations.put(f.getIdFormation(), f);
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

        Etudiant e = GestionEtudiantsService.getInstance().getEtudiant(idEtudiant);
        if (e == null) {
            throw new IllegalArgumentException("Étudiant inexistant");
        }

        
        f.ajouterEtudiant(idEtudiant);
        e.inscrire(idFormation);
    }


    // Désinscrire un étudiant d'une formation
    public void desinscrireEtudiant(String idFormation, String idEtudiant) {

        Formation f = formations.get(idFormation);
        Etudiant e = GestionEtudiantsService.getInstance().getEtudiant(idEtudiant);

        if (f != null && e != null) {
            f.retirerEtudiant(idEtudiant);
            e.desinscrire(idFormation);
        }
    }

    public ObservableList<Formation> getAllFormations() {
        return FXCollections.observableArrayList(formations.values());
    }
}
