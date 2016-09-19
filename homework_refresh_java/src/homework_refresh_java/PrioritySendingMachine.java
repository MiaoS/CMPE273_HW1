package homework_refresh_java;
import java.util.*;
import java.util.Map.Entry;


public class PrioritySendingMachine {
	private LinkedHashMap<String,Integer> sendLine = new LinkedHashMap<String,Integer>(10);
	
	public PrioritySendingMachine(){
		sendLine.clear();
	}
	public boolean newMail(String ename, int priority){
		if(sendLine.size() >= 10){
			System.out.println("machine is full");
			return false;
		}
		else{
			sendLine.put(ename, priority);
			System.out.println(sendLine);
			return true;
		}
	}
	
	public void runMachine(){
		if(sendLine.isEmpty()){
			System.out.println("No item need to go now");
		}
		else {
			
			updateMachine();
			System.out.println(sendLine);
		}
		
	}
	
	protected void updateMachine(){
		Set<Entry<String, Integer>> mset = sendLine.entrySet();
		Iterator<Entry<String, Integer>> i = mset.iterator();
		Stack<String> marked = new Stack<String>();
		while(i.hasNext()){
			Map.Entry<String,Integer> cur = (Map.Entry<String,Integer>)i.next();
			cur.setValue(cur.getValue()-1);
			//remove priority 0 item
			if(cur.getValue()==0){
				marked.push(cur.getKey());
			}
		}
		while(!marked.isEmpty()){
			System.out.println("remove element from machine: "+ marked.peek());
			sendLine.remove(marked.pop());
		
		}
	}
	
	public boolean isEmpty(){
		return sendLine.isEmpty();
	}
	public LinkedHashMap<String,Integer> content(){
		return sendLine;
	}
}
