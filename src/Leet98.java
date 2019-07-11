import java.util.ArrayList;

public class Leet98 {

  ArrayList<Integer> treeValues = new ArrayList<>();

  public boolean isValidBST(TreeNode root){
    getValues(root);
    return isBST(treeValues);
  }

  public void getValues(TreeNode root){
    if(root.left != null){
      getValues(root.left);
    }
    for(Integer i : treeValues){

    }
    treeValues.add(root.data);
    if(root.right != null){
      getValues(root.right);
    }
  }

  public boolean isBST(ArrayList<Integer> treeValues){
    if(treeValues.size() == 0) return true;

    for(int i = 1; i < treeValues.size(); i++){
     if(treeValues.get(i) < treeValues.get(i - 1)){
       return false;
     }
    }
    return true;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.right = new TreeNode(6);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(4);
    //    root.right.left = new TreeNode(7);
    //    root.right.right = new TreeNode(4);

    Leet98 leet = new Leet98();
    System.out.println(leet.isValidBST(root));
  }
}
