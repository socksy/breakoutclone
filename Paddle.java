public class Paddle extends CollidableObject{
	Paddle () {
		super();
		width = 128;
		height = 15;
		x = (View.DISPLAYWIDTH / 2) - (width/2);
		y = View.DISPLAYHEIGHT - height*3;
	}
}
