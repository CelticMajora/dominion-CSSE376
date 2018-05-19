import java.util.HashSet;
import java.util.Set;

public class Chapel extends Card {

	@Override
	public Set<CardType> getType() {
		HashSet<CardType> toReturn = new HashSet<CardType>();
		toReturn.add(CardType.ACTION);
		return toReturn;
	}

	@Override
	public int getCost() {
		return GameConstants.CHAPELCOST;
	}
	
	@Override
	public CardPlayState getPlayState(){
		return new ChapelPlayState();
	}

}