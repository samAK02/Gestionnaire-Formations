package gestionPersonnes;
import java.util.HashSet;
import java.util.Set;

public class Formation {
	public String IdFormation;
	public String intitule;
	public String capacite;
	public Set<String> etudiantsInscrits;
	
	public Formation(String IdFormation, String intitule, String capacite) {
		this.intitule = intitule;
		this.capacite = capacite;
		this.IdFormation = IdFormation;
		this.etudiantsInscrits = new HashSet<>();
	}
	
	public void ajouterEtudiant(String id) {
		if (estPleine()) {
			throw new FormationPleineException("Formation pleine");
		}
		etudiantsInscrits.add(IdEtudiant);
		
	}
	
	public void retirerEtudiant(String id) {
		etudiantsInscrits.remove(IdEtudiant);
		
	}
	
	public boolean estPleine() {
		return etudiantsInscrits.size() >= capacite;
	}
	
	public String toString() {
		return "Id Formation: "+IdFormation+"Intitulé: "+intitule+"capacité: "+capacite+", Inscrits"+etudiantsInscrits.size();
	}
	
}
