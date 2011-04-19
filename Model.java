import java.util.*;

public class Model {
	//references to objects
	private ArrayList<Block> blocks = new ArrayList<Block>();
	private boolean homogenous_blocks = true;
	private Ball ball;
	private Paddle paddle;
	private Controller controller;
	
	//internal representations to provide to view
	private int ball_x;
	private int ball_y;
	private int ball_vect_x;
	private int ball_vect_y;
	private int ball_power=1;
	
	private int paddle_x; //This will be updated whilst the paddle's one won't
	private int paddle_y;

	private int score=0;
	private int delta;
	
	//Getters and setters
	public int getBallX () { return ball_x; }
	public int getBallY () { return ball_y; }
	public ArrayList<Block> getBlocks () { return blocks; }
	public int getPaddleX () { return paddle_x; }
	public Paddle getPaddle () { return paddle; } 
	public Ball getBall () { return ball; }

	public Model (int delta) {
		this.delta=delta;

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
		for (int i=0; i<3; i++) {
			for (int j=0; j<13; j++) {
				blocks.add(new Block(10+(j*60),(i*25)+10,1));
			}
		}
	}

	public void updateModel() {
		controller.update();
		ball.update();
		ball_x = ball.getX();
		ball_y = ball.getY();
		
		paddle_x = paddle.getX();
		//TODO call controller methods to find out input DONE
		//TODO set ball vector FOAS:MDGADFGP)
		//TODO destroy or do whatever with blocks
	}
}
