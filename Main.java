import org.lwjgl.opengl.*;

public class Main {
	public static void main(String[] args) {
		View view = new View();
		Model model = new Model();
		view.init();
		while (true) {
			view.render();
		}		

	}
}

