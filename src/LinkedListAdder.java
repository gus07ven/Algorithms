import java.util.ArrayList;

public class LinkedListAdder {

  static SLinkedList.Node sumReversedLinkedLists(SLinkedList.Node headOne, SLinkedList.Node headTwo){
    if(headOne == null && headTwo != null) return headTwo;
    if(headTwo == null && headOne != null) return headOne;
    if(headOne == null && headTwo == null) return null;

    int counterLLOne = 0;
    int counterLLTwo = 0;
    Stack<Integer> firstNumSt = new Stack<>();
    Stack<Integer> secondNumSt = new Stack<>();
    int[] firstNumArr;
    int[] secondNumArr;
    ArrayList<Integer> resultArrList = new ArrayList<>();

    // Get length of both lists and add element data (digit) to stack
    counterLLOne = getListLength(headOne, firstNumSt);
    counterLLTwo = getListLength(headTwo, secondNumSt);

    // Make stacks have equal number of digits by adding zeros to shortest stack
    addStackPadding(counterLLOne, counterLLTwo, firstNumSt, secondNumSt);

    // Create number arrays
    firstNumArr = new int[firstNumSt.size()];
    createNumArrays(firstNumArr, firstNumSt);
    secondNumArr = new int[secondNumSt.size()];
    createNumArrays(secondNumArr, secondNumSt);

    // Add individual digits from back to front of array
   resultArrList = addDigitsReverseOrder(firstNumArr, secondNumArr);

    // Create final LinkedList
    return createReversedLinkedList(resultArrList);
  }

  static int getListLength(SLinkedList.Node head, Stack<Integer> numSt){
    int counter = 0;
    while(head != null){
      counter++;
      pushToStack(head.data, numSt);
      head = head.next;
    }
    return counter;
  }

  static void pushToStack(int data, Stack<Integer> numSt){
    numSt.push(data);
  }

  static void addStackPadding(int counterLLOne, int counterLLTwo, Stack<Integer> firstNumSt, Stack<Integer> secondNumSt){
    if(counterLLOne < counterLLTwo){
      int diff = (counterLLTwo - counterLLOne);
      for(int i = 0; i < diff; i++){
        firstNumSt.push(0);
      }
    } else {
      int diff = (counterLLOne - counterLLTwo);
      for(int i = 0; i < diff; i++){
        secondNumSt.push(0);
      }
    }
  }

  static void createNumArrays(int[] numArray, Stack<Integer> numStack){
    for(int i = 0; i < numArray.length; i++){
      numArray[i] = numStack.pop();
    }
  }

  static ArrayList<Integer> addDigitsReverseOrder(int[] firstNumArr, int[] secondNumArr){
    int carryOver = 0;
    int firstDigit = 0;
    int total = 0;
    ArrayList<Integer> resultArr = new ArrayList<Integer>();
    for(int i = firstNumArr.length - 1; i >= 0; i--){
      total = firstNumArr[i] + secondNumArr[i] + carryOver;
      carryOver = 0;
      if(total > 9){
        firstDigit = total % 10;
        carryOver = total / 10;
        resultArr.add(firstDigit);
      } else {
        resultArr.add(total);
      }
    }
    if(carryOver != 0) resultArr.add(carryOver);
    return resultArr;
  }

  static SLinkedList.Node createReversedLinkedList(ArrayList<Integer> resultList){
    SLinkedList.Node finalList = null;
    SLinkedList.Node current = null;
    for(int i = 0; i < resultList.size(); i++){
      if(finalList == null) {
        finalList = new SLinkedList.Node(resultList.get(i));
      } else {
        current = finalList;
        while(current.next != null){
          current = current.next;
        }
        current.next = new SLinkedList.Node(resultList.get(i));
      }
    }
    return finalList;
  }

  public static void main(String[] args) {
    SLinkedList.Node head = new SLinkedList.Node(7);
    SLinkedList.Node node1 = new SLinkedList.Node(1);
    SLinkedList.Node node2 = new SLinkedList.Node(6);
//    SLinkedList.Node node3 = new SLinkedList.Node(3);
    head.next = node1;
    node1.next = node2;
//    node2.next = node3;

    SLinkedList.Node head2 = new SLinkedList.Node(5);
    SLinkedList.Node node4 = new SLinkedList.Node(9);
    SLinkedList.Node node5 = new SLinkedList.Node(2);
    SLinkedList.Node node6 = new SLinkedList.Node(8);

    head2.next = node4;
    node4.next = node5;
    node5.next = node6;

    SLinkedList sll = new SLinkedList();

    // Inputs are given in reverse order 7 -> 1 -> 6 = 617
    // Output will be in reverse order
    sll.head = sumReversedLinkedLists(head, head2);
    sll.printList();
  }
}
