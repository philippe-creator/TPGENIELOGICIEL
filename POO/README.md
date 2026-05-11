# TP POO - Programmation Orientée Objet en Java

## 📝 Description

Ce TP illustre les concepts fondamentaux de la Programmation Orientée Objet (POO) en Java à travers une simulation de zoo avec différents types d'animaux.

## 🎯 Objectifs Pédagogiques

- **Classes abstraites** : Comprendre la création de classes qui ne peuvent pas être instanciées directement
- **Héritage** : Implémenter des classes filles qui héritent des propriétés et méthodes d'une classe parente
- **Polymorphisme** : Utiliser des objets de différentes classes de manière uniforme
- **Surcharge de méthodes** : Ajouter des comportements spécifiques aux sous-classes

## 📂 Structure du Code

### Classes Implémentées

- **Animal** : Classe abstraite représentant un animal générique
  - Attribut : `nom` (String)
  - Méthode abstraite : `faireDuBruit()`

- **Mammifere** : Classe héritant d'Animal
  - Implémente `faireDuBruit()` pour grogner

- **Oiseau** : Classe héritant d'Animal
  - Implémente `faireDuBruit()` pour chanter
  - Méthode spécifique : `voler()`

- **Zoo** : Classe principale avec la méthode `main()`
  - Démonstration du polymorphisme

## 🚀 Compilation et Exécution

### Compilation
```bash
javac code.java
```

### Exécution
```bash
java Zoo
```

### Résultat Attendu
```
Tigre grogne.
Perroquet chante.
L'oiseau vole.
```

## 💡 Concepts Clés

### Classe Abstraite
La classe `Animal` est déclarée avec le mot-clé `abstract`, ce qui signifie qu'elle ne peut pas être instanciée directement. Elle sert de modèle pour les classes concrètes.

### Polymorphisme
Dans la classe `Zoo`, les objets `tigre` et `perroquet` sont déclarés de type `Animal` mais instanciés comme `Mammifere` et `Oiseau`. La méthode `faireDuBruit()` est appelée de manière polymorphique.

### Casting
L'opérateur `(Oiseau)` est utilisé pour accéder à la méthode spécifique `voler()` qui n'existe pas dans la classe parente `Animal`.

## 📄 Documentation

- **Rapport** : `rapport.pdf` - Rapport détaillé du TP avec explications des concepts

## 📚 Références

Ce TP couvre les chapitres sur :
- L'héritage en Java
- Les classes abstraites et interfaces
- Le polymorphisme
