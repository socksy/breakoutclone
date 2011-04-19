import org.lwjgl.Sys;

public class Main {
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
	private long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	public int getDelta() {
	    long time = getTime();
	    int delta = (int) (time - last_frame);
	    last_frame = time;
	 
	    return delta;
	}
}

