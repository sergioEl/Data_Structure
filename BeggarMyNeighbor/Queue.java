// A first-in, first-out queue of Objects.
public interface Queue<E> {

	// Add target to the back of this Queue.
	public void add(E target);
	
	// Return true if the Queue is empty.
	public boolean isEmpty();
	
	/*
	 * Remove and return the front item from this Queue.
	 * @throws EmptyStructureException if the Queue is empty.
	 */
	public E remove();
	
	public E peek();
	
	public int size();
}

