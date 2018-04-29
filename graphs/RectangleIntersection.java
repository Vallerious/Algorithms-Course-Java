package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RectangleIntersection {
  static class Rect implements Comparable<Rect> {
    int minX;
    int maxX;
    int minY;
    int maxY;
    
    public Rect(int minX, int maxX, int minY, int maxY) {
      this.minX = minX;
      this.maxY = maxY;
      this.maxX = maxX;
      this.minY = minY;
    }

    @Override
    public int compareTo(Rect o) {
      return this.minX - o.minX;
    }
    
    public String toString() {
      return "X: { " + this.minX + "-" + this.maxX + " }; Y: {" + this.minY + "-" + this.maxY + " }";
    }
  }
  
  static class Point
  {
      int x, y;
      
      public Point(int x, int y) {
        this.x = x;
        this.y = y;
      }
  };
  
  static List<Rect> rectangles = new ArrayList<>();

  public static void main(String[] args) {
    takeInput();
    Collections.sort(rectangles);
    int area = 0;
    
    for (int prevIdx = 0; prevIdx < rectangles.size() - 1; prevIdx++) {
      Rect prevRect = rectangles.get(prevIdx);
      
      for (int nextRectIdx = prevIdx + 1; nextRectIdx < rectangles.size(); nextRectIdx++) {
        Rect nextRect = rectangles.get(nextRectIdx);
        
        if (areRectanglesIntersecting(prevRect, nextRect)) {
          area += intersectionArea(prevRect, nextRect);
        }
      }
    }
    
    System.out.println(area);
  }
  
  private static boolean areRectanglesIntersecting(Rect prevRect, Rect nextRect) {
    if (nextRect.minX > prevRect.maxX ||
        nextRect.minY > prevRect.maxY ||
        prevRect.minX > nextRect.maxX ||
        prevRect.minY > nextRect.maxY) {
      return false;
    }
    
    return true;
  }
  
  static int intersectionArea(Rect prevRect, Rect nextRect) {
    int left = Math.max(prevRect.minX, nextRect.minX);
    int right = Math.min(prevRect.maxX, nextRect.maxX);
    int bottom = Math.max(prevRect.minY, nextRect.minY);
    int top = Math.min(prevRect.maxY, nextRect.maxY);
    
    return (right - left) * (top - bottom);
  }
  
  static boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {
 // If one rectangle is on left side of other
    if (l1.x > r2.x || l2.x > r1.x)
        return false;

    // If one rectangle is above other
    if (l1.y < r2.y || l2.y < r1.y)
        return false;

    return true;
  }

  public static void takeInput() {
    Scanner scanner = new Scanner(System.in);
    
    int n = Integer.parseInt(scanner.nextLine());
    
    for (int i = 0; i < n; i++) {
      String[] line = scanner.nextLine().split(" ");
      
      rectangles.add(new Rect(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2]), Integer.parseInt(line[3])));
    }
  }

}
