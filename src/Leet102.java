import java.util.ArrayList;
import java.util.List;

public class Leet102 {


  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> levels = new ArrayList<>();
    traverseLevel(root, levels, 0);
    return levels;
  }

  public void traverseLevel(TreeNode root, List<List<Integer>> levels, int level){
    if(root == null) return;
    if(level >= levels.size()){
      levels.add(level, new ArrayList<>());
    }
    levels.get(level).add(root.data);
    traverseLevel(root.left, levels, level + 1);
    traverseLevel(root.right, levels, level + 1);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.insert(9);
    root.insert(20);
    root.insert(15);
    root.insert(7);
    root.printInOrder();

    Leet102 leet = new Leet102();
    List<List<Integer>> result = leet.levelOrder(root);
    System.out.println();

  }
}
