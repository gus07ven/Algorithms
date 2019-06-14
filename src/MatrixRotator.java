public class MatrixRotator {

  static boolean rotate(int[][] matrix){
    if(matrix.length == 0 || matrix.length != matrix[0].length) return false;
    int n = matrix.length;
    for(int layer = 0; layer < n/2; layer++){
      int first = layer;
      int last = n - 1 - layer;
      for(int i = first; i < last; i++){
        int offset = i - first;
        int top = matrix[first][i];

        // left -> top
        matrix[first][i] = matrix[last - offset][first];

        // bottom -> left
        matrix[last - offset][first] = matrix[last][last - offset];

        // right -> bottom
        matrix[last][last - offset] = matrix[i][last];

        // top -> right
        matrix[i][last] = top;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int[][] m = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
            // {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    rotate(m);

    for(int i = 0; i < m.length; i++){
      System.out.println();
      for(int j = 0; j < m.length; j++){
        System.out.print(m[i][j]);
      }
  }
  }
}
