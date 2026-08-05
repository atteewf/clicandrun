# ClicAndRun

API REST développée avec Spring Boot, pour la gestion d'une plateforme de courses à pied (compétitions, épreuves, athlètes, résultats). Projet d'apprentissage progressif, incluant authentification sécurisée et gestion des rôles.

## Stack technique

- **Java 25**
- **Spring Boot 4.1.0**
- **Spring Data JPA / Hibernate** — persistance et génération automatique des requêtes SQL
- **Spring Security / JWT** — authentification et sécurisation des routes
- **Bean Validation** — validation des données entrantes
- **PostgreSQL** (hébergé sur Supabase)
- **JUnit / Mockito** — tests unitaires
- **Maven**

## Architecture

Projet structuré en couches, pattern standard Spring Boot :

```
src/main/java/com/ateew/clicandrun/
├── model/       → entités JPA (représentation des tables)
├── dto/         → objets d'échange avec validation (entrée API)
├── repository/  → interfaces JpaRepository (accès aux données)
├── service/     → logique métier, pont entre repository et controller
├── controller/  → endpoints REST (@RestController)
├── config/      → configuration Spring Security, JWT
└── exception/   → exceptions custom et gestion centralisée des erreurs
```

## Modèle de données

7 entités liées entre elles :

| Entité        | Description                              | Relations                                                                           |
| ------------- | ---------------------------------------- | ----------------------------------------------------------------------------------- |
| `Competition` | Une compétition (ex: JO Rio 2016)        | —                                                                                   |
| `Discipline`  | Une discipline (ex: 100m hommes)         | —                                                                                   |
| `Nationality` | Une nationalité                          | —                                                                                   |
| `Athlete`     | Un athlète                               | `@ManyToOne` → Nationality                                                          |
| `Event`       | Une épreuve, rattachée à une compétition | `@ManyToOne` → Competition, Discipline                                              |
| `FinalResult` | Le résultat d'un athlète sur une épreuve | `@ManyToOne` → Event, Athlete · clé primaire composite (`@EmbeddedId`)              |
| `User`        | Un compte utilisateur (authentification) | `@OneToOne` → Athlete (optionnel, nul pour les comptes admin) · rôle `USER`/`ADMIN` |

## Sécurité

- Authentification par **JWT** (génération et validation via `JwtEncoder`/`JwtDecoder`)
- Mots de passe **hashés en BCrypt**, jamais stockés en clair
- Routes `GET` publiques (lecture libre)
- Routes `POST` / `PUT` / `DELETE` protégées, nécessitent un token JWT valide
- `POST /login` : échange identifiants (email + mot de passe) contre un token JWT

## Endpoints disponibles

| Méthode         | URL                                                  | Description                           | Accès       |
| --------------- | ---------------------------------------------------- | ------------------------------------- | ----------- |
| POST            | `/login`                                             | Authentification, retourne un JWT     | Public      |
| GET             | `/competition`, `/competition/{id}`                  | Consultation des compétitions         | Public      |
| POST/PUT/DELETE | `/competition`, `/competition/{id}`                  | Création / modification / suppression | Authentifié |
| GET             | `/discipline`, `/discipline/{id}`                    | Consultation des disciplines          | Public      |
| POST/PUT/DELETE | `/discipline`, `/discipline/{id}`                    | Création / modification / suppression | Authentifié |
| GET             | `/nationality`, `/nationality/{id}`                  | Consultation des nationalités         | Public      |
| POST/PUT/DELETE | `/nationality`, `/nationality/{id}`                  | Création / modification / suppression | Authentifié |
| GET             | `/athlete`, `/athlete/{id}`                          | Consultation des athlètes             | Public      |
| POST/PUT/DELETE | `/athlete`, `/athlete/{id}`                          | Création / modification / suppression | Authentifié |
| GET             | `/event`, `/event/{id}`                              | Consultation des épreuves             | Public      |
| POST/PUT/DELETE | `/event`, `/event/{id}`                              | Création / modification / suppression | Authentifié |
| GET             | `/finalresult`, `/finalresult/{eventId}/{athleteId}` | Consultation des résultats            | Public      |
| POST/PUT/DELETE | `/finalresult`, `/finalresult/{eventId}/{athleteId}` | Création / modification / suppression | Authentifié |

Toutes les routes de création/modification valident les données entrantes via Bean Validation (DTO dédiés) avant tout traitement.

## Tests

Tests unitaires (Mockito + JUnit) sur la logique métier des services, couvrant création et gestion des cas d'erreur (ressource introuvable). Actuellement en place sur `AthleteService` et `DisciplineService` ; extension aux autres services en cours.

## Configuration locale

Ce projet se connecte à une base PostgreSQL hébergée sur Supabase via le connection pooler (port 6543, compatible IPv4).

1. Copier `application.properties.example` en `application.properties`
2. Renseigner les informations de connexion à votre propre base Supabase (host, username, password) et une clé JWT (`jwt.key`)
3. Lancer avec :

```bash
mvn spring-boot:run
```

L'application démarre sur `http://localhost:8080`.

## À venir

- Application effective des rôles `USER` / `ADMIN` dans les règles d'autorisation (actuellement : authentifié ou non, sans distinction de rôle)
- Extension des tests unitaires aux services restants, ajout de tests d'intégration (`@SpringBootTest`, `MockMvc`)
- Endpoint d'inscription utilisateur (hashage du mot de passe côté serveur)
- Déploiement en production (backend + frontend React)
