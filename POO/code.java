// Classe abstraite Animal
abstract class Animal {
    private String nom;

    public Animal(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    // Méthode abstraite à implémenter dans les sous-classes
    public abstract void faireDuBruit();
}

// Classe Mammifere héritant d'Animal
class Mammifere extends Animal {
    public Mammifere(String nom) {
        super(nom);
    }

    @Override
    public void faireDuBruit() {
        System.out.println(getNom() + " grogne.");
    }
}

// Classe Oiseau héritant d'Animal
class Oiseau extends Animal {
    public Oiseau(String nom) {
        super(nom);
    }

    @Override
    public void faireDuBruit() {
        System.out.println(getNom() + " chante.");
    }

    // Complétons cette méthode pour ajouter un comportement unique aux oiseaux
    public void voler() {
        System.out.println("L'oiseau vole.");
    }
}

// Classe principale avec polymorphisme
public class Zoo {
    public static void main(String[] args) {
        Animal tigre = new Mammifere("Tigre");
        Animal perroquet = new Oiseau("Perroquet");

        tigre.faireDuBruit(); // Sortie attendue : "Tigre grogne."
        perroquet.faireDuBruit(); // Sortie attendue : "Perroquet chante."

        // Appel de la méthode voler sur l'objet perroquet
        ((Oiseau) perroquet).voler(); // Sortie attendue : "L'oiseau vole."
    }
}