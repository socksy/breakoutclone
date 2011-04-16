
public class Block extends CollidableObject {
	private int starting_strength = 1;
	private int current_strength = 1;
	Color colour;

	Block () {
		super();
		width = 25;
		height = 5;
	}
	/**
	 * param strength of the block — how many hits it takes to destroy it
	 */
	 Block (int strength) { 
	 	this();
	 	current_strength = starting_strength = strength;
	}
	 /**
	  * param x co-ordinate of top left of block
	  * param y co-ordinate of top left of block
	  * param strength of the block
	  */

	//Getters and Setters
	public void hit (int x, int y, int strength) { current_strength--; }
	public int getCurrentStrength () { return current_strength; }

}
