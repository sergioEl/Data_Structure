public class ArrayStack<E> implements Stack<E> {

  private E[] data;

  private int size;

@SuppressWarnings("unchecked")
  public ArrayStack(){
    data = (E[])(new Object[1]);
    size = 0;
  }

//  To get size of StackArray
  public int getSize() {
    return size;
  }

  public boolean isEmpty(){
    return size == 0;
  }

  public E pop(){
    if(isEmpty()) {
      throw new EmptyStructureException();
    }
    size--;
       return data[size];
  }

  public E peek(){
    if(isEmpty()) {
      throw new EmptyStructureException();
    }
    return data[size-1];
  }

  protected boolean isFull(){
    return size == data.length;
  }

  public void push(E target) {
    if(isFull()) {
      stretch();
    }
    data[size] = target;
    size++;
  }

@SuppressWarnings("unchecked")
  protected void stretch(){
    E[] newData = (E[])(new Object[data.length * 2]);//C
    for(int i = 0 ; i < data.length ; i++) {
      newData[i] = data[i];
    }
    data = newData;
  }

}
