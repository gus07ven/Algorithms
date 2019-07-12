import java.util.ArrayList;
import java.util.List;

public class Leet103 {

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> lists = new ArrayList<>();
    zzLevelOrderHelper(root, lists, 0);
    return lists;
  }

  public void zzLevelOrderHelper(TreeNode root, List<List<Integer>> lists, int level){
    if(root == null) return;
    if(level >= lists.size()){
      List<Integer> curLevelList = new ArrayList<>();
      curLevelList.add(root.data);
      lists.add(level, curLevelList);
    } else {
      lists.get(level).add(root.data);
    }
    zzLevelOrderHelper(root.left, lists, level + 1);
    zzLevelOrderHelper(root.right, lists, level + 1);
  }

}
