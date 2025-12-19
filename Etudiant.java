package gestionPersonnes;
import java.util.HashSet;
import java.util.Set;

public class Etudiant extends Personne implements Inscription{
	public String niveau;
	public Set<String> formationsInscrites;
	
	public Etudiant(String Id, String nom, int age, String niveau) {
		super(Id,nom, age);
		this.niveau = niveau;	
		this.formationsInscrites = new HashSet<>();
	}
	
	public String getNiveau() {
		return niveau;
	}
	
	@Override
	public String getType() {
		return "Etudiant";
	}
	
	@Override
	public void inscrire(String IdFormation) {
		formationInscrites.add(IdFormation);
	}
	
	@Override
	public void desinscrire(String IdFormation) {
		formationInscrites.remove(IdFormation);
	}
	
	
	@Override
	public String toString() {
		return super.toString()+"niveau: "+niveau;
	}
}
