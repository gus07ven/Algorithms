
public class DeleteMiddleNode {

  private static boolean deleteMiddleNode(SLinkedList.Node inputNode){
    if(inputNode == null || inputNode.next == null) return false;
    inputNode.data = inputNode.next.data;
    inputNode.next = inputNode.next.next;
    return true;
  }

  public static void main(String[] args) {
    SLinkedList.Node head = new SLinkedList.Node(7);
    SLinkedList.Node node1 = new SLinkedList.Node(3);
    SLinkedList.Node node2 = new SLinkedList.Node(5);
    SLinkedList.Node node3 = new SLinkedList.Node(1);
    SLinkedList.Node node4 = new SLinkedList.Node(6);
    SLinkedList.Node node5 = new SLinkedList.Node(12);
    SLinkedList.Node node6 = new SLinkedList.Node(8);

    head.next = node1;
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;

    System.out.println(deleteMiddleNode(head.next.next.next));
    SLinkedList sll = new SLinkedList();
    sll.head = head;
    sll.printList();
  }
}
