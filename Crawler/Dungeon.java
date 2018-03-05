package Crawler;
/**
 * Main dungeon class
 */
import java.util.*;

public class Dungeon
{
	int[] dng = new int[8];
	int count = 0;
	int mcount = 3;
	int mcount2 = 5;
	int buildCnt = 0;
	
	Scanner scan = new Scanner(System.in);
	String input;
	Random rand = new Random();

	public void buildDungeon(){
		
		System.out.println(", You've raided the dungeon but now it is time to leave!");
		System.out.println("Question is can you make it?");
		
		/**
		 * calling for the hero to be built
		 */
		Being hero = new Being(10,5,rand.nextInt(20));
		System.out.println("You are a human. Here are your stats:");
		System.out.println(hero.toString());
		System.out.println("");
		
		/**
		* The way the user moves through the dungeon
		*/
		while(dng[count] <= 7){
			/**
			* Visual for rooms
			*/
			
			for(int i = 0; i <= 7; i++) {
				dngTextRoomRoof();
			}
			
			System.out.println("");
			
			for(int i = 0; i <= 7; i++) {
				if(i == count) {
					dngTextCharacterRoom();
				}else {
					dngTextEmptyRoom();
				}
			}
			
			System.out.println("");
			
			for(int i = 0; i <= 7; i++) {
				dngTextRoomFloor();
			}
			
			System.out.println("");
			
			/**
			 * win condition
			 */
			if(count == 7) {
				System.out.println("You have made it to the end of the dungeon!");
				System.out.println("Game Over! You Win!");
				return;
			}
			
			/**
			* Directions for the player
			*/
			if(count == 0)
			{
				System.out.println("You can only go right from this point");
				System.out.println("Press R to go right.");
			}else{
				System.out.println("Type L to go left or R to go right");
			}

			input = scan.nextLine();
			if(input.equalsIgnoreCase("L") && count == 0){
				count = 0;
			}else if(input.equalsIgnoreCase("L")) {
				count--;
			}else if(input.equalsIgnoreCase("R")){
				count++;
			}

			/**
			* Finding a monster
			*/
			if(count == mcount || count == mcount2){
				System.out.println("You have found a monster!");
				Being monster = new Being(3,3,rand.nextInt(20));
				
				while(monster.getHP() > 0 && hero.getHP() > 0) {
					if(monster.getInitiative() > hero.getInitiative()) {
						System.out.println("The monster has gone first!");
						hero.setHP(monster.getAtk());
						System.out.println("The monster has done " + monster.getAtk() + " dmg to you!");
					}else {
						System.out.println("You have gone first!");
						monster.setHP(hero.getAtk());
						System.out.println("You have done " + hero.getAtk() + " dmg to the monster!");
					}
				}
				
				if(monster.getHP() <= 0) {
					System.out.println("You have slain the monster!");
				} else {
					System.out.println("You've Died!");
					return;
				}
			}
		}
	}

	/**
	* Base Room roof
	*/
	public static void dngTextRoomRoof(){
		System.out.print(" ___ ");
	}
	/**
	* Room that tells where the player is
	*/
	public static void dngTextCharacterRoom(){
		System.out.print("| C |");
	}
	/**
	 * Empty room
	 */
	public static void dngTextEmptyRoom(){
		System.out.print("|   |");
	}
	/**
	 * floor
	 */
	public static void dngTextRoomFloor(){
		System.out.print(" ~~~ ");
	}
}