package com.example;

import com.example.model.Salle;
import com.example.model.Utilisateur;
import com.example.service.SalleService;
import com.example.service.UtilisateurService;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) {
        // Create the EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion-salles"); // JPA bootstrap

        // Create services
        UtilisateurService utilisateurService = new UtilisateurService(emf); // user operations
        SalleService salleService = new SalleService(emf); // room operations

        try {
            // CRUD Utilisateur
            System.out.println("\n=== CRUD Demo: Users ===");
            testCrudUtilisateur(utilisateurService);

            // CRUD demo for Salle
            System.out.println("\n=== CRUD Demo: Rooms ===");
            testCrudSalle(salleService);

        } finally {
            // Close the EntityManagerFactory
            emf.close();
        }
    }

    private static void testCrudUtilisateur(UtilisateurService service) {
        // Create
        System.out.println("Creating users...");
        Utilisateur u1 = new Utilisateur("Rossi", "Luc", "luc.rossi@example.com"); // sample user
        u1.setDateNaissance(LocalDate.of(1985, 5, 15));
        u1.setTelephone("+33611112222");

        Utilisateur u2 = new Utilisateur("Khan", "Nadia", "nadia.khan@example.com");
        u2.setDateNaissance(LocalDate.of(1990, 10, 20));
        u2.setTelephone("+33633334444");

        service.save(u1);
        service.save(u2);

        // Read
        System.out.println("\nReading all users:");
        List<Utilisateur> utilisateurs = service.findAll();
        utilisateurs.forEach(System.out::println);

        System.out.println("\nFinding a user by ID:");
        Optional<Utilisateur> utilisateurOpt = service.findById(1L);
        utilisateurOpt.ifPresent(System.out::println);

        System.out.println("\nFinding a user by email:");
        Optional<Utilisateur> utilisateurParEmail = service.findByEmail("nadia.khan@example.com");
        utilisateurParEmail.ifPresent(System.out::println);

        // Update
        System.out.println("\nUpdating a user:");
        utilisateurOpt.ifPresent(utilisateur -> {
            utilisateur.setTelephone("+33699887766");
            service.update(utilisateur);
            System.out.println("User updated: " + utilisateur);
        });

        // Delete
        System.out.println("\nDeleting a user:");
        service.deleteById(2L);
        System.out.println("User with ID=2 deleted");

        System.out.println("\nUsers list after deletion:");
        service.findAll().forEach(System.out::println);
    }

    private static void testCrudSalle(SalleService service) {
        // Create
        System.out.println("Creating rooms...");
        Salle s1 = new Salle("Room D110", 30);
        s1.setDescription("Training room with projector");
        s1.setEtage(1);

        Salle s2 = new Salle("Auditorium E205", 150);
        s2.setDescription("Large auditorium for lectures");
        s2.setEtage(2);

        Salle s3 = new Salle("Room F307", 10);
        s3.setDescription("Small room for interviews");
        s3.setEtage(3);
        s3.setDisponible(false);

        service.save(s1);
        service.save(s2);
        service.save(s3);

        // Read
        System.out.println("\nReading all rooms:");
        List<Salle> salles = service.findAll();
        salles.forEach(System.out::println);

        System.out.println("\nFinding a room by ID:");
        Optional<Salle> salleOpt = service.findById(2L);
        salleOpt.ifPresent(System.out::println);

        System.out.println("\nFinding available rooms:");
        List<Salle> sallesDisponibles = service.findByDisponible(true);
        sallesDisponibles.forEach(System.out::println);

        System.out.println("\nFinding rooms with capacity >= 50:");
        List<Salle> sallesGrandes = service.findByCapaciteMinimum(50);
        sallesGrandes.forEach(System.out::println);

        // Update
        System.out.println("\nUpdating a room:");
        salleOpt.ifPresent(salle -> {
            salle.setCapacite(200);
            service.update(salle);
            System.out.println("Room updated: " + salle);
        });

        // Delete
        System.out.println("\nDeleting a room:");
        service.deleteById(3L);
        System.out.println("Room with ID=3 deleted");

        System.out.println("\nRooms list after deletion:");
        service.findAll().forEach(System.out::println);
    }
}
