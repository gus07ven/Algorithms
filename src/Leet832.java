public class Leet832 {

  private static int[][] flipAndInvertImage(int[][] A) {
    if(A.length == 0) return A;

    int[][] newImage = new int[A.length][A[0].length];

    for(int row = 0; row < A.length; row++){
      for(int column = 0; column < A[0].length; column++){
        if(A[row][column] == 0){
          newImage[row][(A[0].length - 1) - column] = 1;
        } else {
          newImage[row][(A[0].length - 1) - column] = 0;
        }
      }
    }
    return newImage;
  }

  public static void main(String[] args) {
    int[][] image = {{1,1,0,0}, {1,0,0,1}, {0,1,1,1}, {1,0,1,0}};
    System.out.println(flipAndInvertImage(image));
  }
}
