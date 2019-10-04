package bank;

public class Dime extends Currency {
    private static String name = "Dime";
    private static double value = 0.10;

    public Dime(int quantity) {
        super(name, value, quantity);
    }

    public Dime() {
        super(name, value, 1);
    }
}