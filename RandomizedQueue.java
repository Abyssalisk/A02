package a02;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

/**
 * 
 * @author Gavin Rosenvall & Khoi Tran
 *
 * @param <Item>
 */
public class RandomizedQueue<Item> implements Iterable<Item>
{
	private Item[] itemArray;
	private int n;

	/**
	 * Constructs an empty randomized queue.
	 */
	@SuppressWarnings("unchecked")
	public RandomizedQueue()
	{
		itemArray = (Item[]) new Object[2];
		n = 0;
	}

	/**
	 * Checks whether the queue is empty.
	 * 
	 * @return
	 */
	public boolean isEmpty()
	{
		return n == 0;

	}

	/**
	 * Returns the number of items in the queue.
	 * 
	 * @return
	 */
	public int size()
	{
		return n;

	}

	/**
	 * Adds the item in the arguments into the queue.
	 * 
	 * @param item
	 */
	public void enqueue(Item item)
	{
		if (itemArray == null)
		{
			throw new NullPointerException();
		}
		if (isStorageFull())
		{
			doubleSize();
		}

		itemArray[n++] = item;
	}

	/**
	 * Deletes and returns a random item.
	 * 
	 * @return
	 */
	public Item dequeue()
	{
		if (isEmpty())
		{
			throw new NoSuchElementException();
		}

		int random = StdRandom.uniform(n);
		Item returnItem = itemArray[random];
		n--;

		itemArray[random] = itemArray[n];
		itemArray[n] = null;

		if (isStorageOversized())
		{
			halveSize();
		}

		return returnItem;

	}

	/**
	 * Returns but does not delete a random item.
	 * 
	 * @return
	 */
	public Item sample()
	{
		if (isEmpty())
		{
			throw new NoSuchElementException();
		}

		int random = StdRandom.uniform(n);
		return itemArray[random];

	}

	/**
	 * Returns an independent iterator over items in random order.
	 */
	public Iterator<Item> iterator()
	{
		return new RandomizedQueueIterator();
	}

	private class RandomizedQueueIterator implements Iterator<Item>
	{
		private Item[] iteratorArray;
		private int length = n;

		@Override
		public boolean hasNext()
		{
			return n > 0;
		}

		@Override
		public Item next()
		{
			if (!hasNext())
			{
				throw new NoSuchElementException();
			} else
			{
				return iteratorArray[--length];
			}
		}

		@Override
		public void remove()
		{
			throw new UnsupportedOperationException();
		}

	}

	/**
	 * Resizes the array and matches the values with what was originally stored
	 * after the modification.
	 * 
	 * @param newSize
	 */
	private void resize(int newSize)
	{
		@SuppressWarnings("unchecked")
		Item[] newStorage = (Item[]) new Object[newSize];
		for (int i = 0; i < n; i++)
		{
			newStorage[i] = itemArray[i];
		}
		itemArray = newStorage;
	}

	/**
	 * Checks whether the array is full.
	 * 
	 * @return
	 */
	private boolean isStorageFull()
	{
		return itemArray.length == n;
	}

	/**
	 * Doubles the size of the array.
	 */
	private void doubleSize()
	{
		resize(itemArray.length * 2);
	}

	/**
	 * Checks whether the array is only using a quarter of the array size. This
	 * validates if the array is larger than it needs to be.
	 * 
	 * @return
	 */
	private boolean isStorageOversized()
	{
		return itemArray.length > 2 && n <= itemArray.length / 4;
	}

	/**
	 * Resizes the array to half of its' original length.
	 */
	private void halveSize()
	{
		resize(itemArray.length / 2);
	}

	/**
	 * Unit Testing
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		// See J unit Tests
	}

}
