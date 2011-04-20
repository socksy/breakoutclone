public class Ball extends CollidableObject {
	private int power = 1;
	private double vector_x=0;
	private double vector_y=0;

	Ball () {
		super();
		width = height = 10;
		resetPosition();
	}

	public void resetPosition () {
		x = View.DISPLAYWIDTH/2 + 5;
		y = View.DISPLAYHEIGHT - 100;
		vector_y = vector_x = 0;
	}

	public void reverseYDirection () {
		vector_y = -vector_y;
	}

	public void reverseXDirection () {
		vector_x = -vector_x;
	}

	public void addYForce (double force) {
		vector_y -= force; //Assuming y is in opposite direction
	}

	public void addXForce (double force) {
		vector_x += force;
	}

	public void setXComponent (double force) {
		vector_x = force;
	}
	
	public void setYComponent (double force) {
		vector_y = force;
	}

	public double getYComponent () { return vector_y; }

	public void setPower(int power) {
		this.power = power;
	}
	public void increasePower() { power++; }

	public int getPower() { return power; }



	/**Updates position based on vector position
	 * Calculates where the next position should be.
	 */
	public void update (int delta) {
		/*System.out.println("Potential Movement: "+vector_y*delta);
		System.out.println("Actual Movement: "+vector_y);
		System.out.println("Ball y:"+y);
		System.out.println("Delta: "+delta);*/
		/*if(delta==0){
			return;
		} else {*/
			y += vector_y;
			x += vector_x;
		//}
		//y -= vector_y);
	}
	
	
}
