package present.candy;

public class Toffee extends Candy {
    private String flavor;

    public Toffee(String name, double weight, double price, String flavor) {
        super(name, weight, price);
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public String toString() {
        return String.format("%s, flavor: %s",super.toString(), flavor);
    }
}
