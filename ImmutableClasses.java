
import java.util.Objects;

public class ImmutableClasses {

    public static void main(String[] args) throws CloneNotSupportedException {

        College c1 = new College("IIT b", "Bombay");

        Student s1 = new Student("Nikhil", 22, c1);

        System.out.println(s1.getCol().name);
        s1.getCol().name = "IIT D";

        System.out.println(s1.getCol().name);

        College col2 = new College("Nikhil", "India");

        //Object Class
        //COre methods first : toString();
        // System.out.println(col2.toString());
        // or
        System.out.println(col2);

        // Type 2 :- equals();
        // System.out.println(col2.equals(c1));
        // System.out.println(col2.equals(col2));
        Integer i = 9;
        // System.out.println(col2.equals(i));
        // System.out.println(col2.equals(i));
        System.out.println(col2.equals(null));

        //Type 3 :- hashcode();   // will be always equal if the to objects equals is true
        College c2 = new College("IIT b", "Bombay");
        System.out.println(c1.equals(c2));
        System.out.println(c1.hashCode() == c2.hashCode()); //false cause the equals method is overrided;
        //So let's override the hashCode function 

        System.out.println(c2.getClass().getName());
        System.out.println(c1 instanceof College);
        System.out.println(c1 instanceof Object);

        //Type 5 clone()
        College c3 = (College) c1.clone();
        System.out.println(c3.toString());

    }
}

//(Not purely immutable yet)... 
//Immutable creation 
// add a defensive copy of college (non primitive)..
final class Student {

    private final String name;
    private final int age;
    private final College col;

    public Student(String name, int age, College col) {
        this.name = name;
        this.age = age;
        // this.col = col; // will not store dirrectly instead we will create a new Object.
        this.col = new College(col.name, col.location);
    }

    String getName() {
        return this.name;
    }

    int getAge() {
        return this.age;
    }

    College getCol() {
        // return this.col; // won't return the same object reference , instead we will return the new object reference
        return new College(this.col.name, this.col.location);
    }

}

class College implements Cloneable {

    String name;
    String location;

    public College(String name, String location) {
        this.name = name;
        this.location = location;
    }

    @Override
    public String toString() {
        return name + " " + location;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        College col = (College) obj;
        if (this.name == col.name && this.location == col.location) {
            return true;
        }

        return false;

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
