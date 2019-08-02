public class Question4p10 {

  public static boolean containsTree(TreeNode t1, TreeNode t2){
    if(t2 == null) return true;
    return subTree(t1, t2);
  }

  private static boolean subTree(TreeNode t1, TreeNode t2){
    if(t1 == null) return false;
    else if(t1.data == t2.data && matchTree(t1, t2)) return true;
    return subTree(t1.left, t2) || subTree(t1.right, t2);
  }

  private static boolean matchTree(TreeNode t1, TreeNode t2){
    if(t1 == null && t2 == null) return true;
    else if(t1 == null || t2 == null) return false;
    else if(t1.data != t2.data) return false;
    else return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
  }

  public static void main(String[] args) {
    TreeNode t1 = new TreeNode(17);
    t1.insert(10);
    t1.insert(23);
    t1.insert(5);
    t1.insert(7);
    t1.insert(2);

    TreeNode t2 = new TreeNode(5);
    t2.insert(7);
    t2.insert(2);

    System.out.println(containsTree(t1, t2));
  }
}
