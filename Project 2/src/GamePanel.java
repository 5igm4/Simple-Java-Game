import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;


/**
 * Animates a simple graphical game.
 *
 * Uses a Swing Timer to advance the animation; keeps track of, and renders, all GameObjects. Handles all relevant game events.
 *
 * @author sdexter72
 *
 */

public class GamePanel extends JPanel implements ActionListener {

   	static final int FRAME_RATE = 30; // animation proceeds at 30 frames per second
	Timer t;	// animation timer

	GameObject ball; // bare-bones animation: just a simple object that slides across the panel

	/**
	 * Sets up panel background, creates game Timer, creates initial GameObjects
	 *
	 */

	GamePanel () {
		setBackground(Color.BLACK);
        t = new Timer(1000/FRAME_RATE, this);
		ball = new GameObject(0,0,30,30,5,5);

	}

	/**
	 * How to render one "frame" of the animation
	 */

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.blue);
		g.fillOval(ball.topLeft.x, ball.topLeft.y, ball.getWidth(), ball.getHeight());
	}

	/**
	 * Responds to 'ticks' from the timer.
	 */

	@Override
	public void actionPerformed(ActionEvent e) {

		// if this is an event from the Timer, call the method that advances the animation
		if (e.getSource() == t) {
			tick();
		}
	}

	/**
	 * Make sure all GameObjects are in the right place (do any need to be removed? do we need to create any new ones?), then redraw game
	 */

	private void tick() {
		ball.step();	// we just have the ball right now, so this is easy
		repaint();		// ask to have the game redrawn (this will invoke paintComponent() when the system says the time is right)
	}

	/**
	 * Start the Timer: this will cause events to be fired, and thus the animation to begin
	 */

	void go() {
		t.start();
	}

}
