import org.lwjgl.Sys;
public class Ball extends CollidableObject {
	private int power = 1;
	private float vector_x=0;
	private float vector_y=0;
	long last_frame = 0;

	Ball () {
		super();
		width = height = 10;
		x = View.DISPLAYWIDTH/2 + 5;
		y = View.DISPLAYHEIGHT - 100;
		vector_y=-1;
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
		vector_x += force/1000;
	}

	public void setPower() {
		this.power = power;
	}



	/**Updates position based on vector position
	 * Calculates where the next position should be.
	 */
	public void update () {
		x += vector_x*getDelta();
		y += vector_y*getDelta();
	}

	private long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	public int getDelta() {
	    long time = getTime();
	    int delta = (int) (time - last_frame);
	    last_frame = time;
	 
	    return delta;
	}
	
	
}
