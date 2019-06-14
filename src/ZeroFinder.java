import java.util.ArrayList;

public class ZeroFinder {

  static ArrayList<Integer> findZeros(int[][] matrix) {
    if(matrix.length == 0) return null;
    ArrayList<Integer> zeroPairs = new ArrayList<>();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == 0) {
          zeroPairs.add(i);
          zeroPairs.add(j);
        }
      }
    }
    return zeroPairs;
  }

  static void insertZeros(int[][] matrix, ArrayList<Integer> zeroPairs){
    int index = 0;
    for(Integer val : zeroPairs) {
      if(index % 2 == 0) {
        zeroRow(matrix, val);
        index++;
      } else {
        zeroColumn(matrix, val);
        index++;
      }
    }
  }

  static void zeroRow(int[][] matrix, int val){
    for(int i = 0; i < matrix[val].length; i++){
      matrix[val][i] = 0;
    }
  }

  static void zeroColumn(int[][] matrix, int val){
    for(int j = 0; j < matrix.length; j++){
      matrix[j][val] = 0;
    }
  }


  public static void main(String[] args) {

    int[][] nums = // {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
            {{1, 2, 3}, {4, 0, 6}, {7, 8 , 9}, {10, 11, 0, 9}};

    ArrayList<Integer> zeroPairs = findZeros(nums);
    insertZeros(nums, zeroPairs);
    }
}
