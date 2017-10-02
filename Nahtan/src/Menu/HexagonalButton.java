package Menu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class HexagonalButton extends Button
{
	// xPos and yPos represent the coordinates of the center of the button
	private int xPos;
	private int yPos;
	private int radius;

	private double angleOffset;
	
	private int menuState;

	private String buttonName;

	public HexagonalButton(int xPos, int yPos, int width)
	{
		super(xPos, yPos, width);
		
		this.xPos = xPos;
		this.yPos = yPos;
		
		angleOffset = 0.0;
		
		radius = width;
	}
	public HexagonalButton(String buttonName, int xPos, int yPos, int width, int height, int menuState)
	{
		super(buttonName, xPos, yPos, width, height, menuState);

		this.buttonName = buttonName;

		this.menuState = menuState;

		this.xPos = xPos;
		this.yPos = yPos;
		
		angleOffset = 0.0;

		radius = (width > height) ? width : height;
	}

	public void update()
	{
		angleOffset += 0.05;
	}
	public int getMenuState()
	{
		return menuState;
	}
	
	public void setMenuState(int menuState)
	{
		this.menuState = menuState;
	}
	public void setButtonName(String buttonName)
	{
		this.buttonName = buttonName;
	}
	public boolean contains(int mouseX, int mouseY)
	{
		return (Math.sqrt(((mouseX - xPos) * (mouseX - xPos) + (mouseY - yPos) * (mouseY - yPos))) <= radius);
	}

	private Polygon calculatePolygon()
	{
		int[]xPoints = new int[6];
		int[]yPoints = new int[6];
		
		double angle;

		for (int i = 0; i < 6; i++)
		{
			angle = ((Math.PI / 3.0) * i) + angleOffset;
			
			xPoints[i] = (int) (Math.round(xPos + Math.sin(angle) * radius));
			yPoints[i] = (int) (Math.round(yPos + Math.cos(angle) * radius));
		}
		return new Polygon(xPoints, yPoints, 6);
	}

	public void render(Graphics g)
	{
		Polygon hexagon = calculatePolygon();
		g.setColor(Color.BLACK);
		g.drawPolygon(hexagon);
		g.drawString((buttonName == null) ? "" : buttonName + " | " + menuState, xPos, yPos);
	}
	public Button copyOf()
	{
		return new HexagonalButton(xPos, yPos, radius);
	}
}
