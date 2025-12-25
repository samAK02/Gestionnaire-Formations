package gestionPersonnes;

public abstract class Personne {
    public String Id;
    public String nom;
    public int age;

    public Personne(String Id, String nom, int age) throws AgeInvalideException {
        if (age < 18) {
            throw new AgeInvalideException("Age inférieur à 18 ans interdit");
        }
        this.nom = nom;
        this.age = age;
        this.Id = Id;
    }
    public String getId() {
        return Id;
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