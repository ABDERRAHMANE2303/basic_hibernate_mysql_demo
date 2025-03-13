package com.tp1hibernate;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EntrepriseDAO entrepriseDAO = new EntrepriseDAO();
        Scanner scanner = new Scanner(System.in);
        
        boolean running = true;
        while (running) {
            System.out.println("\n--- Gestion d'Entreprises ---");
            System.out.println("1. Ajouter une entreprise");
            System.out.println("2. Afficher toutes les entreprises");
            System.out.println("3. Rechercher une entreprise par ID");
            System.out.println("4. Rechercher une entreprise par nom");
            System.out.println("5. Trier les entreprises par nombre d'employés");
            System.out.println("6. Afficher le nombre total d'entreprises");
            System.out.println("7. Mettre à jour une entreprise");
            System.out.println("8. Supprimer une entreprise");
            System.out.println("9. Quitter");
            System.out.print("Choisissez une option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("Entrez le nom de l'entreprise: ");
                    String nom = scanner.nextLine();
                    System.out.print("Entrez les activités de l'entreprise: ");
                    String activites = scanner.nextLine();
                    System.out.print("Entrez le nombre d'employés: ");
                    int employes = scanner.nextInt();
                    scanner.nextLine();

                    Entreprise entrepriseToAdd = new Entreprise(nom, activites, employes);
                    entrepriseDAO.insertEntreprise(entrepriseToAdd);
                    System.out.println("Entreprise ajoutée avec succès !");
                    break;

                case 2:
                    List<Entreprise> entreprises = entrepriseDAO.getAllEntreprises();
                    System.out.println("\n+----+----------------------+-----------------------+-------------+");
                    System.out.println("| ID | Nom                 | Activités             | Employés    |");
                    System.out.println("+----+----------------------+-----------------------+-------------+");
                    for (Entreprise e : entreprises) {
                        System.out.printf("| %-2d | %-20s | %-21s | %-11d |\n", 
                            e.getIdEntreprise(), e.getNomEnt(), e.getListeActivites(), e.getNbEmployes());
                    }
                    System.out.println("+----+----------------------+-----------------------+-------------+\n");
                    break;

                case 3:
                    System.out.print("Entrez l'ID de l'entreprise à rechercher: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); 
                    Entreprise entrepriseById = entrepriseDAO.findEntrepriseById(id);
                    System.out.println("Détails de l'entreprise: " + entrepriseById);
                    break;

                case 4:
                    System.out.print("Entrez le nom de l'entreprise à rechercher: ");
                    String name = scanner.nextLine();
                    Entreprise entrepriseByName = entrepriseDAO.getEntrepriseByName(name);
                    System.out.println("Entreprise trouvée: " + entrepriseByName);
                    break;

                case 5:
                    System.out.println("\nEntreprises triées par nombre d'employés:");
                    entrepriseDAO.getEntreprisesSortedByEmployees().forEach(System.out::println);
                    break;

                case 6:
                    System.out.println("\nTotal d'entreprises enregistrées: " + entrepriseDAO.getEntrepriseCount());
                    break;

                case 7:
                    System.out.print("Entrez l'ID de l'entreprise à mettre à jour: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Entrez le nouveau nom de l'entreprise: ");
                    String newName = scanner.nextLine();
                    entrepriseDAO.updateEntreprise(updateId, newName);
                    System.out.println("Entreprise mise à jour avec succès !");
                    break;

                case 8:
                    System.out.print("Entrez l'ID de l'entreprise à supprimer: ");
                    int deleteId = scanner.nextInt();
                    entrepriseDAO.deleteEntreprise(deleteId);
                    System.out.println("Entreprise supprimée avec succès !");
                    break;

                case 9:
                    running = false;
                    break;

                default:
                    System.out.println("Option invalide, veuillez essayer à nouveau.");
            }
        }

        scanner.close();
        HibernateUtil.shutdown();
    }
}
