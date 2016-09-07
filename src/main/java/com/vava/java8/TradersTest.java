package com.vava.java8;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by vasantas on 9/6/2016.
 */
public class TradersTest {
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario","Milan");
    Trader alan = new Trader("Alan","Cambridge");
    Trader brian = new Trader("Brian","Cambridge");

    List<Transaction>  transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    public static void main(String[] args) {
        TradersTest test = new TradersTest();
        //1. Find all transactions in the year 2011 and sort them by value (small to high).
        test.transactions.stream().filter(t -> t.getYear() > 2011).sorted(Comparator.comparing(Transaction::getValue)).forEach(System.out::println);


        //2.What are all the unique cities where the traders work?
        test.transactions.stream().map(Transaction::getTrader).map(Trader::getCity).distinct().forEach(System.out::println);

        //3.Find all traders from Cambridge and sort them by name
        test.transactions.stream().map(Transaction::getTrader).filter( t -> t.getCity().equals("Cambridge")).map(Trader::getName).sorted();

        //4.Return a string of all traders’ names sorted alphabetically
        test.transactions.stream().map(Transaction::getTrader).filter( t -> t.getCity().equals("Cambridge")).map(Trader::getName).sorted().reduce( (a,b) -> a +b).ifPresent(System.out::println);
        test.transactions.stream().map(Transaction::getTrader).filter( t -> t.getCity().equals("Cambridge")).map(Trader::getName).sorted().collect(Collectors.joining());

        //5. Are any traders based in Milan?
        test.transactions.stream().map(Transaction::getTrader).anyMatch( t -> t.getCity().equals("Milan") );

        //6. Print all transactions’ values from the traders living in Cambridge.
        test.transactions.stream().filter(t -> t.getTrader().getCity().equals("Cambridge")).forEach(System.out::println);

        //7. What’s the highest value of all the transactions?
        test.transactions.stream().map(Transaction::getValue).reduce(Math::max);

        //8. Find the transaction with the smallest value
        test.transactions.stream().reduce((a,b) -> a.getValue() > b.getValue() ? b :a);
    }
    public class Trader{

        private final String name;
        private final String city;

        public Trader(String n, String c){
            this.name = n;
            this.city = c;
        }

        public String getName(){
            return this.name;
        }

        public String getCity(){
            return this.city;
        }

        public String toString(){
            return "Trader:"+this.name + " in " + this.city;
        }
    }

    public class Transaction{

        private final Trader trader;
        private final int year;
        private final int value;

        public Transaction(Trader trader, int year, int value){
            this.trader = trader;
            this.year = year;
            this.value = value;
        }

        public Trader getTrader(){
            return this.trader;
        }

        public int getYear(){
            return this.year;
        }

        public int getValue(){
            return this.value;
        }

        public String toString(){
            return "{" + this.trader + ", " +
                    "year: "+this.year+", " +
                    "value:" + this.value +"}";
        }
    }
}

