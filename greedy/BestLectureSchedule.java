package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BestLectureSchedule {
  static int totalLectures;
  static List<Lecture> lectures = new ArrayList<>();
  static List<Lecture> results = new ArrayList<>();
  static int lecturesVisited;

  public static void main(String[] args) {
    consumeInput();
    Collections.sort(lectures, new LectureEndTimeAscComparator());
    int lastPossibleStartingTime = -1;
    
    for (Lecture lecture : lectures) {
      if (lecture.startTime >= lastPossibleStartingTime) {
        results.add(lecture);
        lastPossibleStartingTime = lecture.endTime;
      }
    }
    
    System.out.println("Lectures (" + results.size() + "):");
    
    for (Lecture lecture : results) {
      System.out.println(String.format("%s-%s -> %s", lecture.startTime, lecture.endTime, lecture.name));
    }
  }
  
  public static void consumeInput() {
    Scanner scanner = new Scanner(System.in);
    
    totalLectures = Integer.parseInt(scanner.nextLine().split(" ")[1]);
    
    for (int i = 0; i < totalLectures; i++) {
      String[] params = scanner.nextLine().split(": ");
      String[] timeParams = params[1].split(" - ");
      int startTime = Integer.parseInt(timeParams[0]);
      int endTime = Integer.parseInt(timeParams[1]);
      
      lectures.add(new Lecture(params[0], startTime, endTime));
    }
  }
  
  private static class Lecture {
    public String name;
    public int startTime;
    public int endTime;
    
    public Lecture(String name, int startTime, int endTime) {
      this.name = name;
      this.startTime = startTime;
      this.endTime = endTime;
    }
  }
  
  private static class LectureEndTimeAscComparator implements Comparator<Lecture> {

    @Override
    public int compare(Lecture o1, Lecture o2) {
      return o1.endTime - o2.endTime;
    }
    
  }

}
