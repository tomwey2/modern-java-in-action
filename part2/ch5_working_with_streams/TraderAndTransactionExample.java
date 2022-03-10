package part2.ch5_working_with_streams;

import part2.data.Constants;
import part2.data.Trader;
import part2.data.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TraderAndTransactionExample {
    // 5.6 Putting it all into practice
    public static void main(String[] args) {
        // Finds all transactions in 2011 and sort by value (small to high)
        List<Transaction> tr2011 = Constants.transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println(tr2011);

        // What are the unique cities where the traders work?
        List<String> cities = Constants.transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(cities);

        // Finds all traders from Cambridge ans sort them by name
        List<Trader> tradersInCambridge = Constants.transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println(tradersInCambridge);

        // Returns a string of all traders' names sorted alphabetically
        String traderStr = Constants.transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1.isBlank() ? n1 + n2 : n1 + ", " + n2);
        System.out.println(traderStr);
        // variant
        String traderStr2 = Constants.transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining());
        System.out.println(traderStr2);

        // Are any traders based in Milan?
        boolean milanBased = Constants.transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println(milanBased);

        // What is the highest value of all the transactions
        Optional<Integer> highestValue = Constants.transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println(highestValue);
    }

}
