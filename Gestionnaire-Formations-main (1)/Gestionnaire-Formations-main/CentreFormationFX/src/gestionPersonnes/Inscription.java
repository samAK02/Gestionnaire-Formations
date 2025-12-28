package gestionPersonnes;

public interface Inscription {
    void inscrire(String idFormation) throws FormationIntrouvableException, FormationPleineException;
    void desinscrire(String idFormation) throws FormationIntrouvableException;

}