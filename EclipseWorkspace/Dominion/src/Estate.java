
public class Estate extends Card {

	@Override
	public int getCoinsAdded() {
		return 0;
	}

	@Override
	public String getType() {
		return "VICTORY";
	}

	@Override
	public int getVictoryValue() {
		return 1;
	}

	@Override
	public int getCost() {
		return 2;
	}
}
