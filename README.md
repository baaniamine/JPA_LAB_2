# 🏢 Gestion Salles — JPA / Hibernate / H2

> Projet Java démontrant un **CRUD générique** avec **JPA + Hibernate** sur une base **H2 en mémoire**, organisé autour d'une couche de services abstraits et concrets.

---



## ✨ Fonctionnalités

- ✅ CRUD complet sur les entités `Utilisateur` et `Salle`
- ✅ Interface générique `CrudService<T, ID>` + `AbstractCrudService<T, ID>`
- ✅ Validations avec **Bean Validation** (Hibernate Validator)
- ✅ Base H2 en mémoire — aucune installation requise
- ✅ Schéma généré et supprimé automatiquement au démarrage/arrêt
- ✅ Tests JUnit 4 sur la couche service

---

## 🧱 Technologies

| Technologie | Version |
|---|---|
| Java | JDK 8+ |
| Maven | 3.x |
| JPA API | 2.2 |
| Hibernate Core | 5.6.5.Final |
| Hibernate Validator | 6.2.0.Final |
| H2 Database | 2.1.214 |
| SLF4J | 1.7.36 |
| JUnit | 4.13.2 |

---

## 🗂 Architecture

```
gestion-salles/
├── src/
│   ├── main/
│   │   ├── java/com/example/
│   │   │   ├── App.java                        ← Point d'entrée (démo CRUD)
│   │   │   ├── model/
│   │   │   │   ├── Utilisateur.java
│   │   │   │   └── Salle.java
│   │   │   └── service/
│   │   │       ├── CrudService.java            ← Interface générique
│   │   │       ├── AbstractCrudService.java    ← Implémentation abstraite
│   │   │       ├── UtilisateurService.java
│   │   │       └── SalleService.java
│   │   └── resources/META-INF/
│   │       └── persistence.xml
│   └── test/
│       └── java/com/example/service/          ← Tests JUnit
├── pom.xml
└── README.md
```

---

## ⚙️ Configuration JPA

Unité de persistance : **`gestion-salles`**

```xml
<property name="javax.persistence.jdbc.url"
          value="jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1"/>
<property name="hibernate.hbm2ddl.auto" value="create-drop"/>
<property name="hibernate.show_sql"     value="true"/>
<property name="hibernate.format_sql"   value="true"/>
```

---

---

## 🎬 Démonstration vidéo

[![Voir la démo](https://img.youtube.com/vi/0VbgPTi0DpA/0.jpg)](https://www.youtube.com/watch?v=0VbgPTi0DpA)
