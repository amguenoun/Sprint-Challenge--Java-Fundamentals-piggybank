package bank;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static double total = 0;

    public static void main(String[] args) {
        ArrayList<Currency> piggyBank = new ArrayList<Currency>();
        piggyBank.add(new Quarter());
        piggyBank.add(new Dime());
        piggyBank.add(new Dollar(5));
        piggyBank.add(new Nickel(3));
        piggyBank.add(new Dime(7));
        piggyBank.add(new Dollar());
        piggyBank.add(new Penny(10));

        piggyBank.forEach(c -> {
            total += c.getTotalValue();
            System.out.println(c);
        });

        System.out.println("The piggy bank holds $" + total);
    }
}