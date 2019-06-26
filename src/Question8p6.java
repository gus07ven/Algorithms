import javax.swing.*;
import java.util.ArrayList;

public class Question8p6 {

  public static String hanoi(int n, boolean left){
    if(n == 0) return " ";
    String move;
    if(left) move = n + "L";
    else move = n + "R";
    return hanoi(n - 1, !left) + move + hanoi(n - 1, !left);
  }

  public static void main(String[] args) {
    int n = 3;

//    System.out.println(hanoi(n, false));
    Tower[] towers = new Tower[n];
    for(int i = 0; i < 3; i++){
      towers[i] = new Tower(i);
    }

    for(int i = n - 1; i >= 0; i--){
      towers[0].add(i);
    }
    towers[0].moveDisks(n, towers[2], towers[1]);
    System.out.println(towers);
  }
}
