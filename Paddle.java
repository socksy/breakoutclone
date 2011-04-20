public class Paddle extends CollidableObject{
	Paddle () {
		super();
		width = 128;
		height = 15;
		x = (View.DISPLAYWIDTH / 2) - (width/2);
		y = View.DISPLAYHEIGHT - height*3;
	}
	public void halveWidth() {
		if(width>32) {width=width/2;}
	}
	public void doubleWidth() {
		if(width<256) {width=width*2;}
	}
	public int getWidth() { return width; }
}
