import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Supply {
	Stack<Card> copperSupply;
	Stack<Card> silverSupply;
	Stack<Card> goldSupply;
	Stack<Card> estateSupply;
	Stack<Card> duchySupply;
	Stack<Card> provinceSupply;
	Stack<Card> curseSupply;
	List<Stack<Card>> kingdomCardList;

	Map<String, Stack<Card>> supplyPiles;

	public Supply() {
		this.supplyPiles = new HashMap<String, Stack<Card>>();
		this.kingdomCardList = new ArrayList<Stack<Card>>();

		this.setUpCopper();
		this.setUpSilver();
		this.setUpGold();
		this.setUpEstate();
		this.setUpDuchy();
		this.setUpProvince();
		this.setUpCurse();

		for (int i = 0; i < 10; i++) {
			this.kingdomCardList.add(new Stack<Card>());
			for (int j = 0; j < 10; j++) {
				this.kingdomCardList.get(i).push(new Copper());
			}
		}
	}

	private void setUpCopper() {
		this.supplyPiles.put("COPPER", new Stack<Card>());
		this.copperSupply = this.supplyPiles.get("COPPER");
		for (int i = 0; i < 60; i++) {
			this.copperSupply.push(new Copper());
		}
	}

	private void setUpSilver() {
		this.supplyPiles.put("SILVER", new Stack<Card>());
		this.silverSupply = this.supplyPiles.get("SILVER");
		for (int i = 0; i < 40; i++) {
			this.silverSupply.push(new Silver());
		}
	}

	private void setUpGold() {
		this.supplyPiles.put("GOLD", new Stack<Card>());
		this.goldSupply = this.supplyPiles.get("GOLD");
		for (int i = 0; i < 30; i++) {
			this.goldSupply.push(new Gold());
		}
	}

	private void setUpEstate() {
		this.supplyPiles.put("ESTATE", new Stack<Card>());
		this.estateSupply = this.supplyPiles.get("ESTATE");
		for (int i = 0; i < 24; i++) {
			this.estateSupply.push(new Estate());
		}
	}

	private void setUpDuchy() {
		this.supplyPiles.put("DUCHY", new Stack<Card>());
		this.duchySupply = this.supplyPiles.get("DUCHY");
		for (int i = 0; i < 12; i++) {
			this.duchySupply.push(new Duchy());
		}
	}

	private void setUpProvince() {
		this.supplyPiles.put("PROVINCE", new Stack<Card>());
		this.provinceSupply = this.supplyPiles.get("PROVINCE");
		for (int i = 0; i < 12; i++) {
			this.provinceSupply.push(new Province());
		}
	}

	private void setUpCurse() {
		this.supplyPiles.put("CURSE", new Stack<Card>());
		this.curseSupply = this.supplyPiles.get("CURSE");
		for (int i = 0; i < 30; i++) {
			this.curseSupply.push(new Curse());
		}
	}

	public List<Stack<Card>> getKingdomCardList() {
		return this.kingdomCardList;
	}

	public Stack<Card> getBaseSupply(String cardName) {
		return this.supplyPiles.get(cardName);
	}

	public Stack<Card> getCopperSupply() {
		return this.supplyPiles.get("COPPER");
	}

	public Stack<Card> getSilverSupply() {
		return this.supplyPiles.get("SILVER");
	}

	public Stack<Card> getGoldSupply() {
		return this.supplyPiles.get("GOLD");
	}

	public Stack<Card> getEstateSupply() {
		return this.supplyPiles.get("ESTATE");
	}

	public Stack<Card> getDuchySupply() {
		return this.supplyPiles.get("DUCHY");
	}

	public Stack<Card> getProvinceSupply() {
		return this.supplyPiles.get("PROVINCE");
	}

	public Stack<Card> getCurseSupply() {
		return this.supplyPiles.get("CURSE");
	}

	public boolean isGameOver() {
		if (this.supplyPiles.get("PROVINCE").isEmpty()) {
			return true;
		}
		if (this.isThreePilesGone()) {
			return true;
		}
		return false;
	}

	private boolean isThreePilesGone() {
		int numPilesGone = 0;

		for (int i = 0; i < 10; i++) {
			if (this.getKingdomCardList().get(i).isEmpty()) {
				numPilesGone++;
			}
		}
		for (String cardName : this.supplyPiles.keySet()) {
			if (this.supplyPiles.get(cardName).isEmpty()) {
				numPilesGone++;
			}
		}

		return numPilesGone >= 3;
	}

}
