import sun.awt.image.ImageWatched;

import java.util.HashSet;

public class RemoveDuplicatesLL {

  static void removeDuplicate(SLinkedList.Node head){
    HashSet<Integer> values = new HashSet<>();
    SLinkedList.Node previous = null;

    while(head != null){
      if(values.contains(head.data)){
        previous.next = head.next;
      } else {
        values.add(head.data);
        previous = head;
      }
      head = head.next;
    }
  }

  public static void main(String[] args) {
    SLinkedList.Node head = new SLinkedList.Node(7);
    SLinkedList.Node node1 = new SLinkedList.Node(3);
    SLinkedList.Node node2 = new SLinkedList.Node(5);
    SLinkedList.Node node3 = new SLinkedList.Node(1);
    SLinkedList.Node node4 = new SLinkedList.Node(3);
    SLinkedList.Node node5 = new SLinkedList.Node(5);
    SLinkedList.Node node6 = new SLinkedList.Node(8);

    head.next = node1;
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;

    removeDuplicate(head);

    for(SLinkedList.Node i = head; i != null; i = i.next){
      System.out.print(i.data + " --> ");
    }
    System.out.println("null");
  }
}
