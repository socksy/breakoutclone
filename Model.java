import java.util.*;
import java.io.*;
import java.nio.*;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import com.google.gson.*;

public class Model {
	//references to objects
	private ArrayList<Block> blocks = new ArrayList<Block>();
	private Ball ball;
	private Paddle paddle;
	private Controller controller;
	
	//internal representations to provide to view
	private float ball_x;
	private float ball_y;
	private float ball_vect_x;
	private float ball_vect_y;
	private int ball_power=1;
	
	private float paddle_x;
	private float paddle_y;

	private int score=0;
	private int no_of_levels=3;
	
	//Getters and setters
	public float getBallX () { return ball_x; }
	public float getBallY () { return ball_y; }
	public ArrayList<Block> getBlocks () { return blocks; }
	public float getPaddleX () { return paddle_x; }
	public Paddle getPaddle () { return paddle; } 
	public Ball getBall () { return ball; }
	public void increaseScore (int increase) { score+=increase;}
	public int getScore() { return score; }

	public Model () {

		ball = new Ball();
		paddle = new Paddle();
		loadLevel();
		paddle.doubleWidth();
		paddle.doubleWidth();

		ball_x=ball.getX();
		ball_y=ball.getY();
		paddle_x=paddle.getX();
		paddle_y=paddle.getY();

		controller = new Controller(ball, paddle, blocks);
	}

	/** Populates blocks ArrayList with predesigned level
	 * JSON, index array of different block types, array of outline of level design using numbers to refer to the index array 
	 * (see Level.java for data structure)
	 * @param Level String, consisting of required JSON
	 */
	public void populateBlockArray(String level) {
	
		Gson gson = new Gson();
		Level lev = gson.fromJson(level, Level.class);

		//Standard boring grid
		for (int i=0; i<lev.outline.size(); i++) {
			for (int j=0; j<13; j++) {
				int b_index = lev.outline.get(i)[j];
				if (b_index ==-1) { continue; }
				//Create block, laid out so 13 per row, rows 25 px apart, columns 5px apart
				blocks.add(new Block(10+(j*60),(i*25)+10,lev.block_index[b_index].getCurrentStrength(), lev.block_index[b_index].getColour()));
			}
		}
	}

	public void updateModel(int delta) {
		score += controller.update(delta);
		ball_x = ball.getX();
		ball_y = ball.getY();
		
		paddle_x = paddle.getX();
		
		int blocksleft=0;
		for (Block b: blocks) {
			if(b.exists())
				blocksleft++;
		}
		if (blocksleft <=0) {
			blocks.clear();
			loadLevel();
			ball.resetPosition();
		}

	}

	/** Reads file from String
	 * Taken from http://stackoverflow.com/questions/326390/how-to-create-a-java-string-from-the-contents-of-a-file
	 * @param path to read from
	 */
	private static String readFile(String path) {
		try {
			FileInputStream stream = new FileInputStream(new File(path));
			try {
				FileChannel fc = stream.getChannel();
				MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
				return Charset.defaultCharset().decode(bb).toString();
			} finally {
				stream.close();
			}
		} catch (IOException ioe) {
			System.err.println("File not found!");
			return null;
		}
	}
	
	//Load next level
	private int level_counter = 1;
	private void loadLevel () {
		String filepath = "level"+level_counter+".json";
		System.out.println("Loading "+filepath);
		level_counter++;
		level_counter = level_counter % no_of_levels;
		populateBlockArray(readFile(filepath));
		if (Math.random()>0.3) {
			paddle.halveWidth();
		} else {
			paddle.doubleWidth();
		}
		ball.increasePower();
	}
	
}
