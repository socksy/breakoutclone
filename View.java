import org.lwjgl.*;
import org.lwjgl.opengl.*;
public class View {
	final public int DISPLAYWIDTH = 800;
	final public int DISPLAYHEIGHT = 600;
	public void init() {
        	try {
		    Display.setDisplayMode(new DisplayMode(DISPLAYWIDTH, DISPLAYHEIGHT));
		    Display.create();
		} catch (LWJGLException e) {
		    e.printStackTrace();
		    System.exit(0);
		}
	
		// init OpenGL 
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, DISPLAYWIDTH, DISPLAYHEIGHT, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}


	public void render() {
		if (Display.isCloseRequested()) {
			Display.destroy();
			System.exit(0);
		} else {
			//render OpenGL
			//Clear screen and depth buffer:
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			Display.update();
		}
	}

	private void drawPaddle (int paddle_pos) {
		
	}
}
