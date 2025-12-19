package gestionPersonnes;

public abstract class Personne {
	public String Id;
	public String nom;
	public int age;
	
	public Personne(String Id, String nom, int age) {
		this.nom = nom;
		this.age = age;
		this.Id = Id;
	}
	
	public String getNom() {
		return nom;
	}
	public int getAge() {
		return age;
	}
	public abstract String getType();
	
	public String toString() {
		return "id: "+Id+"nom :"+nom+"Age: "+age;
	}
	
	
}
