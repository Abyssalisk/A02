package a02;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DequeTest
{
	Deque<Integer> testDeque = new Deque<>();

	@BeforeEach
	void setUp() throws Exception
	{
	}

	@Test
	void testDeque()
	{
		Deque<Integer> testConstructor = new Deque<>();
		assertTrue(testConstructor.size() == 0);
	}

	@Test
	void testIsEmpty()
	{
		assertTrue(testDeque.isEmpty());
		testDeque.addFirst(15);
		assertFalse(testDeque.isEmpty());
	}

	@Test
	void testIsEmptyDestroyed()
	{
		assertTrue(testDeque.isEmpty());
		testDeque.addFirst(15);
		assertFalse(testDeque.isEmpty());
		testDeque.addFirst(15);
		testDeque.addFirst(14);
		testDeque.addFirst(15);
		testDeque.removeLast();
		testDeque.removeLast();
		testDeque.removeLast();
		testDeque.removeLast();
		assertTrue(testDeque.isEmpty());
	}

	@Test
	void testSize()
	{
		assertTrue(testDeque.size() == 0);
		testDeque.addFirst(15);
		testDeque.addFirst(14);
		testDeque.addFirst(15);
		testDeque.addFirst(14);
		testDeque.addFirst(12);
		assertTrue(testDeque.size() == 5);
		testDeque.removeLast();
		testDeque.removeLast();
		assertTrue(testDeque.size() == 3);
	}

	@Test
	void testAddFirst()
	{
		testDeque.addFirst(7);
		testDeque.addLast(8);
		testDeque.addFirst(11);
		testDeque.addLast(9);
		assertTrue(testDeque.removeFirst() == 11);
	}

	@Test
	void testAddLast()
	{
		testDeque.addFirst(7);
		testDeque.addLast(8);
		testDeque.addFirst(11);
		testDeque.addLast(9);
		assertTrue(testDeque.removeLast() == 9);
	}

	@Test
	void testRemoveFirst()
	{
		testDeque.addFirst(7);
		testDeque.addFirst(8);
		testDeque.addFirst(13);
		testDeque.addLast(9);
		assertTrue(testDeque.removeFirst() == 13);
	}

	@Test
	void testRemoveLast()
	{
		testDeque.addFirst(7);
		testDeque.addLast(8);
		testDeque.addLast(11);
		testDeque.addFirst(9);
		assertTrue(testDeque.removeLast() == 11);
	}

}
