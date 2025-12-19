package gestionPersonnes;

public class Formateur extends Personne{
	public String specialite;
	
	public Formateur(String Id, String nom, int age, String specialite) {
		super(Id, nom, age);
		this.specialite = specialite;
	}
	
	@Override 
	public String getType() {
		return "Formateur";
	}
	
	@Override
	public String toString() {
		return super.toString()+ "specialité: "+specialite;
	}
}
