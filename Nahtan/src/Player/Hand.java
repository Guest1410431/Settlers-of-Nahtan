package Player;

import java.util.ArrayList;

import Board.ResourceType;

public class Hand
{
	private ArrayList<ResourceCard> hand;
	
	// to keep track of what's in our hand so we don't have to traverse list
	private int brick;
	private int ore;
	private int wood;
	private int wheat;
	private int sheep;
	
	public Hand()
	{
		clay = 0;
		ore= 0;
		lumber = 0;
		wheat = 0;
		sheep = 0;
	}
	
	public int howMany(String type)
	{ // returns the number of a type of card, must type as you would and enumerated type
		if (type == "CLAY" || type == "clay")
		{
			return clay;
		}
		if (type == "ORE" || type == "ore")
		{
			return ore;
		}
		if (type == "LUMBER" || type == "lumber")
		{
			return lumber;
		}
		if (type == "WHEAT" || type == "wheat")
		{
			return wheat;
		}
			
		return sheep;
	}
}
