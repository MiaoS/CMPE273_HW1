package homework_refresh_java;
//import java.lang.reflect.Array;
import java.util.*;

public class CheckSyntax {
	private Stack<Character> checker = new Stack<Character>();
	private String s;
	
	private final String leftToken = "([{";
	private final String rightToken=")]}";
	
	public CheckSyntax(String s){
		System.out.println();
		this.s = s;
		
	};
	public boolean inValid(){
		for(int i = 0; i < s.length(); i++){
			if(leftToken.indexOf(s.charAt(i))>=0){
				System.out.print(s.charAt(i));
				System.out.print(" pushed ");
				checker.push(s.charAt(i));
			}else if(rightToken.indexOf(s.charAt(i))>=0){
				System.out.print(s.charAt(i));
				if(!checker.isEmpty()&&(checker.peek() ==leftToken.charAt(rightToken.indexOf(s.charAt(i))))){
					System.out.print(s.charAt(i));
					System.out.print(" pop ");
					checker.pop();}
				else
					return false;
			}
		}
		
		if(checker.isEmpty())
			return true;
		else
			return false;
	}

	
}