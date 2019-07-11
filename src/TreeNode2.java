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

  public int size(){ return size; }

  public int data(){ return data; }

  public TreeNode2 find(int d){
    if(d == data){
      return this;
    } else if(d <= data){
      return left != null ? left.find(d) : null;
    } else {
      return right != null ? right.find(d) : null;
    }
  }
}
