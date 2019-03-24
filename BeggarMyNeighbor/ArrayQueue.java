public class ArrayQueue {

  private Card[] data;

  private int front;

  private int size;

  private int penalty;

  public ArrayQueue() {
    data = new Card[1];
    size = 0;
    front = 0;
    penalty = 0;
  }

  public void add(Card target) {
    if (isFull()) {
      stretch();
    }
    data[(front + size) % data.length] = target;
    size++;
    if (target.getRank() > Card.TEN) penalty++;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  protected boolean isFull() {
    return size == data.length;
  }

  public Card peek() {
    if (isEmpty()) {
      throw new EmptyStructureException();
    }
    Card result = data[(front + size -1) % data.length];
    return result;
  }

  public Card remove() {
    if (isEmpty()) {
      throw new EmptyStructureException();
    }
    Card result = data[front];
    front = (front + 1) % data.length;
    size--;
    if (result.getRank() > Card.TEN) penalty--;
    return result;
  }

  protected void stretch() {
    Card[] newData = new Card[data.length * 2];
    for (int i = 0; i < data.length; i++) {
      newData[i] = data[(front + i) % data.length];
    }
    data = newData;
    front = 0;
  }

  public int getSize() {
     return size;
  }

  public int getPenalty() {
     return penalty;
  }

}

