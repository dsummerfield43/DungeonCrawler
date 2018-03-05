package Crawler;
/**
 * Class that creates the beings in the world
 */
import java.util.*;

public class Being
{
	private int hp = 5;
	private int baseAtk = 3;
	private int initiative = 0;
	
	/**
	 * main constructor
	 * @param hp - hit points
	 * @param atk - attack
	 * @param initiative
	 */
	public Being(int hp, int atk, int initiative){
		this.hp = hp;
		this.baseAtk = atk;
		this.initiative = initiative;
	}
	
	/**
	 * basic constructor
	 */
	public Being(){
		this.hp = 5;
		this.baseAtk = 3;
		this.initiative = 0;
	}
	
	/**
	 * string method
	 */
	public String toString(){
		String stats = "Hp: " + hp + "\nAttack: " + baseAtk + "\nInitiative: " + initiative;
		return stats;
	}
	
	/**
	 * gets the being hp
	 */
	public int getHP() {
		return this.hp;
	}
	
	/**
	 * gets the being attack
	 */
	public int getAtk() {
		return this.baseAtk;
	}
	
	/**
	 * gets the being initiative
	 */
	public int getInitiative() {
		return this.initiative;
	}
	
	/**
	 * gets the being hp
	 */
	public void setHP(int dmg) {
		this.hp = this.hp - dmg;
	}
}