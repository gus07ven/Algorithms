import java.util.ArrayList;
import java.util.List;

public class Leet103 {

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> lists = new ArrayList<>();
    zzLevelOrderHelper(root, lists, 0);
    return zzListBuilder(lists);
  }

}
