package present.candy;

public class Chocolate extends Candy {
    private String filling;

    public Chocolate(String name, double weight, double price, String filling) {
        super(name, weight, price);
        this.filling = filling;
    }

    public String getFilling() {
        return filling;
    }

    public void setFilling(String filling) {
        this.filling = filling;
    }

    @Override
    public String toString() {
        return String.format("%s, filling: %s",super.toString(), filling);
    }
}
