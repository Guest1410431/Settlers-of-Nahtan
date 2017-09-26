package Menu;

import java.awt.Graphics;
import java.util.ArrayList;

public class MenuState
{
	private final int BUTTON_PADDING = 25;
	
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
		int buttonHeight = 50;
		int buttonWidth = 200;
		
		Menu mainMenu = new Menu(new MenuTitle("Nahtan", 100, 100));	
		
		Button startButton = new Button("Play", 0, 0, buttonWidth, buttonHeight);
		Button settingsButton = new Button("Settings", 0, 0, buttonWidth, buttonHeight);
		Button quitButton = new Button("Quit", 0, 0, buttonWidth, buttonHeight);
		
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
	
	public void render(Graphics g)
	{
		menus.get(menuState).render(g);
	}
}
