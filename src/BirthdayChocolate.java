import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BirthdayChocolate {

  // Complete the birthday function below.
  static int birthday(List<Integer> squares, int day, int month) {
    int squaresSum = 0;
    int numSolutions = 0;

    for (int i = 0; i < squares.size(); i++) {
      int j = i;
      while (j <= (month - 1 + i) && j <= squares.size() - 1) {
        squaresSum += squares.get(j);
        j++;
      }
      if (squaresSum == day) {
        numSolutions++;
      }
      squaresSum = 0;
    }
    return numSolutions;
  }

  public static void main(String[] args) throws IOException {
    List<Integer> squares = new ArrayList<Integer>();
    squares.add(1);
    squares.add(2);
    squares.add(1);
    squares.add(3);
    squares.add(4);
    int day = 3;
    int month = 2;
    System.out.println(BirthdayChocolate.birthday(squares, day, month));
  }
}

