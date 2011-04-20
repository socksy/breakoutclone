import org.lwjgl.Sys;

public class Main {
	private static long last_frame;
	public static void main(String[] args) {
		View view = new View();
		Model model = new Model();
		view.init();
		while (true) {
			view.render(model);
			int delta = getDelta();
			model.updateModel(delta);
		}

	}
	public static long getTime() {
    	return System.nanoTime() / 1000000;
	}
	public static int getDelta() {
	    long time = getTime();
	    int delta = (int) (time - last_frame);
	    last_frame = time;
	 
	    return delta;
	}
}

