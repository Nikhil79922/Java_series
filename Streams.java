
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(List.of(1, 2, 45, 7, 2, 2, 3, 3, 2, 4, 4));

        //   1) filter 
        arr.stream()
                .filter(x -> x > 5)
                .forEach(System.out::println);

        // 2) Map 
        System.out.println("Map interminate function");
        arr.stream()
                .map(x -> x * 2)
                .forEach(System.out::println);

        //3) flatMap
        System.out.println("flat Map interminate function");
        List<List<Integer>> nestedArr = new ArrayList<>(
                List.of(
                        List.of(1, 2, 45),
                        List.of(1, 2, 45),
                        List.of(1, 2, 45)
                )
        );

        nestedArr.stream()
                .flatMap(x -> x.stream())
                .map(x -> x * 2)
                .forEach(System.out::println);

        //4) Sorted
        System.out.println("Sorted interminate function");
        // arr.stream()
        //         .filter(x -> x > 5)
        //         .map(x -> x * 2)
        //         .sorted() // can pass comparator as well 
        //         .forEach(System.out::println);

        arr.stream()
                .filter(x -> x > 5)
                .map(x -> x * 2)
                .sorted((a, b) -> b - a) // can pass comparator as well 
                .forEach(System.out::println);

        //5) Sorted
        System.out.println("Distinct interminate function");
        arr.stream()
                .filter(x -> x > 0)
                .distinct()
                .forEach(System.out::println);

        //6) Limit
        System.out.println("Limit interminate function");
        arr.stream()
                .filter(x -> x > 0)
                .limit(4)
                .forEach(System.out::println);

        //7) skip
        System.out.println("skip interminate function");
        arr.stream()
                .filter(x -> x > 0)
                .skip(6)
                .forEach(System.out::println);

        //Infinite stream
        System.out.println("Infinite stream function  -- Skip and Limit");
        Stream.iterate(1, x -> x + 1)
                .skip(3)
                .limit(9)
                .forEach(System.out::println);

        //7) Peek
        System.out.println("Peek interminate function");
        arr.stream()
                .filter(x -> x > 0)
                .peek(System.out::println)
                .filter(x -> x > 5)
                .map(x -> x * 2)
                .sorted((a, b) -> b - a)
                .forEach(System.out::println);

        System.out.println("----------------------------<Terminal  Operations>-----------------------------");

        // 1) forEach and forEachOrder 
        System.out.println(" forEach and forEachOrder Terminal function");
        arr.stream()
                .filter(x -> x > 0)
                .forEachOrdered(System.out::println);

        //2) toList 
        System.out.println(" toList Terminal function");
        List<Integer> list = arr.stream() // immutable list created
                .filter(x -> x > 2)
                .toList();

        System.out.println(list);

        //2) toList 
        System.out.println(" collect Terminal function");
        List<Integer> list2 = arr.stream() // mutable list created
                .filter(x -> x > 2)
                .collect(Collectors.toList());

        Set<Integer> set = arr.stream() // mutable list created
                .filter(x -> x > 2)
                .collect(Collectors.toSet());

        Map<Integer, Integer> frequency = arr.stream()
                .collect(Collectors.toMap(
                        x -> x, // key   Map Key 
                        x -> 1, // every occurrence starts with count 1 ;;; Map Value
                        Integer::sum // merge duplicate keys
                ));

        Map<Integer, List<Integer>> group = arr.stream()
                .collect(Collectors.groupingBy(x -> x)); // group based on ?

        Map<Boolean, List<Integer>> partitionBy = arr.stream()
                .collect(Collectors.partitioningBy(x -> x % 2 == 0));

        Map<Integer, Long> frequency2 = arr.stream()
                .collect(Collectors.groupingBy(
                        x -> x,
                        Collectors.counting()
                ));
        String joined = arr.stream()
                .map(String::valueOf)
                .collect(Collectors.joining("-"));

        System.out.println(list);
        System.out.println(set);
        System.out.println(frequency);
        System.out.println(frequency2);
        System.out.println(group);
        System.out.println(partitionBy);
        System.out.println(joined);

        //3) reduce
        System.out.println(" reduce Terminal function");
        Optional<Integer> val = arr.stream()
                .reduce((a, b) -> a + b);

        int sum = arr.stream()
                .reduce(1, (a, b) -> a + b);

        System.out.println(sum);
        System.out.println(val.get());

        //4) count
        System.out.println(" count Terminal function");

        long count = arr.stream()
                .filter(x -> x % 2 == 0)
                .count();

        System.out.println(count);

        //5) findFirst
        System.out.println(" findFirst Terminal function");
        Optional<Integer> val1 = arr.stream()
                .filter(x -> x % 2 == 0)
                .findFirst();
        System.out.println(val1.get());

        //6) findAny
        System.out.println(" findAny Terminal function");
        Optional<Integer> val2 = arr.stream()
                .filter(x -> x % 2 == 0)
                .findAny();
        System.out.println(val2.get());

        //7) findMatch
        System.out.println(" findMatch Terminal function");
        boolean val3 = arr.stream()
                .filter(x -> x % 2 == 0)
                .anyMatch(x -> x > 2);
        System.out.println(val3);

        //8) NoneMatch
        System.out.println(" NoneMatch Terminal function");
        boolean val4 = arr.stream()
                .filter(x -> x % 2 == 0)
                .noneMatch(x -> x < 2);
        System.out.println(val4);

        //9) allMatch
        System.out.println(" allMatch Terminal function");
        boolean val5 = arr.stream()
                .filter(x -> x % 2 == 0)
                .allMatch(x -> x >= 2);
        System.out.println(val5);

        //9) sum // work with primite steams 
        System.out.println(" sum Terminal function");
        int val6 = arr.stream()
                .filter(x -> x % 2 == 0)
                .mapToInt(x -> x)
                .sum();

        System.out.println(val6);

        //9) max // work with primite steams 
        System.out.println(" max Terminal function");
        OptionalInt val7 = arr.stream()
                .filter(x -> x % 2 == 0)
                .mapToInt(x -> x)
                .max();

        System.out.println(val7.getAsInt());

        //9) average  // work with primite steams 
        System.out.println(" average Terminal function");
        OptionalDouble val8 = arr.stream()
                .filter(x -> x % 2 == 0)
                .mapToInt(x -> x)
                .average();

        System.out.println(val8.getAsDouble());
    }
}
