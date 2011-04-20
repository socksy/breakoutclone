import org.lwjgl.*;
import org.lwjgl.opengl.*;
import org.lwjgl.input.Mouse;
import java.nio.IntBuffer;
import java.nio.ByteBuffer;

public class View {
	final public static int DISPLAYWIDTH = 800;
	final public static int DISPLAYHEIGHT = 600;
	IntBuffer paddle_vertices_buffer;
	IntBuffer ball_vertices_buffer;
	IntBuffer block_vertices_buffer;
	ByteBuffer indices_buffer;

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
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);


	}


	public void render(Model m) {
		if (Display.isCloseRequested()) {
			System.out.println("Score: "+m.getScore());
			Display.destroy();
			System.exit(0);
		} else {
			//render OpenGL
			//Clear screen and depth buffer:
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			
			//Populates vertex arrays and pointers to switch between
			setupVertexArrays(m);
			
			//Store everything in vertex buffer instead of immediate mode
			//Then translate to where needed
			GL11.glEnableClientState(GL11.GL_VERTEX_ARRAY);

			//Push draw pop, resetting to allow translation to be from 0,0 each time, as opposed to relative
			
			drawPaddle(m);
			drawBlocks(m);
			drawBall(m);

			Display.update();
		}
	}

	private void drawPaddle (Model m) {
		GL11.glPushMatrix();
		GL11.glColor3f(0.5f, 0.9f, 1.0f);
		Paddle p = m.getPaddle();
		
		
		//Set the vertex array pointer to the paddle vertices
		GL11.glVertexPointer(2, 0, paddle_vertices_buffer);

		GL11.glTranslatef(m.getPaddleX(),p.getY(),0f); //translate from identity (z-axis is 0)
		GL11.glDrawElements(GL11.GL_TRIANGLE_FAN, indices_buffer);
		GL11.glPopMatrix();

	}

	private void drawBall (Model m) {
		GL11.glPushMatrix();
		GL11.glColor3f(1.0f, 1.0f, 1.0f);
		GL11.glVertexPointer(2, 0, ball_vertices_buffer);
		GL11.glTranslatef(m.getBallX(), m.getBallY(), 0f);
		GL11.glDrawElements(GL11.GL_TRIANGLE_FAN, indices_buffer);
		GL11.glPopMatrix();
	}

	private void drawBlocks (Model m) {
		GL11.glVertexPointer(2, 0, block_vertices_buffer);
		for (Block b : m.getBlocks()) {
			if(b.exists()) {
				GL11.glColor4f(1.0f, 0.5f, 0.8f, (float)b.relativeStrengthLeft());
				GL11.glPushMatrix();
				GL11.glTranslatef(b.getX(), b.getY(), 0f);
				GL11.glDrawElements(GL11.GL_TRIANGLE_FAN, indices_buffer);
				GL11.glPopMatrix();
			}
		}
	}

	private void setupVertexArrays (Model m) {
		Paddle p = m.getPaddle();
		Ball b = m.getBall();
		Block bl = m.getBlocks().get(0); //Assuming homogenous blocks - not ideal, but will do for now.

		int[] paddle_vertices = {0,0
								,0+p.getWidth(),0
								,0,0+p.getHeight()
								,0+p.getWidth(),0+p.getHeight()};

		paddle_vertices_buffer = BufferUtils.createIntBuffer(8);
		paddle_vertices_buffer.put(paddle_vertices).flip();

		int[] ball_vertices = {
							 	 0,0
								,10,0
								,0,10
								,10,10
							  };
		ball_vertices_buffer = BufferUtils.createIntBuffer(8);
		ball_vertices_buffer.put(ball_vertices).flip();

		int[] standard_block_vertices = {0,0
										,0+bl.getWidth(),0
										,0,0+bl.getHeight()
										,0+bl.getWidth(),0+bl.getHeight()};

		block_vertices_buffer = BufferUtils.createIntBuffer(8);
		block_vertices_buffer.put(standard_block_vertices).flip();

		byte[] indices = {0,1,3,2};
		indices_buffer = BufferUtils.createByteBuffer(4);
		indices_buffer.put(indices).flip();
	}
}
