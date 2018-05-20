import java.util.HashSet;
import java.util.Set;

public class Cellar extends Card {

	@Override
	public Set<CardType> getType() {
		HashSet<CardType> toReturn = new HashSet<CardType>();
		toReturn.add(CardType.ACTION);
		return toReturn;
	}

	@Override
	public int getCost() {
		return GameConstants.CELLARCOST;
	}
	
	@Override
	public int getActionsAdded() {
		return GameConstants.CELLARACTIONSADDED;
	}
	
	@Override
	public CardPlayState getPlayState() {
		return new CellarPlayState();
	}

}