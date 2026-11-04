package net.lecnam.ecue2.revisions;

public class Exec {
    static void main() {

        Client client1 = new Client("MOUCHARD", "Yannis", "158jught");
        Client client2 = new Client("LACASA", "Jean", "158jught");
        Client client3 = new Client("ROBERT", "Entier", "488fjegfi");

        System.out.println(client1.toString());
        System.out.println(client1.equals(client2));
        System.out.println(client1.equals(client3));
    }
}
