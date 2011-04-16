import org.lwjgl.*;
import org.lwjgl.opengl.*;
import org.lwjgl.opengl.GL20;

public class Main {
	public void init() {
        	try {
		    Display.setDisplayMode(new DisplayMode(800,600));
		    Display.create();
		} catch (LWJGLException e) {
		    e.printStackTrace();
		    System.exit(0);
		}
	
		// init OpenGL 
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, 800, 600, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	
		while (!Display.isCloseRequested()) {
			//Render OpenGL

			//Clear screen and depth buffer:
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			

			Display.update();
		}

		Display.destroy();
	}

	public static void main(String[] args) {
		Main game = new Main();
		game.init();
	}
}
