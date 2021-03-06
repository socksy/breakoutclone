import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

public class Test {
	
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
	
	int mouseX;
	while (!Display.isCloseRequested()) {
	
		// render OpenGL 
		// glClear screen and depth buffer
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		
		glColor3f(0.5f,0.5f,0.9f);
		
		mouseX = Mouse.getX();

		glBegin(GL_QUADS);
			glVertex2f(mouseX-50, 550);
			glVertex2f(mouseX+50, 550);
			glVertex2f(mouseX+50, 570);
			glVertex2f(mouseX-50, 570);
		glEnd();

	    Display.update();
	}
		
	Display.destroy();
    }
	
    public static void main(String[] argv) {
        Test test = new Test();
	test.init();
    }
}

