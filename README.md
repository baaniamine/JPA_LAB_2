# Gestion Salles

A simple JPA/Hibernate CRUD demo for managing users and rooms with an in-memory H2 database.

**What it does**
- Demonstrates basic CRUD operations for `Utilisateur` and `Salle`
- Uses JPA + Hibernate with Bean Validation annotations
- Runs against an in-memory H2 database (auto create/drop schema)

**Tech stack**
- Java (JDK required)
- Maven
- JPA (Hibernate), Hibernate Validator
- H2 Database
- JUnit 4

**Project structure**
- `src/main/java/com/example/App.java` main entry point with demo CRUD flows
- `src/main/java/com/example/model/` JPA entities
- `src/main/java/com/example/service/` service layer with CRUD helpers
- `src/test/java/com/example/service/` JUnit tests
- `src/main/resources/META-INF/persistence.xml` JPA persistence config

**Run**
1. From your IDE, run `com.example.App`
2. Or from the terminal:

```bash
mvn -q exec:java -Dexec.mainClass="com.example.App"
```

**Tests**
```bash
mvn test
```

**Notes**
- The database is in-memory (H2): `jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1`
- Schema is generated automatically on startup and dropped on shutdown
