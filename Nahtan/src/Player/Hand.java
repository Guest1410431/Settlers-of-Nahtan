package Player;

import java.util.ArrayList;

import Board.ResourceType;

public class Hand
{
	private ArrayList<ResourceCard> hand;
	
	// to keep track of what's in our hand so we don't have to traverse list
	private int clay;
	private int ore;
	private int lumber;
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
	{ // must type as you would and enumerated type
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
