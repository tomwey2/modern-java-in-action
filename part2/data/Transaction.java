package part2.data;

import part2.data.Trader;

public class Transaction {
    public final Trader trader;
    public final int year;
    public final int value;
    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "{" +
                "trader=" + trader +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}
