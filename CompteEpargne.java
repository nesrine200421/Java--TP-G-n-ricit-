import compte.Compte;

public class CompteEpargne extends Compte {
    private double te;
    public CompteEpargne(int numeroCompte, double solde, Object devise, double te) {
        super(numeroCompte, solde, devise);
        this.te = te;
    }
    public void calculerInteret()
    {
        solde=solde+solde*te/100;

    }


    @Override
    public void afficherSolde() {
        System.out.println(devise+"- solde: "+solde+" TND ");


    }
}
