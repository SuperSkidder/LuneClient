package librarys.org.newdawn.slick.tests;

import librarys.org.newdawn.slick.*;
import librarys.org.newdawn.slick.geom.Polygon;
import librarys.org.newdawn.slick.AppGameContainer;
import librarys.org.newdawn.slick.BasicGame;
import librarys.org.newdawn.slick.Color;
import librarys.org.newdawn.slick.GameContainer;
import librarys.org.newdawn.slick.Graphics;
import librarys.org.newdawn.slick.Image;
import librarys.org.newdawn.slick.SlickException;

/**
 * Lame test
 * 
 * @author kevin
 */
public class LameTest extends BasicGame {
	/** The poly being drawn */
	private Polygon poly = new Polygon();
	/** The image being textured */
	private Image image;
	
	/**
	 * Create the test
	 */
	public LameTest() {
		super("Lame Test");
	}
	
	/**
	 * @see BasicGame#init(GameContainer)
	 */
	public void init(GameContainer container) throws SlickException {
		poly.addPoint(100, 100);
		poly.addPoint(120, 100);
		poly.addPoint(120, 120);
		poly.addPoint(100, 120);
	
		image = new Image("testdata/rocks.png");
	}

	/**
	 * @see BasicGame#update(GameContainer, int)
	 */
	public void update(GameContainer container, int delta) throws SlickException {
	}

	/**
	 * @see Game#render(GameContainer, Graphics)
	 */
	public void render(GameContainer container, Graphics g) throws SlickException {
		g.setColor(Color.white);
		g.texture(poly, image);
	}

	/**
	 * Entry point to our test
	 * 
	 * @param argv The arguments to pass into the test
	 */
	public static void main(String[] argv) {
		try {
			AppGameContainer container = new AppGameContainer(new LameTest());
			container.setDisplayMode(800,600,false);
			container.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}
