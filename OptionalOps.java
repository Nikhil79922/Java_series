
import java.util.Optional;

public class OptionalOps {

    public static void main(String[] args) {
        // Optional<String> name = getName();
        // // System.out.println(name.get());  // unsafe 
        // System.out.println(name.isPresent()); // presence check 

        // name.ifPresent(System.out::println);
        // System.out.println(name.orElse("Unknown"));
        // System.out.println(name.orElseGet(() -> "Unknown supplier return response  "));
        // // System.out.println(name.orElseThrow());  // throw an java.util.NoSuchElementException
        // name.ifPresentOrElse(System.out::println, () -> System.out.println("A runnable method invoked"));
        //Transformation functions 
        // 1) Map 
        Optional<User> uo = getName();
        uo.map(x -> x.address)
                .map(y -> y.city)
                .ifPresent(System.out::println);

    }

    private static Optional<User> getName() {
        // return Optional.ofNullable(null);
        // return Optional.ofNullable("Nikhil");
        Address a = new Address();
        a.city = "Dhanbad";
        User u = new User();
        u.address = a;
        return Optional.of(u);

    }
}

class User {

    public Address address;
}

class Address {

    public String city;
}
