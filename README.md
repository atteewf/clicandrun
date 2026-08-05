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
- Routes `GET` publiques sur les données à vocation publique : `competition`, `event`, `finalresult`, `discipline`
- Routes `GET` protégées (authentification requise) sur les données sensibles : `athlete`, `nationality`, `user`
- Routes `POST` / `PUT` / `DELETE` protégées, réservées au rôle `ADMIN`
- `POST /login` : échange identifiants (email + mot de passe) contre un token JWT
- Documentation interactive de l'API via **Swagger UI** (`/swagger-ui.html`), générée automatiquement avec springdoc-openapi

## Endpoints disponibles

| Méthode         | URL                                                  | Description                                                   | Accès               |
| --------------- | ---------------------------------------------------- | ------------------------------------------------------------- | ------------------- |
| POST            | `/login`                                             | Authentification, retourne un JWT                             | Public              |
| POST            | `/register`                                          | Inscription utilisateur                                       | Public              |
| GET             | `/competition`, `/competition/{id}`                  | Consultation des compétitions (pagination + filtre `year`)    | Public              |
| POST/PUT/DELETE | `/competition`, `/competition/{id}`                  | Création / modification / suppression                         | Authentifié (ADMIN) |
| GET             | `/discipline`, `/discipline/{id}`                    | Consultation des disciplines (pagination + filtre `distance`) | Public              |
| POST/PUT/DELETE | `/discipline`, `/discipline/{id}`                    | Création / modification / suppression                         | Authentifié (ADMIN) |
| GET             | `/nationality`, `/nationality/{id}`                  | Consultation des nationalités (pagination)                    | Authentifié         |
| POST/PUT/DELETE | `/nationality`, `/nationality/{id}`                  | Création / modification / suppression                         | Authentifié (ADMIN) |
| GET             | `/athlete`, `/athlete/{id}`                          | Consultation des athlètes (pagination + filtre)               | Authentifié         |
| POST/PUT/DELETE | `/athlete`, `/athlete/{id}`                          | Création / modification / suppression                         | Authentifié         |
| GET             | `/event`, `/event/{id}`                              | Consultation des épreuves (pagination)                        | Public              |
| POST/PUT/DELETE | `/event`, `/event/{id}`                              | Création / modification / suppression                         | Authentifié (ADMIN) |
| GET             | `/finalresult`, `/finalresult/{eventId}/{athleteId}` | Consultation des résultats (pagination)                       | Public              |
| POST/PUT/DELETE | `/finalresult`, `/finalresult/{eventId}/{athleteId}` | Création / modification / suppression                         | Authentifié         |

Toutes les routes de création/modification valident les données entrantes via Bean Validation (DTO dédiés) avant tout traitement.

## Pagination et filtres

Les endpoints de liste (`GET /event`, `/competition`, `/discipline`, `/nationality`, `/finalresult`) supportent la pagination Spring Data (`?page=0&size=20`), avec métadonnées de réponse (`totalElements`, `totalPages`, `first`, `last`).

Filtres disponibles, combinables avec la pagination :

- `GET /competition?year=2026` — filtre par année
- `GET /discipline?distance=100` — filtre par distance
- `GET /athlete?...` — filtre disponible sur les athlètes

## Tests

Tests unitaires (Mockito + JUnit) sur la logique métier des services, couvrant création, gestion des cas d'erreur (ressource introuvable), pagination et filtres. Couverture actuelle : `AthleteService`, `CompetitionService`, `DisciplineService`, `EventService`, `FinalResultService`, `NationalityService`.

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

- Extension des tests unitaires aux services restants, ajout de tests d'intégration (`@SpringBootTest`, `MockMvc`)
- Filtres supplémentaires (nationality, autres critères combinés)
- Endpoint d'inscription utilisateur (hashage du mot de passe côté serveur)
- Déploiement en production (backend + frontend React)
