
public class generic {

    public static void main(String[] args) {

        //Firstly implementing the generic problems
        // Box a = new Box(20);
        // Box b = new Box("Nikhil");
        // Box c = new Box(true);
        // //DownCasting as Java don't know the variable type in compile time so can't perform ops
        // Integer x = (Integer) a.getValue();
        // String y = (String) b.getValue();
        // Boolean z = (Boolean) c.getValue();
        // System.out.println(x + 2);
        // System.out.println(y + 2);
        // System.out.println(!z);
        // This is the problem , generic solves , currently we are type casting the object data in specify type , but at the time of user input or file input or network input we might face some issues or chances are there we might get run time error, So to prevent that we use generic 
        //Solution is Type argument Generic implementation 
        Box<Integer> x = new Box<>(10);
        Box<String> y = new Box<>("Nikkssy");
        Box<Boolean> z = new Box<>(true);

        // String h = (String) x.getValue(); // now we will get the exception on the compile time it self 
        System.out.println(x.getValue() + 2);
        System.out.println(y.getValue() + 2);
        System.out.println(!z.getValue());

        // Generic methdos 
        Pair.printPair(10, "Nikhil");  // Type inferences;

        // Generic Bounding Type --Upper bound
        Box2<Double> num = new Box2<>(30.4);
        Box2<Integer> num1 = new Box2<>(33);
        Box2<Byte> num2 = new Box2<>((byte) 3);
        Box2<Long> num3 = new Box2<>((long) 333);

        // But can set to String Boolean
        // Box2<String> str = new Box2<>("Hello");
        // Box2<Boolean> bool = new Box2<>(true);
        //
        // 
        // Class Example 
        Details<Fish> f1 = new Details(new Fish());
        // Details<Dog> f1 = new Details(new Dog()); this will cause issue;

    }
}

// class Box {
//     private Object value;
//     public Box(Object value) {
//         this.value = value;
//     }
//     public Object getValue() {
//         return this.value;
//     }
// }
//Generic 
class Box<T> {

    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

}

class Pair<T, U> {

    private T a;
    private U b;

    public Pair(T a, U b) {
        this.a = a;
        this.b = b;
    }

    public static <T, U> void printPair(T a, U b) {
        System.out.println(a + " , " + b);
    }

}

class Box2<T extends Number> {

    private T value;

    public Box2(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }
}

// Upper bound class example
class Details<T extends Animal & Swimmable> {

    T value;

    public Details(T value) {
        this.value = value;
    }

}

class Animal {

    void display() {
        System.out.println("Displaying an animal");
    }
}

class Dog extends Animal {

    void name() {
        System.out.println("My Name is Dog");
    }
}

interface Swimmable {

    void swim();
}

class Fish extends Animal implements Swimmable {

    @Override
    public void swim() {
        System.out.println("Whooopp swim");
    }

    void name() {
        System.out.println("My Name is fish");
    }
}
