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
		//b.addYForce(2);

	}

	public void update() {
		int mouseX = Mouse.getX();
		paddle.setX(mouseX-(paddle.getWidth()/2));
		//System.out.println(paddle.getX());
		ball.update();
		for (Block b : blocks) {
			if(b.hasCollidedWith(ball)) {
				b.hit();
				//ball.reverseYDirection();
			}
			if (b.pointInBoundingBox(mouseX, 600-Mouse.getY())) {
				System.out.println("oh yeah");
			}
		}
		if (paddle.hasCollidedWith(ball)) {
			ball.reverseYDirection();
		} else if (ball.getX()<=0 || ball.getX()>=View.DISPLAYWIDTH) {
			ball.reverseXDirection();
		} else if (ball.getY()<=0) {
			ball.reverseYDirection();
		}
	}

}
