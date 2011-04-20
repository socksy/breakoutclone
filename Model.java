import java.util.*;

public class Model {
	//references to objects
	private ArrayList<Block> blocks = new ArrayList<Block>();
	private boolean homogenous_blocks = true;
	private Ball ball;
	private Paddle paddle;
	private Controller controller;
	
	//internal representations to provide to view
	private float ball_x;
	private float ball_y;
	private float ball_vect_x;
	private float ball_vect_y;
	private int ball_power=1;
	
	private float paddle_x;
	private float paddle_y;

	private int score=0;
	
	//Getters and setters
	public float getBallX () { return ball_x; }
	public float getBallY () { return ball_y; }
	public ArrayList<Block> getBlocks () { return blocks; }
	public float getPaddleX () { return paddle_x; }
	public Paddle getPaddle () { return paddle; } 
	public Ball getBall () { return ball; }
	public void increaseScore (int increase) { score+=increase;}
	public int getScore() { return score; }

	public Model () {

		ball = new Ball();
		paddle = new Paddle();
		populateBlockArray();

		ball_x=ball.getX();
		ball_y=ball.getY();
		paddle_x=paddle.getX();
		paddle_y=paddle.getY();

		controller = new Controller(ball, paddle, blocks);
	}

	public void populateBlockArray() {
		for (int i=0; i<4; i++) {
			for (int j=0; j<13; j++) {
				blocks.add(new Block(10+(j*60),(i*25)+10,3));
			}
		}
	}

	public void updateModel(int delta) {
		score += controller.update(delta);
		ball_x = ball.getX();
		ball_y = ball.getY();
		
		paddle_x = paddle.getX();
		//TODO call controller methods to find out input DONE
		//TODO set ball vector FOAS:MDGADFGP)
		//TODO destroy or do whatever with blocks
	}
}
