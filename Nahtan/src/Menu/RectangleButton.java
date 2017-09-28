package Menu;

import java.awt.Color;
import java.awt.Graphics;

public class RectangleButton extends Button
{
	// xPos and yPos represent the top left corner of the button
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	private int menuState;

	private String buttonName;

	public RectangleButton(String buttonName, int xPos, int yPos, int width, int height, int menuState)
	{
		super(buttonName, xPos, yPos, width, height, menuState);

		this.buttonName = buttonName;

		this.menuState = menuState;

		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
	}

	public int getMenuState()
	{
		return menuState;
	}
	public boolean contains(int mouseX, int mouseY)
	{
		return ((xPos <= mouseX) && ((xPos + width) >= mouseX) && (yPos <= mouseY) && ((yPos + height) >= mouseY));
	}
	public void update()
	{
		
	}
	public void render(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.drawRect(xPos, yPos, width, height);
	}
}
