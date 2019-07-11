import java.util.Random;

public class TreeNode2 {

  private int data;
  public TreeNode2 left;
  public TreeNode2 right;
  private int size = 0;

  public TreeNode2(int d){
    data = d;
    size = 1;
  }

  public TreeNode2 getRandomNode(){
    int leftSize = left == null ? 0 : left.size;
    Random random = new Random();
    int index = random.nextInt(size);
    if(index <  leftSize){
      return left.getRandomNode();
    } else if(index == leftSize){
      return this;
    } else {
      return right.getRandomNode();
    }
  }

  public void insertInOrder(int d){
    if(d <= data){
      if(left == null) {
        left = new TreeNode2(d);
      } else {
        left.insertInOrder(d);
      }
    } else {
      if(right == null) {
        right = new TreeNode2(d);
      } else {
        right.insertInOrder(d);
      }
    }
    size++;
  }

}
