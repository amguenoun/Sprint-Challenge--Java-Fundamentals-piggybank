package bank;

public class Penny extends Currency {
    private static String name = "Penny";
    private static double value = 0.01;

    public Penny(int quantity) {
        super(name, value, quantity);
    }

    public Penny() {
        super(name, value, 1);
    }

    @Override
    public String toString() {
        if (quantity == 1) {
            return quantity + " " + name;
        } else {
            return quantity + " " + "Pennies";
        }
    }
}