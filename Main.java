import org.lwjgl.Sys;
import java.util.ArrayList;

public class Main {
	private static long last_frame;
	public static void main(String[] args) {
		View view = new View();
		Model model = new Model();
		view.init();
		int paddle_width = model.getPaddle().getWidth();
		while (true) {
			view.render(model);
			int delta = getDelta();
			model.updateModel(delta);
			if (model.getPaddle().getWidth()!=paddle_width) {
				System.out.println("Changing paddle size");
				view.setupVertexArrays(model);
				paddle_width=model.getPaddle().getWidth();
			}
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

