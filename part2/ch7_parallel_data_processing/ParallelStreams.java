package part2.ch7_parallel_data_processing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStreams {
    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(0L, Long::sum);
    }

    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    public static void main(String[] args) {
        // It's possible to turn a collection into a parallel stream by invoking the method parallelStream
        // on the collection source. A parallel stream is a stream that splits its elements into multiple chunks,
        // processing each chunk with a different thread.
        long now = 0;
        long value = 0;
        List<Long> ns = Stream.iterate(1L, n -> n * 10).limit(10).collect(Collectors.toList());
        System.out.println(ns);
        for (long n : ns) {
            System.out.print(String.format("n=%10d Sequentiel: time=", n));
            now = System.currentTimeMillis();
            value = sequentialSum(n);
            long stop1 = System.currentTimeMillis() - now;
            System.out.print(String.format("%5d ms parallel: time=", stop1));

            now = System.currentTimeMillis();
            value = sequentialSum(n);
            long stop2 = System.currentTimeMillis() - now;
            System.out.println(String.format("%5d ms", stop2));

        }

    }
}
