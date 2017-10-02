package Menu;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;

import Utilities.Matrix;
import Utilities.Node;
import Utilities.Point;

public class MenuState
{
	private int menuState;

	private HashMap<Integer, Menu> menus;
	private Matrix<HexagonalButton> hexMatrix;

	public MenuState(int windowHeight, int windowWidth)
	{
		menuState = 1;

		menus = new HashMap<Integer, Menu>();
		hexMatrix = new Matrix<HexagonalButton>();

		makeHexGrid(windowWidth, windowHeight-100, 12, 100, 0);
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

	private void loadMainMenu()
	{
		Menu mainMenu = new Menu(new MenuTitle("Nahtan", 100, 100));
		
		ArrayList<HexagonalButton>buttons = getButtonLayout();
			
		buttons.get(0).setButtonName("Play Button");
		buttons.get(0).setMenuState(2);
		buttons.get(8).setButtonName("Settings Button");
		buttons.get(8).setMenuState(3);
		buttons.get(7).setButtonName("Quit Button");
		buttons.get(7).setMenuState(-1);
		
		for(HexagonalButton button : buttons)
		{
			mainMenu.addButton(button);
		}		
		menus.put(1, mainMenu);
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
		if (menus.get(menuState).checkMouseClick(x, y))
		{
			menuState = menus.get(menuState).getButtonPressed(x, y);
		}
		System.out.println("Menu State: " + menuState);
	}

	private ArrayList<HexagonalButton> getButtonLayout()
	{
		ArrayList<HexagonalButton>buttons = new ArrayList<HexagonalButton>();
		
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
