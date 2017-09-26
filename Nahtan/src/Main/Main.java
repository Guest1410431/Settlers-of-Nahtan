package Main;

import Utilities.Loop;
import Utilities.Window;

/*
 * 	And thus begins the journey of 4 somewhat skilled
 * 	computer science hopefuls on heir journey to recreate
 * 	the beloved board game "Settlers of Catan" in their 
 *	own image. 
 *
 *	September 25, 2017
 *	Grayson Bridges
 *	Michael Lieb
 *	Dakota Wilkerson
 *	Nathan Robinson
 */

public class Main 
{
	public static void main(String[] args) 
	{	
		Window window = new Window();
		
		Loop loop = new Loop(window);
		
		loop.run();
	}
}
