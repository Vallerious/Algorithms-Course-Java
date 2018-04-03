package combinations;

import java.util.HashSet;
import java.util.Scanner;

public class Snake {
  static String[] snake;
  static HashSet<String> takenCells = new HashSet<>();
  static HashSet<String> results = new HashSet<>();
  static HashSet<String> snakeVariations = new HashSet<>();

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner snanner = new Scanner(System.in);
    snake = new String[snanner.nextInt()];
    generate(0, 0, 0, "S");
    
    for (String snake : results) {
      System.out.println(snake);
    }
    
    System.out.println("Snakes count = " + results.size());
  }
  
  public static void generate(int index, int row, int col, String direction) {
    if (index >= snake.length) {
      String snakeString = String.join("", snake);
      if (!snakeVariations.contains(snakeString)) {
        results.add(snakeString);

        String[] normal = snake;
        String[] flipped = flip(snake);
        String[] reversed = reverse(snake);
        String[] reversedFlipped = flipReverse(snake);
  
        for (int i = 0; i < 4; i++) {
          snakeVariations.add(String.join("", normal));
          normal = rotate(normal);
          snakeVariations.add(String.join("", flipped));
          flipped = rotate(flipped);
          snakeVariations.add(String.join("", reversed));
          reversed = rotate(reversed);
          snakeVariations.add(String.join("", reversedFlipped));
          reversedFlipped = rotate(reversedFlipped);
        }
      }
    } else {
      String currentPosition = row + " " + col;
      if (!takenCells.contains(currentPosition)) {
        snake[index] = direction;
        
        takenCells.add(currentPosition);
        
        generate(index + 1, row, col + 1, "R");
        generate(index + 1, row + 1, col, "D");
        generate(index + 1, row, col - 1, "L");
        generate(index + 1, row - 1, col, "U");
        
        takenCells.remove(currentPosition);
      }
    }
  }

  private static String[] rotate(String[] snake2) {
String[] newSnake = new String[snake2.length];
    
    for (int i = 0; i < snake2.length; i++) {
      switch (snake2[i]) {
      case "R":
        newSnake[i] = "D";
        break;
      case "D":
        newSnake[i] = "L";
        break;
      case "L":
        newSnake[i] = "U";
        break;
      case "U":
        newSnake[i] = "R";
        break;
      default:
        newSnake[i] = snake2[i];
        break;
      }
    }
    
    return newSnake;
  }

  private static String[] flipReverse(String[] snake2) {
    return flip(reverse(snake2));
  }

  private static String[] reverse(String[] snake2) {
    String[] newSnake = new String[snake2.length];
    
    newSnake[0] = "S";
    
    for (int i = 1; i < snake2.length; i++) {
      switch (snake2[i]) {
      default:
        newSnake[snake2.length - i] = snake2[i];
        break;
      }
    }
    
    return newSnake;
  }

  private static String[] flip(String[] snake2) {
    String[] newSnake = new String[snake2.length];
    
    for (int i = 0; i < snake2.length; i++) {
      switch (snake2[i]) {
      case "U":
        newSnake[i] = "D";
        break;
      case "D":
        newSnake[i] = "U";
        break;
      default:
        newSnake[i] = snake2[i];
        break;
      }
    }
    
    return newSnake;
  }

}
