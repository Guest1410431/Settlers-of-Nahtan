package Menu;

import java.awt.Graphics;

public abstract class Button
{
	public abstract void setButtonName(String buttonName);
	public abstract void setMenuState(int menuRouteIndex);
	
	public abstract int getMenuState();
	public abstract boolean contains(int mouseX, int mouseY);
	
	public abstract void update();
	public abstract void render(Graphics g);
}
