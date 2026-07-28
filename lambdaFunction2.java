
import java.util.function.Function;

public class lambdaFunction2 {

    public static void main(String[] args) {
        // Functional Composition 
        // 1) addThen()
        // 2) compose()

        Function<Integer, Integer> equation = (x) -> ((x + 2) * 2);
        // System.out.println(equation.apply(3));

        Function<Integer, Integer> Fx = x -> x + 2; //f(x)
        Function<Integer, Integer> Gx = x -> x * 2; //g(x)
        Function<Integer, Integer> Hx = x -> x / 2; //h(x)

        //g(f(x));
        int x = Fx.apply(3);
        int ans = Gx.apply(x);
        System.out.println(ans);

        //or we can do like 
        int ans2 = Gx.apply(Fx.apply(3));
        System.out.println(ans2);

        //Instead making chaining fo the same 
        //Let's use functional composition 
        //1) andThen();
        int ans3 = Fx.andThen(Gx).andThen(Hx).apply(3);
        System.out.println(ans3);
        // Squentailal flow first -> second -> third ->...->apply
    }
}
