import org.lwjgl.*;
import org.lwjgl.opengl.*;
import static org.lwjgl.opengl.GL11.*;
import java.util.*;

public class Main {
	private ArrayList<Block> blocks = new ArrayList<Block>();
	public void init() {
        	try {
		    Display.setDisplayMode(new DisplayMode(800,600));
		    Display.create();
		} catch (LWJGLException e) {
		    e.printStackTrace();
		    System.exit(0);
		}
	
		// init OpenGL 
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 800, 600, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
	
		while (!Display.isCloseRequested()) {
			//Render OpenGL

			//Clear screen and depth buffer:
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			

			Display.update();
		}

		Display.destroy();
	}

	public static void main(String[] args) {
		Main game = new Main();
		game.init();
	}
}
