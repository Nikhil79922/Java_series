
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class lambdaFunction {

    public static void main(String[] args) {
        // Computes c = new Addititon();
        Computes c = (a, b) -> a * b;
        printDetails(2, 5, c);

        List<Integer> ars = List.of(1, 2, 4, 5, 7, 98, 04, 35, 6);

        ars.forEach((x) -> System.out.println(x));

        //Types of Lambdas Functions 
// 1) Functions lambdas 
        Function<Integer, Integer> fun = x -> x * x;
        System.out.println(fun.apply(3));

// 2) Consumer 
        Consumer<Integer> consume = a -> {
            System.out.println(a);
        };
        consume.accept(69696969);

        List<Integer> arr = List.of(1, 2, 4, 5, 7, 8, 0, 9, 3);
        arr.forEach((x) -> System.out.print(x + " , "));

        ObjDoubleConsumer<Double> obd = (x, y) -> System.out.println("WhatsUp  " + x + " " + y);
        obd.accept(30.12, 33);

        // 3) Supplier 
        Supplier<Double> supply = () -> Math.random();
        System.out.println(supply.get());

        Supplier<Double> supply1 = () -> Subs.randoms();
        System.out.println("Method references" + supply1.get());

// 4) Predicate  
        Predicate<Integer> pred = (x) -> (x % 2 == 0);
        System.out.println(pred.test(20));
        System.out.println(pred.test(21));

    }

    static void printDetails(int a, int b, Computes c) {
        System.out.println(c.add(a, b));
    }
}

@FunctionalInterface
interface Computes {

    int add(int a, int b);
}

class Addititon implements Computes {

    @Override
    public int add(int a, int b) {
        return a + b;
    }
}

class Subs {

    static double randoms() {
        return Math.random();
    }

    double random() {
        return Math.random();
    }
}
