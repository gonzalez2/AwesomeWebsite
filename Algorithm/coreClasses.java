import java.util.ArrayList;
import java.util.Scanner;
public class coreClasses {
	
	static ArrayList<String> core = new ArrayList<String>();
	static ArrayList<String> classTaken = new ArrayList<String>();
	static Scanner kb = new Scanner(System.in);
	public static void main(String[] args) {	
		int finish = -1;
		int done = 1;
		String choice;
			
		core.add("Cs140");
		core.add("Cs141");
		core.add("Cs130");
		core.add("Cs210");
		core.add("Cs240");
		core.add("Cs241");
		core.add("Cs256");
		core.add("Cs264");
		
		System.out.println("This is the starting list: ");
		for( String display : core )
			  System.out.print(display + ", ");
		System.out.println();
		
		System.out.println("First class in the list is " + core.get(0));
		start();
	
	}
	public static void start(){
		survey();
	}
	
	public static void recommend(String name){
		
		classTaken.add(name);
		System.out.println("You are taking " + name);
		if(core.get(0).equals(name)){
			System.out.println("I am removing " + core.get(0) + " from core list");
			core.remove(0);
		}
		else{
			int ix = classTaken.indexOf(name);
			System.out.println("I am removing " + classTaken.get(ix) + " from core list");
			core.remove(name);
		}
		
		System.out.println("Reommended CS class for next quarter is: " + core.get(0));
		
		System.out.println("Remaining classes are:  ");
		for( String display : core )
			  System.out.print(display + ", ");
		
		System.out.println();
		
		System.out.println("So far you have taken: ");
		for( String display : classTaken )
			  System.out.print(display + ", ");
	}
	
	public static void survey(){
		System.out.println("What class are you taking?");
		String choice = kb.nextLine();
		recommend(choice);
		System.out.println("Are you done? (-1 for done| 1 if not )");
		int done = kb.nextInt();
		if(done != -1){
			kb.nextLine();
			start();
		}
	}

}
