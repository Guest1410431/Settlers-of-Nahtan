package Menu;

import java.awt.Graphics;
import java.util.ArrayList;

public class Menu
{
	private MenuTitle menuTitle;
	
	private ArrayList<Button>buttons;
	
	public Menu(MenuTitle menuTitle)
	{
		this.menuTitle = menuTitle;
		
		buttons = new ArrayList<Button>();
	}

	public void addButton(Button button)
	{
		buttons.add(button);
	}
	
	public void render(Graphics g)
	{
		menuTitle.render(g);
		
		for(Button button : buttons)
		{
			button.render(g);
		}
	}
}
