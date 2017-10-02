package Menu;

import java.awt.Graphics;
import java.util.ArrayList;

import Utilities.Matrix;

public class MenuState
{
	private int menuState;

	private ArrayList<Menu> menus;
	private Matrix<HexagonalButton> hexMatrix;

	public MenuState(int windowHeight, int windowWidth)
	{
		menuState = 0;

		menus = new ArrayList<Menu>();
		hexMatrix = new Matrix<HexagonalButton>();

		makeHexGrid(windowWidth, windowHeight - 100, 12, 100, 0);
		loadMainMenu();
		loadGameMenu();
		loadSettingMenu();
		loadPlayerMenu();
		loadLoadMenu();
		loadNullMenu();
	}

	private void makeHexGrid(int origin_x, int origin_y, int size, int radius, int padding)
	{
		double ang30 = Math.toRadians(30);
		double xOff = Math.cos(ang30) * (radius + padding);
		double yOff = Math.sin(ang30) * (radius + padding);
		int half = size / 2;

		for (int row = 0; row < size; row++)
		{
			int cols = size - Math.abs(row - half);

			for (int col = 0; col < cols; col++)
			{
				int x = (int) (origin_x + xOff * (col * 2 + 1 - cols));
				int y = (int) (origin_y + yOff * (row - half) * 3);

				hexMatrix.add(row, col, new HexagonalButton(x, y, radius));
			}
		}
	}
	// Main Menu: 0
	private void loadMainMenu()
	{
		Menu mainMenu = new Menu(new MenuTitle("Nahtan", 100, 100));

		ArrayList<HexagonalButton> buttons = getButtonLayout();

		for (HexagonalButton button : buttons)
		{
			mainMenu.addButton(button.copyOf());
		}
		mainMenu.getButtonsAt(0).setButtonName("Play Button");
		mainMenu.getButtonsAt(0).setMenuState(1);
		mainMenu.getButtonsAt(8).setButtonName("Settings Button");
		mainMenu.getButtonsAt(8).setMenuState(2);
		mainMenu.getButtonsAt(7).setButtonName("Quit Button");
		mainMenu.getButtonsAt(7).setMenuState(-1);

		menus.add(mainMenu);
	}
	// Play Menu: 1
	private void loadGameMenu()
	{
		Menu playMenu = new Menu(new MenuTitle("Play Menu", 100, 100));

		ArrayList<HexagonalButton> buttons = getButtonLayout();

		for (HexagonalButton button : buttons)
		{
			playMenu.addButton(button.copyOf());
		}
		playMenu.getButtonsAt(0).setButtonName("Play Button");
		playMenu.getButtonsAt(0).setMenuState(1);
		playMenu.getButtonsAt(8).setButtonName("Back Button");
		playMenu.getButtonsAt(8).setMenuState(0);
		playMenu.getButtonsAt(7).setButtonName("Quit Button");
		playMenu.getButtonsAt(7).setMenuState(-1);

		menus.add(playMenu);
	}
	// Settings Menu: 2
	private void loadSettingMenu()
	{
		Menu settingsMenu = new Menu(new MenuTitle("Settings Menu", 100, 100));

		ArrayList<HexagonalButton> buttons = getButtonLayout();

		for (HexagonalButton button : buttons)
		{
			settingsMenu.addButton(button.copyOf());
		}
		settingsMenu.getButtonsAt(0).setButtonName("Options");
		settingsMenu.getButtonsAt(0).setMenuState(2);
		settingsMenu.getButtonsAt(8).setButtonName("Option");
		settingsMenu.getButtonsAt(8).setMenuState(2);
		settingsMenu.getButtonsAt(7).setButtonName("Another Option");
		settingsMenu.getButtonsAt(7).setMenuState(2);
		settingsMenu.getButtonsAt(1).setButtonName("Options 1");
		settingsMenu.getButtonsAt(1).setMenuState(2);
		settingsMenu.getButtonsAt(2).setButtonName("Option 2");
		settingsMenu.getButtonsAt(2).setMenuState(2);
		settingsMenu.getButtonsAt(3).setButtonName("Back");
		settingsMenu.getButtonsAt(3).setMenuState(0);

		menus.add(settingsMenu);
	}
	// Player Menu: 3
	private void loadPlayerMenu()
	{

	}
	// Load Menu: 4
	private void loadLoadMenu()
	{

	}
	// Error Message: 5
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
		if (menus.get(menuState).checkMouseClick(x, y))
		{
			menuState = menus.get(menuState).getButtonPressed(x, y);
		}
		System.out.println("Menu State: " + menuState);
	}

	private ArrayList<HexagonalButton> getButtonLayout()
	{
		ArrayList<HexagonalButton> buttons = new ArrayList<HexagonalButton>();

		buttons.add(hexMatrix.get(2, 0));
		buttons.add(hexMatrix.get(3, 1));
		buttons.add(hexMatrix.get(2, 1));
		buttons.add(hexMatrix.get(2, 2));
		buttons.add(hexMatrix.get(3, 3));
		buttons.add(hexMatrix.get(2, 3));
		buttons.add(hexMatrix.get(2, 4));
		buttons.add(hexMatrix.get(3, 5));
		buttons.add(hexMatrix.get(1, 4));
		buttons.add(hexMatrix.get(0, 3));

		return buttons;
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
