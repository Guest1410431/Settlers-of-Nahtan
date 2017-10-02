package Menu;

import java.awt.Graphics;

public class MenuSlider
{
	private int min;
	private int max;
	private int height;
	private int width;
	private int interval;
	private int xPos;
	private int yPos;
	
	private String sliderTitle;

	public MenuSlider(int min, int max, int height, int width, int interval, int xPos, int yPos, String sliderTitle)
	{
		this.min = min;
		this.max = max;
		this.height = height;
		this.width = width;
		this.interval = interval;
		this.xPos = xPos;
		this.yPos = yPos;
		this.sliderTitle = sliderTitle;
	}
	public int slider(int x, int y)
	{
		return 0;
	}
	public void render(Graphics g)
	{
		
	}
}
