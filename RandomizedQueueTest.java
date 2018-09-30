package a02;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RandomizedQueueTest
{
	RandomizedQueue<Integer> testQueue = new RandomizedQueue<>();

	@BeforeEach
	void setUp() throws Exception
	{
	}

	@Test
	void testRandomizedQueue()
	{
		RandomizedQueue<Integer> testConstructor = new RandomizedQueue<>();
		assertTrue(testConstructor.size() == 0);
	}

	@Test
	void testIsEmpty()
	{
		assertTrue(testQueue.isEmpty());
		testQueue.enqueue(15);
		assertFalse(testQueue.isEmpty());
	}

	@Test
	void testSize()
	{
		assertTrue(testQueue.size() == 0);
		testQueue.enqueue(15);
		testQueue.enqueue(14);
		testQueue.enqueue(15);
		testQueue.enqueue(14);
		testQueue.enqueue(12);
		assertTrue(testQueue.size() == 5);
		testQueue.dequeue();
		testQueue.dequeue();
		assertTrue(testQueue.size() == 3);
	}

	@Test
	void testEnqueue()
	{
		testQueue.enqueue(1);
		testQueue.enqueue(1);
		testQueue.enqueue(1);
		testQueue.enqueue(1);
		assertTrue(testQueue.size() == 4);
	}

	@Test
	void testDequeue()
	{
		testQueue.enqueue(1);
		testQueue.enqueue(1);
		testQueue.enqueue(1);
		testQueue.enqueue(1);
		testQueue.dequeue();
		testQueue.dequeue();
		assertTrue(testQueue.size() == 2);
	}

	@Test
	void testSample()
	{
		testQueue.enqueue(1);
		testQueue.enqueue(2);
		testQueue.enqueue(3);
		testQueue.enqueue(4);
		testQueue.enqueue(5);
		testQueue.enqueue(6);
		testQueue.enqueue(7);
		testQueue.enqueue(8);
		assertTrue(testQueue.size() == 8);
		assertTrue(testQueue.sample() >= 1 && testQueue.sample() <= 8);
		assertTrue(testQueue.size() == 8);
	}
}
