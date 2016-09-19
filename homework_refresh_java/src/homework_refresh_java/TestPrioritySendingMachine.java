package homework_refresh_java;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;

import org.junit.After;

import static org.junit.After.*;

import org.junit.Test;

public class TestPrioritySendingMachine {

	PrioritySendingMachine m = new PrioritySendingMachine();
	LinkedHashMap<String,Integer> expected = new LinkedHashMap<String,Integer>(10);
	
	@After
	public void printLine(){
		System.out.println("-----------end of test case-----------");
	}
	
	@Test
	public void testConstructor() {
		expected.put("m1", 10);
		assertEquals(m.newMail("m1",10),true);
		assertEquals(expected.equals(m.content()),true);
		System.out.print("print m content: ");
		System.out.println(m.content());
	}
	
	@Test
	public void testRunMachine() {
		assertEquals(m.newMail("m1",2),true);
		assertEquals(m.newMail("m2",3),true);
		assertEquals(m.newMail("m3",1),true);
		assertEquals(m.newMail("m4",5),true);
		System.out.print("print m content: ");
		System.out.println(m.content());
		m.runMachine();
		//expected map
		expected.put("m1", 1);
		expected.put("m2", 2);
		expected.put("m4", 4);
		
		
		System.out.print("print m content: ");
		assertEquals(expected.equals(m.content()),true);
		System.out.println(m.content());
	}
	
	@Test
	public void testRunMachineTillEmpty() {
		assertEquals(m.newMail("m1",2),true);
		assertEquals(m.newMail("m2",3),true);
		assertEquals(m.newMail("m3",1),true);
		assertEquals(m.newMail("m4",4),true);
		System.out.print("print m content: ");
		System.out.println(m.content());
		int i = 4;
		while(!m.isEmpty()){
			i--; 
			m.runMachine();
			System.out.print("print m content: ");
			System.out.println(m.content());
			assertEquals(m.content().size() == i,true);
		}
	}
	
	@Test
	public void testMachineCap() {
		assertEquals(m.newMail("m1",2),true);
		assertEquals(m.newMail("m2",2),true);
		assertEquals(m.newMail("m3",2),true);
		assertEquals(m.newMail("m4",2),true);
		assertEquals(m.newMail("m5",2),true);
		assertEquals(m.newMail("m6",2),true);
		assertEquals(m.newMail("m7",2),true);
		assertEquals(m.newMail("m8",2),true);
		assertEquals(m.newMail("m9",2),true);
		assertEquals(m.newMail("m10",2),true);
		assertEquals(m.newMail("m11",2),false);
	}
	

}
