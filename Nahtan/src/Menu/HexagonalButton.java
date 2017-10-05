package Menu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Font.FFF_Letter;
import Font.LetterImage;
import Utilities.Assets;

public class HexagonalButton extends Button
{
	private final int LETTER_SPACING = 1;
	private final int LETTER_SIZE = 1;
	// xPos and yPos represent the coordinates of the center of the button
	private int xPos;
	private int yPos;
	private int radius;

	private double angleOffset;

	private int menuState;

	private String buttonName;

	private ArrayList<LetterImage> letters;

	public HexagonalButton(int xPos, int yPos, int width)
	{
		this.xPos = xPos;
		this.yPos = yPos;

		angleOffset = 0.0;

		radius = width;
	}

	public HexagonalButton(String buttonName, int xPos, int yPos, int width, int height, int menuState)
	{
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
		loadLetters();
	}

	public boolean contains(int mouseX, int mouseY)
	{
		return (Math.sqrt(((mouseX - xPos) * (mouseX - xPos) + (mouseY - yPos) * (mouseY - yPos))) <= radius);
	}

	// Parses the string menuTitle into images, letter by letter
	private void loadLetters()
	{
		letters = new ArrayList<LetterImage>();

		char[] characters = buttonName.toUpperCase().toCharArray();

		for (int i = 0; i < characters.length; i++)
		{
			letters.add(new FFF_Letter(characters[i]));
		}
	}

	private Polygon calculatePolygon()
	{
		int[] xPoints = new int[6];
		int[] yPoints = new int[6];

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
		BufferedImage image = Assets.getWaterTile();

		Graphics2D g2 = (Graphics2D) g;

		TexturePaint texturePaint = new TexturePaint(image, hexagon.getBounds2D());
		g2.setPaint(texturePaint);
		g2.fill(hexagon);

		g.setColor(Color.BLACK);
		g.drawPolygon(hexagon);

		if (buttonName != null)
		{
			int spacing = 0;
			for (int i = 0; i < letters.size(); i++)
			{
				LetterImage fontLetter = letters.get(i);

				g.drawImage(fontLetter.getImage(), xPos + spacing, yPos, fontLetter.getWidth() * LETTER_SIZE,
						fontLetter.getHeight() * LETTER_SIZE, null);

				spacing += (fontLetter.getWidth() * LETTER_SIZE) + LETTER_SPACING;
			}
		}
	}

	public Button copyOf()
	{
		return new HexagonalButton(xPos, yPos, radius);
	}
}
