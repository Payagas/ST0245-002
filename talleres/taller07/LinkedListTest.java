import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {

	@Test
	public void testInsert() {
		LinkedList list = new LinkedList();
		list.insert(5, 0);
		list.insert(4, 1);
		list.insert(3, 2);
		list.insert(2, 3);
		list.insert(1, 4);
		for (int i = 0; i < list.size(); i++)
		{
			assertEquals(list.get(0),5);
			assertEquals(list.get(1),4);
			assertEquals(list.get(2),3);
			assertEquals(list.get(3),2);
			assertEquals(list.get(4),1);			
		}		
	}

	@Test
	public void testRemove() {
		LinkedList list = new LinkedList();
		list.insert(5, 0);
		list.insert(4, 1);
		list.insert(3, 2);
		list.insert(2, 3);
		list.insert(1, 4);
		assertTrue(list.contains(3));
		list.remove(2);
		assertFalse(list.contains(3));
	}

	@Test
	public void testContains() {
		LinkedList list = new LinkedList();
		list.insert(5, 0);
		list.insert(4, 1);
		list.insert(3, 2);
		list.insert(2, 3);
		list.insert(1, 4);
		assertTrue(list.contains(3));
		assertFalse(list.contains(10));
	}

}
