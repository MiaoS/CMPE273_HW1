package homework_refresh_java;
import java.lang.InterruptedException;

public class MailMachineWorker implements Runnable{

	private Thread t;
	private String wname;
	private PrioritySendingMachine m;
	private int task = 0;
	
	MailMachineWorker(String name, PrioritySendingMachine m,int task){
		this.wname = name;
	    System.out.println( this.wname +" is called in");
	    this.task = task;
	    this.m = m;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println( this.wname +" is working ");
		
		try{
		for(int i = 0; i < 5; i++){
		if(task ==0){
			
			m.runMachine();
			System.out.println( this.wname +" is running machine ");
			System.out.println( m.content());
		}
		else{
				System.out.println( m.content());
				System.out.println(m.newMail(wname +Integer.toString(i), task));
				System.out.println( this.wname +" is loading machine ");
				System.out.println( m.content());
			}
		System.out.println(i);
			Thread.sleep(3);
		}
		}
		catch(InterruptedException e){
			System.out.println(wname+ " is interrupted.");
		}
		System.out.println(wname+ " finish working.");
	}
	
	 public void start () {
	      System.out.println("Starting " +  wname );
	      if (t == null) {
	         t = new Thread(this, wname);
	         t.start ();
	      }
	   }

}


