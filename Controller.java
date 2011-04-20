import org.lwjgl.input.*;
import java.util.*;
public class Controller {
	private Ball ball;
	private Paddle paddle;
	private ArrayList<Block> blocks = new ArrayList<Block>();

	Controller (Ball b, Paddle p, ArrayList<Block> blocks) {
		ball = b;
		paddle = p;
		this.blocks = blocks;
		b.addYForce(0.35f);

	}

	/**
	 * Updates paddle position, ball position
	 * @param delta time passed in ms since last update
	 * @return score value
	 */
	public int update(int delta) {
		//Update ball (multiply vectors), pass delta for smooth animation
		ball.update(delta);
		//Get mouse input for paddle
		int mouseX = Mouse.getX();
		paddle.setX(mouseX-(paddle.getWidth()/2));

		//Check if Space is pressed, if so, start moving ball
		/*if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			ball.addYForce(0.35f);
		}*/

		if (Mouse.isButtonDown(0)) {
			ball.setYComponent(-0.45f);
		} else if (Mouse.isButtonDown(1)) {
			ball.resetPosition();
		}

		for (Block b : blocks) {
			if(b.hasCollidedWith(ball)&&b.exists()) {
				b.hit(ball, paddle);
				ball.reverseYDirection();
				//ball.reverseXDirection();
				return(10);
			}
		}
		if (paddle.hasCollidedWith(ball)) {
			int paddle_width = paddle.getWidth();
			if ((ball.getX()+5-paddle.getX())<(paddle_width)/2){
				ball.setXComponent(-((paddle_width/2)-(ball.getX()-paddle.getX()))/250);
			} else {
				ball.addXForce(((ball.getX()-paddle.getX())-(paddle_width/2))/250);
			}
			ball.reverseYDirection();
		} else if (ball.getX()<=0 || ball.getX()>=View.DISPLAYWIDTH) {
			ball.reverseXDirection();
		} else if (ball.getY()<=0) {
			ball.reverseYDirection();
		} else if ( ball.getY()>=View.DISPLAYHEIGHT) {
			ball.resetPosition();
			return -35; //Lose points when you die!
		}

		//No change to score
		return 0;
	}

}
