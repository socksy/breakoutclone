
import org.lwjgl.openal.AL;
import org.newdawn.slick.openal.*;
import java.io.*;

public class CollidableObject {
	//Top left hand corner co-ordinates
	protected float x;
	protected float y;
	//Bounding box
	protected int width;
	protected int height;
	//Collision noise
	protected Audio noise;

	//HEY HO nothing to see here
	public float getX () { return x; }
	public float getY () { return y; }
	public void setX (int x) { this.x = x; }
	public void setY (int y) { this.y = y; }
	public int getWidth () { return width; }
	public int getHeight () { return height; }
	
	CollidableObject (){
		try {
			noise = AudioLoader.getAudio("WAV", new FileInputStream("noise.wav"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//Collision detection
	public boolean pointInBoundingBox (int x, int y) {
		//if leftside <= x <= rightside && if top <= y <= bottom
		if (this.x <= x && x <= this.x+width && this.y <= y && y <= this.y+height) {
			System.out.println("Collision!");
			return true;
		}else {
			return false;
		}
	}
	
	public boolean hasCollidedWith (CollidableObject c) {
		//A few conditions to check they HAVEN'T collided, return true otherwise
		
		//the left side of one is to the right side of the other (which works out as vice versa):
		if (x+width <= c.getX() || c.getX()+c.getWidth() <= x) return false;

		//the bottom of one is below the top of another
		if (y+height <= c.getY() || c.getY()+c.getHeight() <= y) return false;
		
		noise.playAsSoundEffect(0.8f, 0.2f, false);
		SoundStore.get().poll(0);

		return true;
	}

}
