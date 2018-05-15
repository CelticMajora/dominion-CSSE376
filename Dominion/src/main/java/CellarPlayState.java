
public class CellarPlayState extends CardPlayState {
	
	@Override
	public void run(Turn turn){
		boolean response;
		int numCardsToAdd = 0;
		
		int handSize = turn.player.sizeOfHand();
		
		while(handSize != 0) {
			response = turn.player.promptYesNo("Would you like to discard a card from your hand for +1 Card?");
			if(response) {
				Card card = turn.player.chooseCardFromHand();
				turn.player.discardCardFromHand(card.getClass());
				numCardsToAdd++;
			}
			else{
				break;
			}
			handSize = turn.player.sizeOfHand();			
		}
		
		for(int i = 0; i < numCardsToAdd; i++) {
			turn.player.drawACard();
		}
	}

}
