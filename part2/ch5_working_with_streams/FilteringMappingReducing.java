package part2.ch5_working_with_streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FilteringMappingReducing {
    public static void main(String[] args) {

        // 5.1 Filtering
        // The stream interface supports a filter method. This operation takes as argument
        // a predicate (a function returning a boolean) and returns a stream including all elements
        // that match the predicate.
        // Streams also support a method called distinct that returns a stream with unique elements.

        // This example filters all even numbers from a list and eliminates the duplicates.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 2, 6, 7, 4, 9, 5);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);

        // 5.3 Mapping
        // Using the flatMap method has the effect of mapping each array not with a stream but
        // with the contents of that stream. All the separate streams that were generated when using
        // map(Arrays::stream) get amalgamated--flattend into a single stream.

        // This code returns a list of all the unique characters for a list of words.
        List<String> words = Arrays.asList("Hello", "World");
        List<String> uniqueChars =
                words.stream()
                        .map(word -> word.split(""))
                        .flatMap(Arrays::stream)
                        .distinct()
                        .collect(Collectors.toList());
        System.out.println(uniqueChars);

        // 5.5 Reducing
        // Idea: combine elements of a stream to express more complicated queries such as "calculate the sum of ...?"
        // or "what is the highest ...?" using the reduce operation.
        // example: calculate the sum of numbers
        // int sum = 0;
        // for (int x : numbers) {
        //   sum += x;
        // }
        // reduce the list of numbers into one number by repeatedly using addition (and initial value is 0).
        numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println("sum = " + sum);
        // reduce takes two arguments:
        // - an initial value, here 0
        // - a BinaryOperator<T> to combine two elements and produce a new value, here use the lambda (a, b) -> a + b
        // variant without initial value:
        Optional<Integer> optsum = numbers.stream().reduce((a, b) -> a + b);
        System.out.println("optsum = " + optsum);
        // this returns an optional considering the case the stream contains no elements.

        // another examples: product of numbers, maximum or minimum of numbers
        int product = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println("product = " + product);
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        System.out.println("max = " + max);
        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        System.out.println("min = " + min);
    }

}
