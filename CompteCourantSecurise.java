class AccesInterditException extends Exception{
    public AccesInterditException(String message) {
        super(message);
    }
}
public class CompteCourantSecurise<T> extends CompteCourant implements Securisable {
    private String id;
    public CompteCourantSecurise(int numeroCompte, double solde, Object devise, double l, String id) {
        super(numeroCompte, solde, devise, l);
        this.id = id;
    }

    @Override
    public boolean verifierIdentite(String identifiant) {
        return id.equals(identifiant);

    }

    public void retirer(String idu,double montant) throws AccesInterditException{
        if(verifierIdentite(idu)){
            super.retirer(montant);
        }
        else{
            throw new AccesInterditException("Accès interdit");

        }
    }

    public void deposer(String idu,double montant) throws AccesInterditException{
        if(verifierIdentite(idu)){
            super.deposer(montant);
        }
        else{
            throw new AccesInterditException("Accès interdit");

        }
    }


    public void afficherSolde(String idu) throws AccesInterditException {
        if(verifierIdentite(idu)){
            super.afficherSolde();
        }
        else{
            throw new AccesInterditException("Accès interdit");

        }
    }
}
