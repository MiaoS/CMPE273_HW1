package homework_refresh_java;

import org.junit.Test;

//import edu.umd.cs.mtc.MultithreadedTestCase;

public class TestMailMachineWorker {

	PrioritySendingMachine m = new PrioritySendingMachine();
	
	@Test(timeout =100000)
	public void test() {
		MailMachineWorker W1 = new MailMachineWorker( "Worker_One",m,1);
	    W1.start();
	      
	    //MailMachineWorker W2 = new MailMachineWorker( "WorkerTwo",m,2);
	   //W2.start();
	}

}
