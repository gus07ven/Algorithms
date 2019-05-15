public class SLinkedList {

  Node head;

  static class Node{

    int data;
    Node next;

    public Node(int d){
      data = d;
    }
  }

  public void printList(){
    Node n = head;
    while(n != null){
      System.out.println(n.data);
      n = n.next;
    }
  }

  public static void main(String[] args) {
    SLinkedList sll = new SLinkedList();

    sll.head = new Node(1);
    Node two = new Node(2);
    Node three = new Node(3);

    sll.head.next = two;
    two.next = three;

    sll.printList();
  }
}
