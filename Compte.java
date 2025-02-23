package compte;
 public class Compte<T>{
    protected int  numeroCompte;
    protected double solde ;
    protected T devise;

    public Compte(int numeroCompte, double solde, T devise) {
        this.numeroCompte = numeroCompte;
        this.solde = solde;
        this.devise = devise;
    }
    public void deposer(double montant){
        if (montant > 0) {
            solde += montant;
            System.out.println("nouveau solde : " + solde);
        } else {
            System.out.println("le montant doit être positif.");
        }
    }
     public void retirer(double montant){
         if (solde-montant<0) {
             System.out.println("solde insuffisant");
         } else {
             solde -= montant;
         }
     }
     public void afficherSolde(){
        System.out.println("Compte " + numeroCompte + " - Solde : " + solde + " " + devise);    }
    public static <T> void transferer(Compte<T> c1, Compte<T> c2, double montant) {
        if (c1.solde >= montant) {
            c1.solde -= montant;
            c2.solde += montant;
            System.out.println("Nouveau solde de " + c1.numeroCompte + ": " + c1.solde);
            System.out.println("Nouveau solde de " + c2.numeroCompte + ": " + c2.solde);
        } else {
            System.out.println("solde insuffisant ");
        }
    }

     public int getNumeroCompte() {
         return numeroCompte;
     }

     public double getSolde() {
         return solde;
     }
 }
