package present;

import present.candy.Candy;
import java.util.ArrayList;
import java.util.List;

public class Present {
    private List<Candy> present;

    public Present() {
        present = new ArrayList<Candy>();
    }

    /**
     * Adds candy to the present.
     * @param candy candy of any type
     */
    public void addCandy(Candy candy) {
        present.add(candy);
    }

    /**
     * Calculates total weight of present.
     * @return total present weight
     */
    public double getTotalWeight() {
        double weight = 0;
        for (Candy candy: present) {
            weight += candy.getWeight();
        }
        return weight;
    }

    /**
     * Calculates total cost of present.
     * @return total present cost
     */
    public double getTotalCost() {
        double cost = 0;
        for (Candy candy: present) {
            cost += candy.getPrice();
        }
        return cost;
    }

    /**
     * Summarizes information about all candies in present.
     * @return present information
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("New Year present:");
        for (Candy candy: present) {
            stringBuilder.append("\n").append(candy.toString());
        }
        return stringBuilder.toString();
    }
}
