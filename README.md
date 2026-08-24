# 🏃 ClicAndRun — API de gestion de courses à pied

> API REST développée en Java / Spring Boot, pour la gestion complète d'une plateforme de compétitions d'athlétisme (compétitions, épreuves, athlètes, résultats).

![Java](https://img.shields.io/badge/Java-25-orange?style=flat-square)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.0-brightgreen?style=flat-square)
![Spring Security](https://img.shields.io/badge/Spring%20Security-JWT-6DB33F?style=flat-square)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Supabase-336791?style=flat-square)
![Docker](https://img.shields.io/badge/Docker-ready-2496ED?style=flat-square)
![Deployed](https://img.shields.io/badge/Deployed-Render-46E3B7?style=flat-square)

## 🌐 En ligne

👉 **API :** [https://clicandrun.onrender.com](https://clicandrun.onrender.com)
👉 **Documentation Swagger :** [https://clicandrun.onrender.com/swagger-ui/index.html](https://clicandrun.onrender.com/swagger-ui/index.html)
👉 **Frontend associé :** [clicandrun-front](https://github.com/atteewf/clicandrun-front)

## 📸 Preview

<img width="796" height="667" alt="image" src="https://github.com/user-attachments/assets/4db25766-2960-4076-81f6-1d7881465e26" />


## 📋 Description

Un projet backend complet, démontrant :

- Architecture **Spring Boot** en couches (controller, service, repository, dto, model, config, exception)
- **Spring Data JPA** avec relations, clé primaire composite (`@EmbeddedId`), et optimisation N+1 via `@EntityGraph`
- **Spring Security / JWT** avec gestion des rôles `USER` / `ADMIN` par claim `scope`
- Validation des données via **Bean Validation** et DTO dédiés
- Gestion centralisée des erreurs (`@RestControllerAdvice`)
- **Tests unitaires** (JUnit / Mockito) isolés de la base de données
- **Conteneurisation Docker** (build multi-stage) et **déploiement en production**

Ce projet a été construit de A à Z dans le cadre d'une reconversion professionnelle, en autonomie, sans suivre de tutoriel pas à pas.

## Architecture generale

```
┌─────────────────────┐         REST / JSON          ┌──────────────────────┐
│   Frontend (React)   │  ─────────────────────────▶  │  Backend (Spring)     │
│   clicandrun-front    │  ◀─────────────────────────  │  clicandrun           │
└─────────────────────┘         JWT (Authorization)    └──────────────────────┘
                                                                  │
                                                                  ▼
                                                        ┌──────────────────────┐
                                                        │  PostgreSQL (Supabase)│
                                                        └──────────────────────┘
```

## ✨ Fonctionnalités

- 🏆 **Compétitions, épreuves, athlètes, résultats** : CRUD complet sur les 6 entités principales
- 🔐 **Authentification JWT** : connexion, inscription (avec création automatique d'un profil athlète)
- 👮 **Rôles** : lecture publique, écriture réservée aux administrateurs
- 📄 **Pagination** : toutes les listes exposées via `Pageable`
- 🌍 **Recherche par athlète** : endpoint dédié filtrant les résultats côté base (`/finalresult/athlete/{id}`)
- 📚 **Documentation interactive** : Swagger / OpenAPI
- 🧪 **Tests automatisés** : couverture de la logique métier

## ⚙️ Stack technique

| Technologie | Usage |
|---|---|
| Java 25 | Langage |
| Spring Boot 4.1.0 | Framework backend |
| Spring Data JPA / Hibernate | Persistance, ORM |
| Spring Security / JWT | Authentification, autorisation |
| Bean Validation | Validation des DTO |
| PostgreSQL (Supabase) | Base de données |
| JUnit / Mockito | Tests unitaires |
| Docker | Conteneurisation (build multi-stage) |
| Render | Déploiement |
| Swagger / OpenAPI | Documentation interactive |

## 📁 Structure du projet

```
src/main/java/com/ateew/clicandrun/
├── controller/   # Endpoints REST (@RestController)
├── service/      # Logique métier
├── repository/   # Interfaces JpaRepository, requêtes dérivées
├── model/        # Entités JPA (reflet des tables)
├── dto/          # Objets d'échange, validation d'entrée
├── config/       # Spring Security, JWT, CORS
├── exception/    # Exceptions custom + gestion centralisée
└── test/         # Tests unitaires JUnit / Mockito
```

## 🗃️ Modèle de données

7 entités liées entre elles :

| Entité | Description | Relations |
|---|---|---|
| `Competition` | Une compétition | — |
| `Discipline` | Une épreuve type (100m, marathon...) | — |
| `Nationality` | Une nationalité | — |
| `Athlete` | Un athlète | `@ManyToOne` → Nationality |
| `Event` | Une épreuve rattachée à une compétition | `@ManyToOne` → Competition, Discipline |
| `FinalResult` | Résultat d'un athlète sur une épreuve | `@ManyToOne` → Event, Athlete · clé composite |
| `User` | Compte utilisateur | `@OneToOne` → Athlete (optionnel) · rôle `USER`/`ADMIN` |

## 🔐 Sécurité

- Authentification par **JWT** (`JwtEncoder` / `JwtDecoder`)
- Mots de passe **hashés en BCrypt**
- Lecture (`GET`) publique, écriture (`POST`/`PUT`/`DELETE`) réservée au rôle `ADMIN`
- CORS restreint aux origines autorisées (frontend local + production)

## Screenshot

### Page d'accueil
<img width="1313" height="898" alt="image" src="https://github.com/user-attachments/assets/6eed4e0c-1f2b-4f76-b1a7-fbf33083a294" />

### Détail d'une compétition
<img width="942" height="782" alt="image" src="https://github.com/user-attachments/assets/4da47bb9-4631-4d0a-a235-e58e480ea9b2" />

### Dashboard admin
<img width="939" height="738" alt="image" src="https://github.com/user-attachments/assets/0321390c-38df-4206-b433-19b3e1655a06" />

### Fiche athlète
<img width="574" height="494" alt="image" src="https://github.com/user-attachments/assets/72c2cc66-4400-401c-a146-61b52fb2cfbb" />


## 🚀 Lancer le projet en local

```bash
git clone https://github.com/atteewf/clicandrun.git
cd clicandrun
# copier application.properties.example en application.properties
# renseigner la connexion Supabase et une cle JWT
mvn spring-boot:run
```

Démarre sur `http://localhost:8080`.

### Avec Docker

```bash
mvn clean package
docker build -t clicandrun .
docker run -p 8080:8080 clicandrun
```

## 🧪 Tests

```bash
mvn test
```

## 📌 À venir

- Endpoint `GET /users/me` pour permettre à un `USER` de saisir son propre résultat depuis le frontend
- Extension des tests unitaires aux services restants, tests d'intégration
- Modification / suppression pour `FinalResult` depuis le dashboard admin
- CI/CD (GitHub Actions)


