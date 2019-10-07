package bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.text.DecimalFormat;

public class Main {
    public static double total = 0;

    public static ArrayList<Currency> paidList = new ArrayList<Currency>();

    public static void remove(HashMap<String, Integer> map, double value) {
        if (value > total) {
            System.out.println("Don't have the money.");
        } else {
            int dollars = map.get("Dollar");
            int quarters = map.get("Quarter");
            int dimes = map.get("Dime");
            int nickels = map.get("Nickel");
            int pennies = map.get("Penny");

            int v = (int) (value * 100);

            int vDollars = (v - (v % 100)) / 100;
            int vCents = (v % 100);

            while (vDollars > 0) {
                if (vDollars - 1 >= 0 && dollars > 0) {
                    vDollars -= 1;
                    dollars--;
                } else {
                    vCents += vDollars * 100;
                    break;
                }
            }

            while (vCents > 0) {
                if (vCents - 25 >= 0 && quarters > 0) {
                    vCents -= 25;
                    quarters--;
                } else if (vCents - 10 >= 0 && dimes > 0) {
                    vCents -= 10;
                    dimes--;
                } else if (vCents - 5 >= 0 && nickels > 0) {
                    vCents -= 5;
                    nickels--;
                } else if (vCents - 1 >= 0 && pennies > 0) {
                    vCents -= 1;
                    pennies--;
                } else {
                    break;
                }
            }

            paidList.add(new Dollar(dollars));
            paidList.add(new Quarter(quarters));
            paidList.add(new Dime(dimes));
            paidList.add(new Nickel(nickels));
            paidList.add(new Penny(pennies));

        }

    }

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
        System.out.println("The piggy bank holds " + fp.format(total));

        HashMap<String, Integer> piggyMap = new HashMap<String, Integer>();

        for (Currency c : piggyBank) {
            if (piggyMap.containsKey(c.getName())) {
                piggyMap.put(c.getName(), (piggyMap.get(c.getName()) + c.getQuantity()));
            } else {
                piggyMap.put(c.getName(), c.getQuantity());
            }
        }

        System.out.println("\n***REMOVE $6.98***");
        remove(piggyMap, 6.98);
        total = 0;
        paidList.forEach(c -> {
            total += c.getTotalValue();
            System.out.println(c);
        });
        System.out.println("\n***TOTAL VALUE***");
        System.out.println("The piggy bank holds " + fp.format(total));

    }
}