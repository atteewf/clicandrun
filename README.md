# Klikego-lite

API REST développée avec Spring Boot, pour la gestion d'une plateforme de courses à pied (compétitions, épreuves, athlètes, résultats). Projet d'apprentissage progressif, base du futur projet Klikego-lite (gestion d'inscriptions et de paiement).

## Stack technique

- **Java 25**
- **Spring Boot 4.1.0**
- **Spring Data JPA / Hibernate** — persistance et génération automatique des requêtes SQL
- **PostgreSQL** (hébergé sur Supabase)
- **Maven**

## Architecture

Projet structuré en 4 couches, pattern standard Spring Boot :

src/main/java/com/ateew/klikego_lite/
├── model/ → entités JPA (représentation des tables)
├── repository/ → interfaces JpaRepository (accès aux données)
├── service/ → logique métier, pont entre repository et controller
└── controller/ → endpoints REST (@RestController)

## Modèle de données

6 entités liées entre elles :

| Entité        | Description                              | Relations                                                              |
| ------------- | ---------------------------------------- | ---------------------------------------------------------------------- |
| `Competition` | Une compétition (ex: JO Rio 2016)        | —                                                                      |
| `Discipline`  | Une discipline (ex: 100m hommes)         | —                                                                      |
| `Nationality` | Une nationalité                          | —                                                                      |
| `Athlete`     | Un athlète                               | `@ManyToOne` → Nationality                                             |
| `Event`       | Une épreuve, rattachée à une compétition | `@ManyToOne` → Competition, Discipline                                 |
| `FinalResult` | Le résultat d'un athlète sur une épreuve | `@ManyToOne` → Event, Athlete · clé primaire composite (`@EmbeddedId`) |

## Endpoints disponibles

| Méthode | URL            | Description                                                                 |
| ------- | -------------- | --------------------------------------------------------------------------- |
| GET     | `/competition` | Liste des compétitions                                                      |
| GET     | `/discipline`  | Liste des disciplines                                                       |
| GET     | `/nationality` | Liste des nationalités                                                      |
| GET     | `/athlete`     | Liste des athlètes                                                          |
| GET     | `/event`       | Liste des épreuves (avec compétition et discipline imbriquées)              |
| GET     | `/finalresult` | Liste des résultats (avec athlète, événement et leurs relations imbriquées) |

> Les opérations de création, modification et suppression (POST/PUT/DELETE) restent à implémenter.

## Configuration locale

Ce projet se connecte à une base PostgreSQL hébergée sur Supabase via le connection pooler (port 6543, compatible IPv4).

1. Copier `application.properties.example` en `application.properties`
2. Renseigner les informations de connexion à votre propre base Supabase (host, username, password)
3. Lancer avec :

​`bash
mvn spring-boot:run
​`

L'application démarre sur `http://localhost:8080`.

## À venir

- CRUD complet (Create, Update, Delete) sur chaque entité
- Tests unitaires et d'intégration (`@SpringBootTest`, `MockMvc`)
- Gestion des inscriptions et du paiement (objectif final du projet Klikego-lite)
