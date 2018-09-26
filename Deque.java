package a02;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author Gavin Rosenvall & Khoi Tran
 *
 * @param <Item>
 */
public class Deque<Item> implements Iterable<Item>
{

	private Node head;
	private Node tail;
	private int n; // number of words in the list

	/**
	 * Node of LinkedList that stores the item and references to the next and
	 * previous node.
	 */
	private class Node
	{
		private Item item;
		private Node next;
		private Node previous;
	}

	/**
	 * Constructs an empty deque.
	 */
	public Deque()
	{
		n = 0;
		head = null;
		tail = null;
	}

	/**
	 * Checks whether the deque is empty.
	 * 
	 * @return
	 */
	public boolean isEmpty()
	{
		if (n == 0)
		{
			return true;
		} else
			return false;
	}

	/**
	 * Returns the number of items in the deque.
	 * 
	 * @return
	 */
	public int size()
	{
		return n;
	}

	/**
	 * Inserts the item included in the arguments to the front.
	 * 
	 * @param item
	 */
	public void addFirst(Item item)
	{
		checkNullPointerException(item);
		Node newNode = new Node();
		newNode.item = item;

		if (isEmpty())
		{
			createNewDeque(newNode);
		} else
		{
			head.previous = newNode;
			newNode.next = head;
			newNode.previous = null;
			head = newNode;
		}
		n++;
	}

	/**
	 * Inserts the item included on the arguments at the end.
	 * 
	 * @param item
	 */
	public void addLast(Item item)
	{
		checkNullPointerException(item);
		Node newNode = new Node();
		newNode.item = item;

		if (isEmpty())
		{
			createNewDeque(newNode);
		} else
		{
			tail.next = newNode;
			newNode.previous = tail;
			newNode.next = null;
			tail = newNode;
		}
		n++;
	}

	/**
	 * Deletes the item at the front.
	 * 
	 * @return
	 */
	public Item removeFirst()
	{
		checkNoSuchElementException();
		Item removedItem = head.item;
		if (n == 1)
		{
			destroyDeque();
		} else
		{
			head = head.next;
			head.previous = null;
		}
		n--;
		return removedItem;
	}

	/**
	 * Deletes the item at the end.
	 * 
	 * @return
	 */
	public Item removeLast()
	{
		checkNoSuchElementException();
		Item removedItem = tail.item;
		if (n == 1)
		{
			destroyDeque();
		} else
		{
			tail = tail.previous;
			tail.next = null;
		}
		n--;
		return removedItem;
	}

	/**
	 * Returns an iterator over items in order from front to end. Throws an
	 * UnsupportedOperationException if client tries to remove. Throws a
	 * NoSuchElementException if the next node is null.
	 * 
	 * @return
	 */
	public Iterator<Item> iterator()
	{
		return new DequeIterator();
	}

	private class DequeIterator implements Iterator<Item>
	{
		private Node current = head;

		@Override
		public boolean hasNext()
		{
			return current != null;
		}

		@Override
		public Item next()
		{
			if (!hasNext())
			{
				throw new NoSuchElementException();
			}
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove()
		{
			throw new UnsupportedOperationException();
		}

	}

	// Added these private methods to avoid code duplication.

	/**
	 * Checks the value of the introduced item to see whether it is null. If so,
	 * it throws a null pointer exception.
	 * 
	 * @param item
	 */
	private void checkNullPointerException(Item item)
	{
		if (item == null)
		{
			throw new NullPointerException("The item's value can not be null.");
		}
	}

	/**
	 * Checks if the deque has any elements to remove and/or iterate. If empty,
	 * it throws a no such element exception.
	 */
	private void checkNoSuchElementException()
	{
		if (isEmpty())
		{
			throw new NoSuchElementException("There are no elements in the deque to remove");
		}
	}

	/**
	 * Assigns the head and tail values to the newly created node and makes all
	 * links null.
	 * 
	 * @param newNode
	 */
	private void createNewDeque(Node newNode)
	{
		head = newNode;
		tail = newNode;
		head.previous = null;
		head.next = null;
		tail.previous = null;
		tail.next = null;
	}

	/**
	 * Removes all of the values linked to the last remaining node as well as
	 * the value of the node itself. This is to prevent any loitering data.
	 */
	private void destroyDeque()
	{
		head = null;
		head.next = null;
		head.previous = null;
		tail = null;
		tail.next = null;
		tail.previous = null;
	}

	public static void main(String[] args)
	{

	}

}
