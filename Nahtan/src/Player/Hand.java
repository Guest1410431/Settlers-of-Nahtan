package Player;

import java.util.ArrayList;

import Board.ResourceType;

public class Hand
{
	private ArrayList<ResourceCard> hand;
	
	// to keep track of what's in our hand so we don't have to traverse list
	// TODO: CHECK OUT HASHMAPs <3
	private int brick;
	private int ore;
	private int wood;
	private int wheat;
	private int sheep;
	
	public Hand()
	{
		brick = 0;
		ore= 0;
		wood = 0;
		wheat = 0;
		sheep = 0;
	}
	
	public int howMany(String type)
	{ // returns the number of a type of card, must type as you would and enumerated type
		if (type == "BRICK" || type == "brick")
		{
			return brick;
		}
		if (type == "ORE" || type == "ore")
		{
			return ore;
		}
		if (type == "WOOD" || type == "wood")
		{
			return wood;
		}
		if (type == "WHEAT" || type == "wheat")
		{
			return wheat;
		}
			
		return sheep;
	}
}
