import sun.invoke.empty.Empty;

import java.util.EmptyStackException;

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

  public static void main(String[] args) {
    Question3p1.FixedMultiStack ms = new Question3p1.FixedMultiStack(3);
    ms.push(1, 1);
    ms.push(1, 11);
    ms.push(1, 111);
    ms.push(2, 2);
    ms.push(2, 22);
    ms.push(2, 222);
    ms.push(0, 3);
    ms.push(0, 33);
    ms.push(0, 333);

  }
}
