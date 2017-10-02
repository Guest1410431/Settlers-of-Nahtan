package Menu;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class MenuTitle
{
	private final int LETTER_SPACING = 25;
	private final int LETTER_WIDTH = 25;
	private final int LETTER_HEIGHT = 25;
	
	private int xPos;
	private int yPos;
	
	private String menuTitle;
	
	private ArrayList<BufferedImage>letters;
	
	public MenuTitle(String menuTitle, int xPos, int yPos)
	{
		this.xPos = xPos;
		this.yPos = yPos;
		this.menuTitle = menuTitle;
		letters = new ArrayList<BufferedImage>();
		
		loadLetters();
	}
	// Parses the string menuTitle into images, letter by letter
	private void loadLetters()
	{
		
	}
	
	public void render(Graphics g)
	{
		g.drawString(menuTitle, xPos, yPos);
		for(int i=0; i<letters.size(); i++)
		{
			g.drawImage(letters.get(i), xPos + (i*(LETTER_WIDTH + LETTER_SPACING)), yPos, LETTER_WIDTH, LETTER_HEIGHT, null);
		}
	}
}
