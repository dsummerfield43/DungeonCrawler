package Crawler;
/**
 * Class that tests the dungeon
 */
import java.util.*;

public class testDng{

	public static void main(String[] args){
		String name;
		Scanner scan = new Scanner(System.in);

		System.out.println("What is your characters name?");
		name = scan.nextLine();
		System.out.print(name);
		
		Dungeon dng = new Dungeon();
		dng.buildDungeon();
		
	}
}