package bank;

public class Dollar extends Currency {
    private static String name = "Dollar";
    private static double value = 1.00;

    public Dollar(int quantity) {
        super(name, value, quantity);
    }

    public Dollar() {
        super(name, value, 1);
    }
}