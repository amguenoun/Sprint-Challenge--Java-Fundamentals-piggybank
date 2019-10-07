package bank;

public class Nickel extends Currency {
    private static String name = "Nickel";
    private static double value = 0.05;

    public Nickel(int quantity) {
        super(name, value, quantity);
    }

    public Nickel() {
        super(name, value, 1);
    }
}