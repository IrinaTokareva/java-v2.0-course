import present.Present;
import present.candy.Candy;
import present.candy.Chocolate;
import present.candy.Jellybean;
import present.candy.Toffee;
import java.util.Random;

public class Task4_2 {

    public static void main(String[] args) {
        Present present = new Present();
        for (int i = 0; i < 3; i++) {
            int candyQuantity = new Random().nextInt(5) + 3;
            for (int j = 0; j < candyQuantity; j++) {
                present.addCandy(getCandy(i));
            }
        }
        System.out.println(present.toString() + "\n");
        System.out.printf("Total weight of present: %.1f g\n", present.getTotalWeight());
        System.out.printf("Total cost of present: %.2f rub\n", present.getTotalCost());
    }

    private static Candy getCandy(int i) {
        double weight = (new Random().nextInt(100) + 30) / 10.0;
        double price = (new Random().nextInt(40) + 20) / 10.0;
        switch (i) {
            case 0:
                return new Jellybean("jelly", weight, price, "bear");
            case 1:
                return new Toffee("toffee", weight, price, "original");
            default:
                return new Chocolate("choco", weight, price, "strawberry");
        }
    }
}
