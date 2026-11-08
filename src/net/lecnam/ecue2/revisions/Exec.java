package net.lecnam.ecue2.revisions;

import java.time.LocalDate;

public class Exec {
    static void main() throws SoldeInsuffisantException {

        Client client1 = new Client("MOUCHARD", "Yannis", "158jught");
        Client client2 = new Client("LACASA", "Jean", "158jught");
        Client client3 = new Client("ROBERT", "Entier", "488fjegfi");

        System.out.println(client1.toString());
        System.out.println(client1.equals(client2));
        System.out.println(client1.equals(client3));

        CompteCourant compte1 = new CompteCourant("186465163", client1, 1500);

        compte1.deposer(1500);
        compte1.retirer(1000);
        System.out.println(compte1.toString());

        CompteEpargne compte2 = new CompteEpargne("123456789", client2, 0.03);

        compte2.deposer(1500);
        System.out.println(compte2.toString());

        Banque banque = new Banque("Banque de France", 2);
        banque.ajouterCompte(compte1);
        banque.ajouterCompte(compte2);

        System.out.println("Virement valide : " + banque.effectuerVirement(
                compte1.getNumeroCompte(), compte2.getNumeroCompte(), 100));

        try {
            banque.effectuerVirement("74838740347", compte2.getNumeroCompte(), 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Compte inexistant : " + e.getMessage());
        }

        try {
            banque.effectuerVirement(compte1.getNumeroCompte(), compte2.getNumeroCompte(), 100000);
        } catch (SoldeInsuffisantException e) {
            System.out.println("Solde insuffisant : " + e.getMessage());
        }

        
    }
}
