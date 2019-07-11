public class Question4p11 {

  public static void main(String[] args) {
   Tree tree = new Tree();
   tree.insertInOrder(17);
   tree.insertInOrder(10);
   tree.insertInOrder(23);
   tree.insertInOrder(5);
   tree.insertInOrder(29);
   tree.insertInOrder(2);

   System.out.println(tree.size());

    for(int i = 0; i < tree.size(); i++) {
      System.out.println(tree.getRandomNode().data());
    }
  }
}
