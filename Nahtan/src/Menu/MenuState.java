package Menu;

import java.awt.Graphics;
import java.util.ArrayList;

public class MenuState
{	
	private int menuState;
	
	private ArrayList<Menu>menus;
	
	public MenuState()
	{
		menuState = 0;
		menus = new ArrayList<Menu>();
		
		loadMainMenu();
		loadGameMenu();
		loadSettingMenu();
		loadPlayerMenu();
		loadLoadMenu();
		loadNullMenu();
	}
	
	private void loadMainMenu()
	{
		int buttonHeight = 115;
		int buttonWidth = 115;
		
		Menu mainMenu = new Menu(new MenuTitle("Nahtan", 100, 100));	
		
		Button startButton = new HexagonalButton("Play", 200, 500, buttonWidth, buttonHeight, 1);
		Button settingsButton = new HexagonalButton("Settings", 400, 500, buttonWidth, buttonHeight, 2);
		Button quitButton = new HexagonalButton("Quit", 600, 500, buttonWidth, buttonHeight, -1);
		
		mainMenu.addButton(startButton);
		mainMenu.addButton(settingsButton);
		mainMenu.addButton(quitButton);
		
		menus.add(mainMenu);
	}

	private void loadGameMenu()
	{
				
	}

	private void loadSettingMenu()
	{
		
	}

	private void loadPlayerMenu()
	{

	}

	private void loadLoadMenu()
	{
				
	}
	
	private void loadNullMenu()
	{
		
	}

	public void setMenuState(int menuState)
	{
		this.menuState = menuState;
	}
	
	public int getMenuState()
	{
		return menuState;
	}
	
	public void checkMouseClick(int x, int y)
	{
		if(menus.get(menuState).checkMouseClick(x, y))
		{
			menuState = menus.get(menuState).getButtonPressed(x, y);
		}
		System.out.println("Menu State: " + menuState);
	}
	
	public void update()
	{
		menus.get(menuState).update();
	}
	
	public void render(Graphics g)
	{
		menus.get(menuState).render(g);
	}
}
