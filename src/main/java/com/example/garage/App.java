package com.example.garage;

import com.example.garage.model.Client;
import com.example.garage.model.Voiture;
import com.example.garage.model.Reparation;
import com.example.garage.model.Facture;
import com.example.garage.service.GarageService;
import com.example.garage.service.FactureService;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    GarageService garage = new GarageService();
    FactureService factureService = new FactureService();

    int choix;

    do {
        System.out.println("\n===== MENU GARAGE =====");
        System.out.println("1. Ajouter un client");
        System.out.println("2. Afficher tous les clients");
        System.out.println("3. Enregistrer une voiture");
        System.out.println("4. Afficher toutes les voitures");
        System.out.println("5. Enregistrer une réparation");
        System.out.println("6. Afficher toutes les réparations");
        System.out.println("7. Créer une facture pour un client");
        System.out.println("8. Afficher les détails d'un client (Voitures et Réparations)");
        System.out.println("9. Quitter");
        System.out.print("Votre choix : ");
        
        if (sc.hasNextInt()) {
            choix = sc.nextInt();
            sc.nextLine(); 
        } else {
            System.out.println("Saisie invalide. Veuillez entrer un numéro.");
            sc.nextLine(); 
            choix = 0;
            continue;
        }


        switch (choix) {

            case 1:
                System.out.print("Nom : ");
                String nom = sc.nextLine();
                System.out.print("Prénom : ");
                String prenom = sc.nextLine();
                System.out.print("Téléphone : ");
                String tel = sc.nextLine();

                Client c = garage.creerClient(nom, prenom, tel);
                System.out.println("Client créé : " + c);
                break;

            case 2:
                List<Client> clients = garage.tousLesClients();
                System.out.println("=== Liste des clients ===");
                clients.forEach(System.out::println);
                break;

            case 3:
                System.out.print("ID client : ");
                int idC = sc.nextInt();
                sc.nextLine();

                System.out.print("Marque : ");
                String marque = sc.nextLine();
                System.out.print("Modèle : ");
                String modele = sc.nextLine();
                System.out.print("Immatriculation : ");
                String imm = sc.nextLine();

                Voiture v = garage.enregistrerVoiture(idC, marque, modele, imm);
                System.out.println("Voiture enregistrée : " + v);
                break;

            case 4:
                List<Voiture> voitures = garage.toutesLesVoitures();
                System.out.println("=== Toutes les voitures ===");
                voitures.forEach(System.out::println);
                break;

            case 5:
                System.out.print("ID voiture : ");
                int idV = sc.nextInt();
                sc.nextLine();

                System.out.print("Description : ");
                String desc = sc.nextLine();
                System.out.print("Coût : ");
                double cout = sc.nextDouble();
                sc.nextLine(); 

                Reparation r = garage.enregistrerReparation(idV, desc, cout);
                System.out.println("Réparation enregistrée : " + r);
                break;

            case 6:
                List<Reparation> reps = garage.toutesReparations();
                System.out.println("=== Réparations ===");
                reps.forEach(System.out::println);
                break;

            case 7:
                System.out.print("ID client : ");
                int idFact = sc.nextInt();
                sc.nextLine();

                Facture f = factureService.creerFacturePourClient(idFact);

                System.out.println("Ajoutez des lignes (nom + prix). 'stop' pour terminer");
                while (true) {
                    System.out.print("Nom ligne : ");
                    String line = sc.nextLine();
                    if (line.equalsIgnoreCase("stop")) break;

                    System.out.print("Montant : ");
                    double montant = sc.nextDouble();
                    sc.nextLine();

                    f.ajouterLigne(line, montant);
                }
                
                
                Facture factureSauvegardee = factureService.sauvegarderFacture(f);

                System.out.println("FACTURE CRÉÉE (ID: " + factureSauvegardee.getId() + ") : ");
                System.out.println(factureSauvegardee);
                break;

            case 8: 
                System.out.print("ID du client à afficher : ");
                int idDetail = sc.nextInt();
                sc.nextLine();

               
                java.util.Optional<Client> clientOpt = garage.trouverClientParId(idDetail);

                if (clientOpt.isPresent()) {
                    Client cDetail = clientOpt.get();
                    System.out.println("\n=== DÉTAILS DU CLIENT AVEC VOITURES ET RÉPARATIONS ===");
                    System.out.println(cDetail); 
                } else {
                    System.out.println("Client non trouvé avec l'ID : " + idDetail);
                }
                break;

            case 9:
                System.out.println("Au revoir !");
                break;

            default:
                System.out.println("Choix invalide !");
        }

    } while (choix != 9); 

    sc.close();
}
}
