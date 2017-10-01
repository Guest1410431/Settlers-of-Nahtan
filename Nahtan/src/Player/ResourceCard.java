package Player;

import Board.ResourceType;

public class ResourceCard
{
	ResourceType type;
	
	public ResourceCard(ResourceType type)
	{
		this.type = type;
	}
	
	public ResourceType getType()
	{
		return this.type;
	}
}
