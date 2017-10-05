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
	
	public boolean checkMouseClick(int x, int y)
	{
		for(Button button : buttons)
		{
			if(button.contains(x, y))
			{
				return true;
			}
		}
		return false;
	}
	public int getButtonPressed(int x, int y)
	{
		for(Button button : buttons)
		{
			if(button.contains(x, y))
			{
				return button.getMenuState();
			}
		}
		return -1;
	}

	public Button getButtonsAt(int i)
	{
		return buttons.get(i);
	}
	public void update() 
	{
		for(Button button : buttons)
		{
			button.update();
		}
	}
	
	public void render(Graphics g)
	{
		for(Button button : buttons)
		{
			button.render(g);
		}
		menuTitle.render(g);
	}
}
