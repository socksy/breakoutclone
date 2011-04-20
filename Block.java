
public class Block extends CollidableObject {
	private int starting_strength = 1;
	private int current_strength = 1;
	private Colour colour = new Colour (0.3f, 1.0f, 0.6f);
	private boolean exists = true;

	Block () {
		super ();
		width = 55;
		height = 15;
	}
	/**
	 * @param strength of the block — how many hits it takes to destroy it
	 */
	Block (int strength) { 
	 	this ();
	 	current_strength = starting_strength = strength;
	}
	 /**
	  * @param x co-ordinate of top left of block
	  * @param y co-ordinate of top left of block
	  * @param strength of the block
	  */
	Block (int x, int y, int strength) {
		this (strength);
		this.x = x;
		this.y = y;
	}
	
	/**
	  * @param x co-ordinate of top left of block
	  * @param y co-ordinate of top left of block
	  * @param strength of the block
	  * @param colour of the block
	  */
	Block (int x, int y, int strength, Colour colour) {
		this (strength);
		this.x = x;
		this.y = y;
		this.colour=colour;
	}

	
	//Getters and Setters
	public void hit () { 
		System.out.println("Current Strength: "+current_strength);
		current_strength--; 
		if (current_strength<=0) {
			exists=false;
		}
	}
	public int getCurrentStrength () { return current_strength; }
	public Colour getColour() { return colour; }
	public boolean exists () { return exists; }
	
	/**
	 * Calculates how much of their strength they've left relatively
	 * return a value between 0 and 1.0
	 */
	public float relativeStrengthLeft () {
		return (float) ((float)current_strength/(float)starting_strength);
	}


}
