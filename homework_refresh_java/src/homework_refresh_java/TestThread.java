package homework_refresh_java;

public class TestThread {

	public static void main(String[] args) {
		PrioritySendingMachine m = new PrioritySendingMachine();
		// TODO Auto-generated method stub
		MailMachineWorker W1 = new MailMachineWorker( "Worker_One",m,2);
	    W1.start();
	    MailMachineWorker W2 = new MailMachineWorker( "Worker_Two",m,4);
	    W2.start();
	    MailMachineWorker W3 = new MailMachineWorker( "Worker_Three",m,0);
	    W3.start();
	}

}
