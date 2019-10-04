package bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.text.DecimalFormat;

public class Main {
    public static double total = 0;

    public static void main(String[] args) {
        DecimalFormat fp = new DecimalFormat("$###,###.00");

        ArrayList<Currency> piggyBank = new ArrayList<Currency>();
        piggyBank.add(new Quarter());
        piggyBank.add(new Dime());
        piggyBank.add(new Dollar(5));
        piggyBank.add(new Nickel(3));
        piggyBank.add(new Dime(7));
        piggyBank.add(new Dollar());
        piggyBank.add(new Penny(10));

        System.out.println("\n***INVENTORY***");
        piggyBank.forEach(c -> {
            total += c.getTotalValue();
            System.out.println(c);
        });

        System.out.println("\n***TOTAL VALUE***");
        System.out.println("The piggy bank holds $" + fp.format(total));
    }
}