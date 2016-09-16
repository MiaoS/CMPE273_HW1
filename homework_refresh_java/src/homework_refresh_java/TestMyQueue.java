package homework_refresh_java;
import homework_refresh_java.MyQueue;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestMyQueue {
	
	int person = 10;
	int time = 5;
	MyQueue testQ= new MyQueue(person,time);
	
	
	@Test
	public void testMyQueueIsEmpty() {
		assertEquals(testQ.isEmpty(),false);
	}
	@Test
	public void testMyQueueWaitTime() {
		assertEquals(testQ.getCurrentWaitTime(),Integer.toString(person*time));
	}
	
	@Test
	public void testMyQueueNewCustomer(){
		testQ.newCustomer("A");
		assertEquals(testQ.getCurrentWaitTime(),Integer.toString((person+1)*time));
	}
	
	@Test
	public void testMyQueueServe(){
		assertEquals(testQ.serve(),"random person0");
		assertEquals(testQ.serve(),"random person1");
		assertEquals(testQ.serve(),"random person2");
		assertEquals(testQ.serve(),"random person3");
		assertEquals(testQ.serve(),"random person4");
	}
	@Test
	public void testMyQueueWaitTimeNew() {
		for(int i=0; i < 3 ;i++)
		{
			System.out.println(testQ.serve());
		}
		assertEquals(Integer.toString((person-3)*time),testQ.getCurrentWaitTime());
	}
	
	@Test
	public void testMyQueueIsEmptyTrue() {
		
		for(int i=0; i < person ;i++)
		{
			System.out.println(testQ.serve());
		}
		
		System.out.println("last test");
		assertEquals(true,testQ.isEmpty());
	}
	
}
