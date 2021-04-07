package present.candy;

public class Jellybean extends Candy {
    private String type;

    public Jellybean(String name, double weight, double price, String type) {
        super(name, weight, price);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("%s, type: %s",super.toString(), type);
    }
}
