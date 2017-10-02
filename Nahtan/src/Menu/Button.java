package Menu;

import java.awt.Graphics;

public abstract class Button
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	
	private int menuState;

	private String buttonName;
	
	public Button(int xPos, int yPos, int width)
	{
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
	}
	
	public Button(String buttonName, int xPos, int yPos, int width, int height, int menuState)
	{
		this.buttonName = buttonName;
		
		this.menuState = menuState;
		
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
	
	}
	public void setButtonName(String buttonName)
	{
		this.buttonName = buttonName;
	}
	public void setMenuState(int menuRouteIndex)
	{
		this.menuState = menuRouteIndex;
	}	
	
	public abstract int getMenuState();
	public abstract boolean contains(int mouseX, int mouseY);
	
	public abstract void update();
	public abstract void render(Graphics g);
}
