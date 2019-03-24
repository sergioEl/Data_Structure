// A linked queue.
public class LinkedQueue {

	// The front ListNode in the Queue.
	private ListNode front;

	// The back ListNode in the Queue.
	private ListNode back;

	private Card[] data;
	private int size;
	private int penalty;//Added

	// The Queue is initially empty.
	public LinkedQueue() {
		front = null;
		back = null;
		data = new Card[1];//C
		size = 0;
		penalty = 0;//Added
	}
	
	public void add(Card target) {
		if(target.getRank() > Card.TEN)
		  penalty++;//Added
		ListNode node = new ListNode(target);
		if(isEmpty()) {
			front = node;
			back = node;
			size++;
		} else {
			back.setNext(node);
			back = node;
			size++;
		}
//		if(target.getRank() > Card.TEN) penalty ++;//Added
	}
	
	public boolean isEmpty() {
		return front == null;
	}
	
	public Card remove() {
		if(isEmpty()) {
			throw new EmptyStructureException();
		}
		Card result = front.getItem();
		if(result.getRank() > Card.TEN) penalty--; //Added
		front = front.getNext();
		size--;
		return result;
	}

	public Card peek() {
		if(isEmpty()) {
			throw new EmptyStructureException();
		}
		return data[size - 1];
	}

	public int getSize() {//C
		return size;
	}

	//Added get numner of penalty cards
	public int getPenalty() {
		return penalty;
	}
}
