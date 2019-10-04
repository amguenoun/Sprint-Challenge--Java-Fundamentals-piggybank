package bank;

public class Quarter extends Currency {
    private static String name = "Quarter";
    private static double value = 0.25;

    public Quarter(int quantity) {
        super(name, value, quantity);
    }

    public Quarter() {
        super(name, value, 1);
    }
}