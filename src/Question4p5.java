import java.util.ArrayList;

public class Question4p5 {

  public static boolean isBST(TreeNode root){
    ArrayList<Integer> values = new ArrayList<>();
    getValuesArray(root, values);
    return isBST(values);
  }

  public static void getValuesArray(TreeNode root, ArrayList<Integer> values ){
    if(root.left != null){
      getValuesArray(root.left, values);
    }
    values.add(root.data);
    if(root.right != null){
      getValuesArray(root.right, values);
    }
  }

  private static boolean isBST(ArrayList<Integer> values){
    for(int i = 1; i < values.size(); i++){
      if(values.get(i) < values.get(i - 1)){
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {

    TreeNode root = new TreeNode(17);
    root.insert(10);
    root.right = new TreeNode(3);
    root.insert(5);
    root.insert(7);
    root.insert(2);
    System.out.println("Print in order");
    root.printInOrder();

    System.out.println("Is the tree a BST? " + isBST(root));

  }
}
