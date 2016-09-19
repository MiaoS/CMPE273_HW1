package homework_refresh_java;


import static org.junit.Assert.*;

import org.junit.Test;

public class TestCheckSyntax {

	@Test
	public void testSimpleValid() {
		CheckSyntax t1 = new CheckSyntax("()");
		assertEquals(t1.inValid(),true);
		CheckSyntax t2 = new CheckSyntax("{}");
		assertEquals(t2.inValid(),true);
		CheckSyntax t3 = new CheckSyntax("[]");
		assertEquals(t3.inValid(),true);
	}
	
	@Test
	//one part of symbol is missing
	public void testSimpleInvalid() {
		CheckSyntax t1 = new CheckSyntax("(");
		assertEquals(t1.inValid(),false);
		CheckSyntax t2 = new CheckSyntax("{ald7401]fadfadf}");
		assertEquals(t2.inValid(),false);
		CheckSyntax t3 = new CheckSyntax("]");
		assertEquals(t3.inValid(),false);
	}
	@Test
	public void testComplexSyntax() {
		//multiple nested brackets
		CheckSyntax t1 = new CheckSyntax("(!checker.isEmpty()&&(checker.peek() ==leftToken.charAt(rightToken.indexOf(s.charAt(i)))))");
		assertEquals(t1.inValid(),true);
		
		CheckSyntax t2 = new CheckSyntax("public boolean isEmpty(){//System.out.println(\"Q size is \"+Integer.toString(Q.size()));if(Q.size()== 0){return true;}"+
		"else{return false;}	}");
		assertEquals(t2.inValid(),true);
		//misplace one pair of brackets.
		CheckSyntax t3 = new CheckSyntax("public String getCurrentWaitTime()[{return Integer.toUnsignedString(this.waitTime]);}");
		assertEquals(t3.inValid(),false);
	}


}
