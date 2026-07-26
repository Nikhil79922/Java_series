
import java.util.ArrayList;
import java.util.List;

public class WildCards {

    public static void main(String[] args) {
        List<Dog2> dogs = new ArrayList<>();
        List<Animal2> animal = new ArrayList<>();

        printAnimal(animal); // This will be an error , SO that's why we use wildCards to fix the same

    }

    static void printAnimal(List<? super Animal2> list) {
        list.add(new Dog2());
        Object obj = list.get(0);

    }
}

class Animal2 {

    void eat() {
        System.out.println("Ghoop Ghoop");
    }

    void walk() {
        System.out.println("moving");
    }
}

class Dog2 extends Animal2 {

    void brak() {
        System.out.println("whoop whoop");
    }
}
