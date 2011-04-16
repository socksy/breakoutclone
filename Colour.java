//Admittedly, not great using struct like objects in java, but this makes life FAR easier than using cumbersome AWT color classes
//This reflects that OpenGL float representation
public class Colour {
	public float red=0;
	public float green=0;
	public float blue=0;

	Colour (float r, float g, float b) {
		red=r;
		green=g;
		blue=b;
	}
}
