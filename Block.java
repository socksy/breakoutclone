
public class Block extends CollidableObject {
	private int starting_strength = 1;
	private int current_strength = 1;
	Colour colour = new Colour (0.3f, 1.0f, 0.6f);

	Block () {
		super ();
		width = 55;
		height = 15;
	}
	/**
	 * param strength of the block — how many hits it takes to destroy it
	 */
	Block (int strength) { 
	 	this ();
	 	current_strength = starting_strength = strength;
	}
	 /**
	  * param x co-ordinate of top left of block
	  * param y co-ordinate of top left of block
	  * param strength of the block
	  */
	Block (int x, int y, int strength) {
		this (strength);
		this.x = x;
		this.y = y;
	}
	//Getters and Setters
	public void hit () { current_strength--; System.out.println("ow");}
	public int getCurrentStrength () { return current_strength; }
	
	/**
	 * Calculates how much of their strength they've left relatively
	 * return a value between 0 and 1.0
	 */
	public double relativeStrengthLeft () {
		return (double) (current_strength/starting_strength);
	}

}
