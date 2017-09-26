package Menu;

import java.awt.Color;
import java.awt.Graphics;

public class Button
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	private String buttonName;
	
	public Button(String buttonName, int xPos, int yPos, int width, int height)
	{
		this.buttonName = buttonName;
		
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
	}
	public boolean contains(int mouseX, int mouseY)
	{
		return false;
	}
	public void render(Graphics g)
	{
		// Make button name out of images
		g.setColor(Color.BLACK);
		g.drawRect(xPos, yPos, width, height);
		g.drawString(buttonName, xPos, yPos);
	}		
}
