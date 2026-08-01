
import java.util.ArrayList;
import java.util.List;

public class ParallelSreamsOps {

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(1, 2, 4, 5, 6, 7, 8, 9));

        // //Sequqencial Streams
        // nums.stream()
        //         .forEach(System.out::println);
        //Parallel streams
        nums.parallelStream()
                .map(x -> x * 2)
                .forEachOrdered(System.out::println);
    }
}
