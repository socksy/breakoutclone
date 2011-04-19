public class Ball extends CollidableObject {
	private int power = 1;
	private int vector_x=0;
	private int vector_y=0;

	Ball () {
		super();
		width = height = 10;
	}

	public void reverseYDirection () {
		vector_y = -vector_y;
	}

	public void reverseXDirection () {
		vector_x = -vector_x;
	}

	public void addYForce (int force) {
		vector_y -= force; //Assuming y is in opposite direction
	}

	public void addXForce (int force) {
		vector_x += force;
	}

	public void setPower() {
		this.power = power;
	}



	/**Updates position based on vector position
	 * Calculates where the next position should be.
	 */
	public void update () {
		x += vector_x;
		y += vector_y;
	}
}
