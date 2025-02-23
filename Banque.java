import java.util.HashMap;
import java.util.Map;
import compte.*;

public class Banque {
    private Map<Integer, Compte<?>> comptes = new HashMap<>();

    public void ajouterCompte(Compte<?> compte) {
        comptes.put(compte.getNumeroCompte(), compte);
    }

    public Compte<?> recher(int numeroCompte) {
        for (Map.Entry<Integer, Compte<?>> entry : comptes.entrySet()) {
            if(entry.getKey()==numeroCompte)
            {
                return entry.getValue();
            }

        }
        return null;
    }

    public boolean supp(int numeroCompte) {
        if (comptes.containsKey(numeroCompte)) {
            comptes.remove(numeroCompte);
            return true;
        }
        return false;
    }

    public void afficherComptesTries() {
        int size = comptes.size();
        Integer[] keys = new Integer[size];
        Compte<?>[] values = new Compte<?>[size];  // Correction ici
        int index = 0;

        for (Map.Entry<Integer, Compte<?>> entry : comptes.entrySet()) {
            keys[index] = entry.getKey();
            values[index] = entry.getValue();
            index++;
        }

        for (int i = 1; i < size; i++) {
            Compte<?> val = values[i];
            Integer key = keys[i];
            double solde = values[i].getSolde();
            int j = i - 1;

            while (j >= 0 && values[j].getSolde() < solde) {
                values[j + 1] = values[j];
                keys[j + 1] = keys[j];
                j--;
            }

            values[j + 1] = val;
            keys[j + 1] = key;
        }

        for (int i = 0; i < size; i++) {
            System.out.println("Compte "+ keys[i] + " Solde: " + values[i].getSolde());
        }
    }
}
