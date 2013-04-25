/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FoodGame;

import antcolony.SimulationObjects.Food;
import antcolony.configuration.Configuration;
import java.awt.*;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author Ben
 */
public class Renderer {

	private JFrame app;
	private Canvas canvas;
	private BufferStrategy buffer;
	private GraphicsEnvironment ge;
	private GraphicsDevice gd;
	private GraphicsConfiguration gc;
	private BufferedImage bi;
	private Graphics graphics = null;
	private Graphics2D g2d = null;
	private Color background = Configuration.currentConfig.backColor;
	private int resX;
	private int resY;
	private int frameDelay;
	private final SimulationState state;
	private boolean graphicsSetup = false;
	private boolean running = true;
	private int currentState = 0;
	private boolean paused = false;
	private BufferedImage backgroundImg;
	//inputs
	private KeyboardInput keyboard = new KeyboardInput(); // Keyboard polling
	private MouseInput mouse = new MouseInput();

	public Renderer(SimulationState s) {
		this.state = s;
	}

	private class DrawingThread extends Thread {

		public DrawingThread() {
		}

		@Override
		public void run() {
			while (running) {
				try {
					repaint();

					sleep(frameDelay);
				} catch (InterruptedException ex) {
					Logger.getLogger(Renderer.class.getName()).log(Level.SEVERE, null, ex);
				} finally {
					// release resources

					if (graphics != null) {
						graphics.dispose();
					}
					if (g2d != null) {
						g2d.dispose();
					}
				}
			}



		}
	}

	public void play() {
		if (!graphicsSetup) {
			setUpWindow();
			graphicsSetup = true;
		}






		repaint();

		//wait for a spacebar press before starting
		while (true) {
			keyboard.poll();
			if (keyboard.keyDown(KeyEvent.VK_SPACE)) {
				break;
			}
		}



		DrawingThread thread = new DrawingThread();
		thread.start();
		Point mousePos = new Point(0, 0);
		while (running) {


			// Poll the keyboard
			keyboard.poll();
			mouse.poll();
			if (keyboard.keyDownOnce(KeyEvent.VK_SPACE)) {
				paused = !paused;
			}

			if (keyboard.keyDownOnce(KeyEvent.VK_ESCAPE)) {
				running = false;
			}
			Point newMousePos = mouse.getPosition();
			if (mouse.buttonDown(1)) {


				Food clickFood = state.clickFood(mousePos.x, mousePos.y);
				if (clickFood != null) {
					System.out.println(clickFood.foodName);
					clickFood.pos.x += newMousePos.x - mousePos.x;
					clickFood.pos.y += newMousePos.y - mousePos.y;
				}

			}

			mousePos = newMousePos;
		}

		try {
			if (thread != null) {
				thread.join(2000);
			}
		} catch (InterruptedException ex) {
			Logger.getLogger(Renderer.class.getName()).log(Level.SEVERE, null, ex);
		}

		if (graphics != null) {
			graphics.dispose();
		}
		if (g2d != null) {
			g2d.dispose();
		}

		app.dispose();





	}

	//pre: ants have been instantiated, as have the graphics things
	//post: ants are drawn on the screen.
	private void drawFood(java.util.List<Food> food) {
		for (Food f : food) {
			g2d.drawImage(f.image, f.pos.x, f.pos.y, null); //these numbers are probably wildly wrong
		}

	}

	private void drawGrid() {
	}

	private void drawBackground() {
		//TODO: Draw Background. Refridgerator and stuff.

		g2d.drawImage(backgroundImg, 0, 0, null);

	}

	//pre: graphics are set up, things that need to be drawn are instantiated.
	//post: all the parts of the simulation are drawn to the screen
	private void repaint() {
		g2d = bi.createGraphics();
		g2d.setColor(background);
		g2d.fillRect(0, 0, resX, resY);

		drawBackground();

		drawFood(state.getFoodList());
//		g2d.drawString("Frame " + currentState, 10, 10);


		// Blit image and flip...
		graphics = buffer.getDrawGraphics();
		graphics.drawImage(bi, 0, 0, null);
		if (!buffer.contentsLost()) {
			buffer.show();
		}

		// Let the OS have a little time...
		//Thread.yield();

	}

	//pre: none
	//post: instantiates all the various variables necessary for core functions.
	private void setUpWindow() {
		// Create simulation window...
		resX = Configuration.currentConfig.resolution.x;
		resY = Configuration.currentConfig.resolution.y;
		app = new JFrame();
		app.setIgnoreRepaint(true);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create canvas for painting...
		canvas = new Canvas();
		canvas.setIgnoreRepaint(true);

		canvas.setSize(resX, resY);

		// Add canvas to simulation window...
		app.add(canvas);
		app.pack();
		app.setVisible(true);

		// Create BackBuffer...
		canvas.createBufferStrategy(2);
		buffer = canvas.getBufferStrategy();

		// Get graphics configuration...
		ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		gd = ge.getDefaultScreenDevice();
		gc = gd.getDefaultConfiguration();

		// Create off-screen drawing surface
		bi = gc.createCompatibleImage(resX, resY);

		// Hookup keyboard polling
		app.addKeyListener(keyboard);
		canvas.addKeyListener(keyboard);
		app.addMouseListener(mouse);
		app.addMouseMotionListener(mouse);

		canvas.addMouseListener(mouse);
		canvas.addMouseMotionListener(mouse);




		frameDelay = Math.round(1000 / Configuration.currentConfig.FPS);

		try {
			backgroundImg = ImageIO.read(new File("images/fridge.jpg"));
		} catch (IOException e) {
		}

	}
}
