package solving;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Solver {
  public static int[][] maxPrice;
  public static boolean[][] isItemTaken;
  

  public static void main(String[] args) {
    Item[] items = {
        new Item(null, 5, 30),
        new Item(null, 8, 120),
        new Item(null, 7, 10),
        new Item(null, 0, 20),
        new Item(null, 4, 50),
        new Item(null, 5, 80),
        new Item(null, 2, 10)
    };
    
    int knapsackCapacity = 20;
    
    Item[] itemsTakens = fillKnapsack(items, knapsackCapacity);
    
    System.out.println(maxPrice[items.length][knapsackCapacity]);
    
    int capacity = knapsackCapacity;
    ArrayList<Item> result = new ArrayList<Item>();
    
    for (int i = items.length - 1; i >= 0; i--) {
      if (capacity <= 0) break;
      if (isItemTaken[i + 1][capacity]) {
        result.add(items[i]);
        capacity -= items[i].weight;
      }
    }
    
    int totalWeight = 0;
    
    for (int i = 0; i < result.size(); i++) {
      totalWeight += result.get(i).weight;
    }
    
    System.out.println(totalWeight);
  }
  
  private static Item[] fillKnapsack(Item[] items, int knapsackCapacity) {
    maxPrice = new int[items.length + 1][knapsackCapacity + 1];
    isItemTaken = new boolean[items.length + 1][knapsackCapacity + 1];
    
    for (int i = 0; i < items.length; i++) {
      Item item = items[i];
      int rowIndex = i + 1;
      
      for (int capacity = 0; capacity <= knapsackCapacity; capacity++) {
        if (capacity < item.weight) continue;
        
        int excluding = maxPrice[rowIndex - 1][capacity];
        int including = maxPrice[rowIndex - 1][capacity - item.weight] + item.value;
        
        if (including > excluding) {
          maxPrice[rowIndex][capacity] = including;
          isItemTaken[rowIndex][capacity] = true;
        } else {
          maxPrice[rowIndex][capacity] = excluding;
        }
      }
    }
    
    return items;
  }

  public static class Item {
    public String name;
    public int weight;
    public int value;
    
    public Item(String name, int weight, int value) {
      this.name = name;
      this.weight = weight;
      this.value = value;
    }
  }
}
