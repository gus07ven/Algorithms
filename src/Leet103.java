import java.util.ArrayList;
import java.util.List;

public class Leet103 {

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> lists = new ArrayList<>();
    zzLevelOrderHelper(root, lists, 0);
    return zzListBuilder(lists);
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

  public List<List<Integer>> zzListBuilder(List<List<Integer>> lists){
    if(lists.size() == 0) return null;
    int levels = lists.size();
    int curLevel = 0;

    while(curLevel < levels){
      if(curLevel % 2 != 0) {
        List<Integer> curLevelList = lists.get(curLevel);
        List<Integer> reversedLevelList = new ArrayList<>();
        if (curLevelList.size() > 1) {
          for (int i = curLevelList.size(); i > 0; i--) {
            reversedLevelList.add(curLevelList.get(i - 1));
          }
          lists.remove(curLevel);
          lists.add(curLevel, reversedLevelList);
        }
      }
      curLevel++;
    }
    return lists;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.insert(3);
    root.insert(15);
    root.right.right = new TreeNode(7);
    root.printInOrder();

    Leet103 leet = new Leet103();
    List<List<Integer>> result = leet.zigzagLevelOrder(root);
    System.out.println();
  }
}
