package Utilities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Menu.MenuState;

public class Window extends JPanel
{
	private final int WIDTH = 1200;
	private final int HEIGHT = 800;
	
	private MenuState menuState;
	private JFrame frame;
	
	public Window()
	{
		initMenu();
		
		initFrame();
	}
	private void initMenu()
	{
		menuState = new MenuState();
	}
	private void initFrame()
	{
		setBackground(Color.WHITE);

		frame = new JFrame();

		frame.setTitle("Set'lers of Nahtan");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		frame.addKeyListener(new KeyListener() // Key Listener
		{
			public void keyPressed(KeyEvent e)
			{
				int key = e.getKeyCode();

				if (key == KeyEvent.VK_ESCAPE) // key bind to close the application
				{
					System.exit(1);
				}
			}

			public void keyReleased(KeyEvent e)
			{
			}

			public void keyTyped(KeyEvent e)
			{
			}
		});
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		// Render Here
		
	}

	public void update()
	{
		// Update Here

		// Repaint the Window
		repaint();
	}
}
