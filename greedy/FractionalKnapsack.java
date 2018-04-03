package greedy;

import java.util.Arrays;

public class FractionalKnapsack {

  public static void maina(String[] args) {
    // TODO Auto-generated method stub
    double capacity = 134;
    int itemCount = 9;
    int[][] items = {
        // price, weight
        {12, 14},
        {45, 54},
        {98, 78},
        {21, 51},
        {64, 11},
        {90, 117},
        {33, 17},
        {64, 23},
        {7, 3}
    };
    double totalPrice = 0;
    
    Arrays.sort(items, (a, b) -> (b[0] / b[1]) - (a[0] / a[1]));
    
    for (int i = 0; i < itemCount; i++) {
      double price = items[i][0];
      double weight = items[i][1];
      double pricePerWeight = price / weight;
      double weightToSubstractFromCapacity = Double.min(capacity, weight);
      
      totalPrice += weightToSubstractFromCapacity * pricePerWeight;
      capacity -= weightToSubstractFromCapacity;
      double percentage = (weightToSubstractFromCapacity / weight) * 100;
      
      System.out.println(String.format("Take %s%% of item with price %.2f and weight %.2f", weightToSubstractFromCapacity == weight ? "100" : String.format("%.2f", percentage) + "", price, weight));
      
      if (capacity <= 0) break;
    }
    
    System.out.println("Total price: " + String.format("%.2f", totalPrice));
  }

}
