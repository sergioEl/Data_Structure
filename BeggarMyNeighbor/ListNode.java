// Node in a linked list.
public class ListNode {

	// The item stored in this node.
	private Card item;

	// The node following this one.
	private ListNode next;

	// Put item in a node with no next node.
	public ListNode(Card item) {
		this.item = item;
		next = null;
	}

	// Put item in a node with the specified next node.
	public ListNode(Card item, ListNode next) {
		this.item = item;
		this.next = next;
	}

	// Return the item stored in this node.
	public Card getItem() {
		return item;
	}

	// Return the next node.
	public ListNode getNext() {
		return next;
	}

	// Replace the item stored in this node.
	public void setItem(Card item) {
		this.item = item;
	}

	// Set the next node.
	public void setNext(ListNode next) {
		this.next = next;
	}
}
