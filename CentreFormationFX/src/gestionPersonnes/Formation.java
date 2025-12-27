package gestionPersonnes;
import java.util.HashSet;
import java.util.Set;

public class Formation {
    public String IdFormation;
    public String intitule;
    public int capacite;
    public Set<String> etudiantsInscrits;

    public Formation(String IdFormation, String intitule, int capacite) {
        this.intitule = intitule;
        this.capacite = capacite;
        this.IdFormation = IdFormation;
        this.etudiantsInscrits = new HashSet<>();
    }

    public void ajouterEtudiant(String IdEtudiant) throws FormationPleineException, EtudiantDejaInscritException{
        if (etudiantsInscrits.contains(IdEtudiant)) {
            throw new EtudiantDejaInscritException(
                    "Étudiant déjà inscrit dans cette formation"
            );
        }
        if (estPleine()) {
            throw new FormationPleineException("Formation pleine");
        }
        etudiantsInscrits.add(IdEtudiant);

    }
    public String getIdFormation() {
        return IdFormation;
    }

    public String getIntitule() {
        return intitule;
    }

    public int getCapacite() {
        return capacite;
    }


    public Set<String> getEtudiantsInscrits() {
        return etudiantsInscrits;
    }
    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
    public void retirerEtudiant(String IdEtudiant) {
        etudiantsInscrits.remove(IdEtudiant);

    }

    public boolean estPleine() {
        return etudiantsInscrits.size() >= capacite;
    }

    public String toString() {
        return "Id Formation: "+IdFormation+"Intitulé: "+intitule+"capacité: "+capacite+", Inscrits"+etudiantsInscrits.size();
    }

}