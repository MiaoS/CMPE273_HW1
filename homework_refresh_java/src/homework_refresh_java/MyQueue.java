
package homework_refresh_java;
import java.util.*;
import java.lang.Exception;


public class MyQueue {
	private Queue<String> Q = new LinkedList<String>();
	private int serviceTime;
	private int waitTime =0;
	public MyQueue(int size,int servicetime){
		this.serviceTime = servicetime;
		for(int i =0 ; i< size; i++){
			Q.add("random person"+ Integer.toString(i) );
			this.waitTime += this.serviceTime;
		}
	}
	
	
	public String serve(){
		this.waitTime -=this.serviceTime;
		return Q.poll();
	}
	
	
	public boolean newCustomer(String name){
		try{
			Q.add(name);
			System.out.println(name+" has to wait "+ Integer.toUnsignedString(this.waitTime));
			this.waitTime += this.serviceTime;
			return true;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean isEmpty(){
		//System.out.println("Q size is "+Integer.toString(Q.size()));
		if(Q.size()== 0){
			
			return true;
		}
		else{
			return false;
		}
	}
	
	public String getCurrentWaitTime(){
		return Integer.toUnsignedString(this.waitTime);
	}
}
