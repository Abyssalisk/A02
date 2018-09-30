package a02;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 
 * @author Gavin Rosenvall & Khoi Tran
 *
 */
public class Subset
{
	/**
	 * Reads in the input from the user. K is parsed to the integer that the
	 * user inputs. The rest of the strings are then added to an array and
	 * randomly removed back out and printed back k times.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		int k = Integer.parseInt(args[0]);
		RandomizedQueue<String> stringQueue = new RandomizedQueue<>();

		for (String el : StdIn.readAllStrings())
		{
			stringQueue.enqueue(el);
		}

		for (int i = 0; i < k; i++)
			StdOut.println(stringQueue.dequeue());
	}
}