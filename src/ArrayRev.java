import java.util.Arrays;

public class ArrayRev {

  public static void main(String[] args) {

    int[] randomArray;
    int[] numberArray = new int[10];

    randomArray = new int[20];
    randomArray[1] = 2;

    String[] stringArray = {"Houston", "Astros", "Champs"};

    for(int i = 0; i < numberArray.length; i++){
      numberArray[i] = i;
    }

    int k = 1;
    while (k <= 41){
      System.out.print('-');
      k++;
    }
    System.out.println();

    for (int j = 0; j < numberArray.length; j++){
      System.out.print("| " + j + " ");
    }
    System.out.println("|");

    String[][] multiArray = new String[10][10];

    for (int i = 0; i < multiArray.length; i++){
      for (int j = 0; j < multiArray[i].length; j++){
        multiArray[i][j] = i + " " + j;
      }
    }

    k = 1;
    while (k <= 61){
      System.out.print('-');
      k++;
    }
    System.out.println();


    for (int i = 0; i < multiArray.length; i++){
      for (int j = 0; j < multiArray[i].length; j++){
        System.out.print("| " + multiArray[i][j] + " ");
      }
      System.out.println();
    }

    k = 1;
    while (k <= 61){
      System.out.print('-');
      k++;
    }
    System.out.println();


    for (int row : numberArray){
      System.out.print(row);
    }
    System.out.println("\n");

    for (String[] rows : multiArray){
      for (String column : rows){
        System.out.print("| " + column + " ");
      }
      System.out.println(" | ");
    }

    int[] numberCopy = Arrays.copyOf(numberArray, numberArray.length);
    for (int row : numberCopy){
      System.out.print(row);
    }
    System.out.println("\n");

    System.out.println(Arrays.equals(numberArray, numberCopy));

    System.out.println(Arrays.toString(numberCopy));
  }
}
