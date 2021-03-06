package librarys.org.newdawn.slick.tests;

import librarys.org.newdawn.slick.AppGameContainer;
import librarys.org.newdawn.slick.BasicGame;
import librarys.org.newdawn.slick.GameContainer;
import librarys.org.newdawn.slick.Graphics;
import librarys.org.newdawn.slick.Input;
import librarys.org.newdawn.slick.SlickException;
import librarys.org.newdawn.slick.command.BasicCommand;
import librarys.org.newdawn.slick.command.Command;
import librarys.org.newdawn.slick.command.ControllerButtonControl;
import librarys.org.newdawn.slick.command.ControllerDirectionControl;
import librarys.org.newdawn.slick.command.InputProvider;
import librarys.org.newdawn.slick.command.InputProviderListener;
import librarys.org.newdawn.slick.command.KeyControl;
import librarys.org.newdawn.slick.command.MouseButtonControl;

/**
 * A test for abstract input via InputProvider
 *
 * @author kevin
 */
public class InputProviderTest extends BasicGame implements InputProviderListener {
	/** The command for attack */
	private Command attack = new BasicCommand("attack");
	/** The command for jump */
	private Command jump = new BasicCommand("jump");
	/** The command for jump */
	private Command run = new BasicCommand("run");
	/** The input provider abstracting input */
	private InputProvider provider;
	/** The message to be displayed */
	private String message = "";
	
	/**
	 * Create a new image rendering test
	 */
	public InputProviderTest() {
		super("InputProvider Test");
	}
	
	/**
	 * @see BasicGame#init(GameContainer)
	 */
	public void init(GameContainer container) throws SlickException {
		provider = new InputProvider(container.getInput());
		provider.addListener(this);
		
		provider.bindCommand(new KeyControl(Input.KEY_LEFT), run);
		provider.bindCommand(new KeyControl(Input.KEY_A), run);
		provider.bindCommand(new ControllerDirectionControl(0, ControllerDirectionControl.LEFT), run);
		provider.bindCommand(new KeyControl(Input.KEY_UP), jump);
		provider.bindCommand(new KeyControl(Input.KEY_W), jump);
		provider.bindCommand(new ControllerDirectionControl(0, ControllerDirectionControl.UP), jump);
		provider.bindCommand(new KeyControl(Input.KEY_SPACE), attack);
		provider.bindCommand(new MouseButtonControl(0), attack);
		provider.bindCommand(new ControllerButtonControl(0, 1), attack);
	}

	/**
	 * @see BasicGame#render(GameContainer, Graphics)
	 */
	public void render(GameContainer container, Graphics g) {
		g.drawString("Press A, W, Left, Up, space, mouse button 1,and gamepad controls",10,50);
		g.drawString(message,100,150);
	}

	/**
	 * @see BasicGame#update(GameContainer, int)
	 */
	public void update(GameContainer container, int delta) {
	}

	/**
	 * @see InputProviderListener#controlPressed(Command)
	 */
	public void controlPressed(Command command) {
		message = "Pressed: "+command;
	}

	/**
	 * @see InputProviderListener#controlReleased(Command)
	 */
	public void controlReleased(Command command) {
		message = "Released: "+command;
	}
	
	/**
	 * Entry point to our test
	 * 
	 * @param argv The arguments to pass into the test
	 */
	public static void main(String[] argv) {
		try {
			AppGameContainer container = new AppGameContainer(new InputProviderTest());
			container.setDisplayMode(800,600,false);
			container.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}
