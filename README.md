# ClicAndRun

Plateforme de gestion et de suivi de competitions d'athletisme, construite de A a Z : modelisation de la base de donnees, API REST securisee en Java/Spring Boot, et interface React connectee en temps reel.

**Demo en ligne :** _a completer apres deploiement_
**Backend :** https://github.com/atteewf/clicandrun
**Frontend :** https://github.com/atteewf/clicandrun-front

---

## Le projet

ClicAndRun permet de consulter librement les competitions, epreuves, athletes et resultats d'athletisme, et propose un espace connecte (roles USER / ADMIN) pour la gestion complete des donnees : creation, modification et suppression de chaque ressource.

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

## Modele de donnees

7 entites : `Competition`, `Discipline`, `Event`, `Athlete`, `Nationality`, `FinalResult` (cle primaire composite event + athlete), `User` (lie optionnellement a un `Athlete`).

## Stack technique

### Backend

- Java 25, Spring Boot, Spring Data JPA
- Spring Security / JWT (roles USER / ADMIN)
- Bean Validation, DTO dedies
- PostgreSQL (Supabase)
- JUnit / Mockito
- Docker
- Swagger / OpenAPI

### Frontend

- React 19, TypeScript, Vite
- React Router (routes dynamiques)
- Context API (authentification JWT partagee)
- Tailwind CSS

## Fonctionnalites

- Consultation publique paginee : competitions, epreuves, athletes, resultats
- Fiches detail (competition, athlete) avec palmares filtre
- Authentification JWT : connexion, inscription (creation automatique d'un profil athlete)
- Persistance de session (localStorage)
- **Espace administration** : CRUD complet sur les 6 entites principales, protege par role ADMIN
- Recherche instantanee sur les listes

## Screenshot

### Page d'accueil
<img width="1313" height="898" alt="image" src="https://github.com/user-attachments/assets/6eed4e0c-1f2b-4f76-b1a7-fbf33083a294" />

### Détail d'une compétition
<img width="942" height="782" alt="image" src="https://github.com/user-attachments/assets/4da47bb9-4631-4d0a-a235-e58e480ea9b2" />

### Dashboard admin
<img width="939" height="738" alt="image" src="https://github.com/user-attachments/assets/0321390c-38df-4206-b433-19b3e1655a06" />

### Fiche athlète
<img width="574" height="494" alt="image" src="https://github.com/user-attachments/assets/72c2cc66-4400-401c-a146-61b52fb2cfbb" />




## Lancer le projet en local

Le backend et le frontend sont deux depots separes, a lancer en parallele.

### 1. Backend

```bash
git clone https://github.com/atteewf/clicandrun.git
cd clicandrun
# copier application.properties.example en application.properties
# renseigner la connexion Supabase et une cle JWT
mvn spring-boot:run
```

Demarre sur `http://localhost:8080`. Documentation interactive sur `http://localhost:8080/swagger-ui/index.html`.

### 2. Frontend

```bash
git clone https://github.com/atteewf/clicandrun-front.git
cd clicandrun-front
npm install
echo "VITE_API_URL=http://localhost:8080" > .env
npm run dev
```

Demarre sur `http://localhost:5173`.

### 3. Avec Docker (backend uniquement)

```bash
mvn clean package
docker build -t clicandrun .
docker run -p 8080:8080 clicandrun
```

## Securite

- Mots de passe hashes en BCrypt
- Authentification stateless par JWT (le role est encode dans un claim `scope`)
- Routes en lecture (`GET`) publiques, ecriture (`POST` / `PUT` / `DELETE`) reservee au role ADMIN sur la plupart des ressources
- CORS configure pour n'autoriser que l'origine du frontend

## Tests

```bash
mvn test
```

Tests unitaires JUnit / Mockito sur la logique metier des services.

## A venir

- Deploiement en production (backend + frontend)
- Endpoint dedie pour la gestion des inscriptions/paiements a une competition
- Modification / suppression pour l'entite FinalResult depuis le dashboard admin
