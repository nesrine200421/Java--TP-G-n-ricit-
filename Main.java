import compte.Compte;

public class Main {
    public static void main(String[] args) {
        Banque banque = new Banque();
        banque.ajouterCompte(new Compte<>(1, 5789, "EUR"));
        banque.ajouterCompte(new Compte<>(2, 3456, "USD"));
        banque.ajouterCompte(new Compte<>(3, 7123, "TND"));
        CompteCourant compteCourant = new CompteCourant(4, 5, "EUR", 257);
        CompteEpargne compteEpargne = new CompteEpargne(5, 30, "USD", 15);
        CompteCourantSecurise<String> compteSecurise = new CompteCourantSecurise<>(3, 7741, "TND", 963, "nesrine");

        banque.ajouterCompte(compteCourant);
        banque.ajouterCompte(compteEpargne);
        banque.ajouterCompte(compteSecurise);

        banque.afficherComptesTries();
        Compte<?> compteTrouve = banque.recher(2);
        if (compteTrouve != null) {
            System.out.println("Compte trouvé : " + compteTrouve.getNumeroCompte() );
        } else {
            System.out.println("Compte introuvable.");
        }

        boolean supprime = banque.supp(1);
        if (supprime) {
            System.out.println("Compte supprime");
        } else {
            System.out.println("echec");
        }
        try {
            if (!compteSecurise.verifierIdentite("nn")) {
                throw new AccesInterditException("acces interdit!!!!!!");
            }
            compteSecurise.retirer(500);
        } catch (AccesInterditException e) {
            System.out.println("Échec: " + e.getMessage());
        }
    }

}
