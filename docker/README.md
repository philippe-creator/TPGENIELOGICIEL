# TP Docker - Conteneurisation d'Application

## 📝 Description

Ce TP illustre la conteneurisation d'une application web multi-services en utilisant Docker et Docker Compose. L'architecture comprend un frontend, une base de données PostgreSQL, et une interface d'administration pgAdmin.

## 🎯 Objectifs Pédagogiques

- **Conteneurisation** : Comprendre les concepts de Docker et des conteneurs
- **Docker Compose** : Orchestration multi-conteneurs avec docker-compose.yml
- **Réseaux Docker** : Communication entre conteneurs via des réseaux personnalisés
- **Volumes Docker** : Persistance des données avec des volumes
- **Variables d'environnement** : Configuration des services via fichiers .env

## 📂 Structure du Projet

```
docker/
├── docker-compose.yml    # Fichier de configuration Docker Compose
├── docker tp.pdf         # Rapport détaillé du TP
├── backend/
│   └── db.env           # Variables d'environnement pour la base de données
└── frontend/
    ├── Dockerfile       # Configuration du conteneur frontend
    ├── .dockerignore    # Fichiers à ignorer lors du build
    └── index.html       # Page HTML de l'application
```

## 🏗️ Architecture

### Services

1. **Frontend** (Port 8080)
   - Image : nginx:alpine
   - Service web statique avec nginx
   - Expose le port 80 (mappé sur 8080 de l'hôte)

2. **Base de données PostgreSQL** (Port interne 5432)
   - Image : postgres:13
   - Base de données : `myapp`
   - Utilisateur : `admin`
   - Mot de passe : `adminpassword`
   - Volume persistant pour les données

3. **pgAdmin** (Port 5050)
   - Image : dpage/pgadmin4
   - Interface d'administration PostgreSQL
   - Email par défaut : `admin@admin.com`
   - Mot de passe par défaut : `admin`
   - Dépend du service de base de données

### Réseau
- **app-network** : Réseau Docker personnalisé pour la communication entre les services

## 🚀 Installation et Utilisation

### Prérequis
- Docker installé sur votre machine
- Docker Compose installé

### Démarrage des services
```bash
docker-compose up -d
```

### Arrêt des services
```bash
docker-compose down
```

### Voir les logs
```bash
docker-compose logs -f
```

### Arrêt et suppression des volumes
```bash
docker-compose down -v
```

## 🌐 Accès aux Services

Une fois les services démarrés, vous pouvez accéder à :

- **Frontend** : http://localhost:8080
- **pgAdmin** : http://localhost:5050
  - Email : `admin@admin.com`
  - Mot de passe : `admin`

## 🔧 Configuration

### Variables d'environnement (backend/db.env)
```env
POSTGRES_USER=admin
POSTGRES_PASSWORD=adminpassword
POSTGRES_DB=myapp
```

### Dockerfile (frontend/Dockerfile)
```dockerfile
FROM nginx:alpine
COPY index.html /usr/share/nginx/html/index.html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
```

## 📚 Concepts Clés

### Docker Compose
Permet de définir et exécuter plusieurs conteneurs Docker avec une seule commande. Le fichier `docker-compose.yml` décrit les services, les réseaux et les volumes.

### Volumes
Les volumes permettent de persister les données indépendamment du cycle de vie des conteneurs. Le volume `db-data` stocke les données PostgreSQL.

### Réseaux
Le réseau `app-network` permet aux conteneurs de communiquer entre eux en utilisant leurs noms de service comme noms d'hôte.

### Dépendances
Le service `pgAdmin` dépend du service `db`, ce qui garantit que la base de données est démarrée avant pgAdmin.

## 📄 Documentation

- **Rapport** : `docker tp.pdf` - Rapport détaillé du TP avec explications de l'architecture et des concepts Docker

## 🔍 Dépannage

### Vérifier l'état des conteneurs
```bash
docker-compose ps
```

### Accéder à un conteneur en cours d'exécution
```bash
docker-compose exec <service> sh
```

### Reconstruire les images
```bash
docker-compose build
```

### Supprimer tout (conteneurs, réseaux, volumes)
```bash
docker-compose down -v --rmi all
```
