package net.lecnam.ecue2.revisions;

public class Banque {
    public String nom;
    public CompteBancaire[] comptes;
    public int nbComptes;

    public Banque(String nom, int capaciteMax) {
        this.nom = nom;
        this.comptes = new CompteBancaire[capaciteMax];
        this.nbComptes = 0;
    }
    
    public void ajouterCompte(CompteBancaire compte) {
        if (nbComptes < comptes.length) {
            for (int i = 0; i < nbComptes; i++) {
                if (comptes[i].getNumeroCompte().equals(compte.getNumeroCompte())) {
                    throw new IllegalArgumentException("Un compte avec ce numéro existe déjà.");
                }
            }
            comptes[nbComptes] = compte;
            nbComptes++;
        } else {
            throw new IllegalStateException("La banque a atteint sa capacité maximale de comptes.");
        }
    }

    public double getNbComptes() {
        return nbComptes;
    }

    public CompteBancaire rechercherCompte(String numeroCompte) {
        for (int i = 0; i < nbComptes; i++) {
            if (comptes[i].getNumeroCompte().equals(numeroCompte)) {
                return comptes[i];
            }
        }
        return null;
    }

    public CompteBancaire[] listerComptesClient(Client client) {
        int nombreComptesClient = 0;
        for (int i = 0; i < nbComptes; i++) {
            if (comptes[i].getTitulaire().equals(client)) {
                nombreComptesClient++;
            }
        }

        CompteBancaire[] comptesClient = new CompteBancaire[nombreComptesClient];
        int index = 0;
        for (int i = 0; i < nbComptes; i++) {
            if (comptes[i].getTitulaire().equals(client)) {
                comptesClient[index] = comptes[i];
                index++;
            }
        }
        return comptesClient;
    }

    public double calculerSoldeTotal() {
        double soldeTotal = 0;
        for (int i = 0; i < nbComptes; i++) {
            soldeTotal += comptes[i].getSolde();
        }
        return soldeTotal;
    }
}
