package part2.ch5_working_with_streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BuildingStreams {
    // 5.8.5 Streams from functions: creating infinite streams!
    public static void main(String[] args) {
        // the iterate method takes an initial value and a lambda (of type UnaryOperator<T>)
        // to apply successively in each new value produce
        // The iterate operation is fundamentally sequential because the result depends on
        // the previous application.
        // It's generally sensible to use limit(n) on such streams to avoid printing an infinitive
        // number of values.

        // This example produces a stream of all even numbers.
        List<Integer> numbers = Stream.iterate(0, n -> n + 1)
                .limit(5)
                .collect(Collectors.toList());
        System.out.println(numbers);

        // This function generate the first 10 fibonacci numbers. It generates first a sequence of
        // tuples that represents a pair (n-1, n-1 + n-2).
        // [0, 1], [1, 1], [1, 2], [2, 3], [3, 5] ...
        // then apply a map function to select the first value of the pairs.
        System.out.println("Fibonacci:");
        Stream.iterate(new int[]{0, 1},
                t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);

        // Similarly to iterate, the method generate produces an infinite stream of values captured on demand.
        // But generate does not apply successively a function on each new produced value. It takes a lambda
        // of type Supplier<T> to provide new values.

        // This functions generates 5 random numbers
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }
}
