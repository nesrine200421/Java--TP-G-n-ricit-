import compte.Compte;

public  class CompteCourant extends Compte {
    private double l;
    public CompteCourant(int numeroCompte, double solde, Object devise, double l) {
        super(numeroCompte, solde, devise);
        this.l = l;
    }

    @Override
    public void deposer(double montant) {

    }

    @Override
    public void retirer(double montant) {
        if((solde-montant)<-l)
        {
            System.out.println(" solde insuffisant.");

        }
        else{
            solde=-montant;
            System.out.println(" solde devient"+solde);

        }

    }

    @Override
    public void afficherSolde() {
        System.out.println(devise+"- solde: "+solde+" TND ");

    }
}
