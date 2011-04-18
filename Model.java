import java.util.*;

public class Model {
	//references to objects
	private ArrayList<Block> blocks = new ArrayList<Block>();
	private Ball ball;
	private Paddle paddle;
	
	//internal representations to provide to view
	private int ball_x;
	private int ball_y;
	private int ball_power=1;
	private int paddle_x;
	private int paddle_y;
	

	public int getBallX () { return ball_x; }
	public int getBallY () { return ball_y; }
	public ArrayList<Block> getBlocks () { return blocks; }


	public void updateModel () {
		ball_x = ball.getX();
		//TODO call controller methods to find out input
		//TODO set ball vector
		//TODO destroy or do whatever with blocks
	}
}
