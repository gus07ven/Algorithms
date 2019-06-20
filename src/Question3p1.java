import sun.invoke.empty.Empty;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class Question3p1 {

  static class FixedMultiStack {

    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public FixedMultiStack(int stackSize){
      stackCapacity = stackSize;
      values = new int[stackSize * numberOfStacks];
      sizes = new int[numberOfStacks];
    }

    public void push(int stackNum, int value) throws StackOverflowError{
      if(isFull(stackNum)){
        throw new StackOverflowError();
      }
      sizes[stackNum]++;
      values[indexOfTop(stackNum)] = value;
    }

    public int pop(int stackNum){
      if(isEmpty(stackNum)){
        throw new EmptyStackException();
      }
      int topIndex = indexOfTop(stackNum);
      int value = values[topIndex];
      values[topIndex] = 0;
      sizes[stackNum]--;
      return value;
    }

    public int peek(int stackNum){
      if(isEmpty(stackNum)){
        throw new EmptyStackException();
      }
      return values[indexOfTop(stackNum)];
    }

    public boolean isEmpty(int stackNum){
      return sizes[stackNum] == 0;
    }

    public boolean isFull(int stackNum){
      return sizes[stackNum] == stackCapacity;
    }

    private int indexOfTop(int stackNum){
      int offset = stackNum * stackCapacity;
      int size = sizes[stackNum];
      return offset + size - 1;
    }
  }

  static class FlexibleMultiStack {

    private SLinkedList.Node[] arrayOfStacks = new SLinkedList.Node[3];

    public FlexibleMultiStack(){
      arrayOfStacks[0] = null;
      arrayOfStacks[1] = null;
      arrayOfStacks[2] = null;
    }

    public void push(int stackNumber, int value){
      if(stackNumber < 0 || stackNumber > 2) throw new NoSuchElementException("Use stack numbers 0-2");

      if(isEmpty(stackNumber)) {
        SLinkedList.Node node = new SLinkedList.Node(value);
        arrayOfStacks[stackNumber] = node;
      } else {
        SLinkedList.Node top = arrayOfStacks[stackNumber];
        SLinkedList.Node newTop = new SLinkedList.Node(value);
        newTop.next = top;
        top = newTop;
        arrayOfStacks[stackNumber] = top;
      }
    }

    public int pop(int stackNumber){
      if(stackNumber < 0 || stackNumber > 2) throw new NoSuchElementException("Use stack numbers 0-2");

      if(isEmpty(stackNumber)) throw new EmptyStackException();

      SLinkedList.Node top = arrayOfStacks[stackNumber];
      int value = top.data;
      SLinkedList.Node newTop = top.next;
      top = newTop;
      arrayOfStacks[stackNumber] = top;
      return value;
    }

    public int peek(int stackNumber){
      if(stackNumber < 0 || stackNumber > 2) throw new NoSuchElementException("Use stack numbers 0-2");

      if(isEmpty(stackNumber)) throw new EmptyStackException();

      SLinkedList.Node top = arrayOfStacks[stackNumber];
      return top.data;
    }

    public boolean isEmpty(int stackNumber){
      return arrayOfStacks[stackNumber] == null;
    }
  }

  public static void main(String[] args) {
//    Question3p1.FixedMultiStack ms = new Question3p1.FixedMultiStack(3);
//    ms.push(1, 1);
//    ms.push(1, 11);
//    ms.push(1, 111);
//    ms.push(2, 2);
//    ms.push(2, 22);
//    ms.push(2, 222);
//    ms.push(0, 3);
//    ms.push(0, 33);
//    ms.push(0, 333);

    Question3p1.FlexibleMultiStack fs = new Question3p1.FlexibleMultiStack();
    fs.push(0, 1);
    fs.push(0, 2);
    fs.push(0, 3);
    fs.push(1, 10);
    fs.push(1, 11);
    fs.push(1, 12);
    fs.push(2, 20);
    fs.push(2, 21);
    fs.push(2, 22);
    fs.push(2, 23);
    fs.push(2, 24);
    System.out.println(fs.pop(0));
    System.out.println(fs.pop(0));
    System.out.println(fs.pop(2));
    System.out.println(fs.pop(1));
    System.out.println(fs.peek(0));
    System.out.println(fs.peek(1));
    System.out.println(fs.peek(2));
    System.out.println(fs.pop(0));
    System.out.println(fs.pop(0));
  }
}
