// Pavlos Basoukeas, AM: 5296
import java.util.ArrayList;
import java.util.Random;

public class Hand {
    private ArrayList<Card> handCards = new ArrayList<>();  // list of cards in the player hand

    // adds a card to the player hand
    public void addCard(Card card) {
        this.handCards.add(card);
    }
    
    // prints all cards in the hand  with their positions
    public void print() {
		String handPrint = "";
		String indexPrint = "";
		for(int i =0; i<handCards.size(); i++) {
			handPrint += handCards.get(i).toString();
			indexPrint += String.valueOf(i);
			handPrint += "	";
			indexPrint +="	 ";
		}
		System.out.println(handPrint+"\n"+indexPrint);
	}
    
    // retrieves and removes a card from the hand at the specified position
    public Card getCard(int indexOfHand) {
        Card handCard = this.handCards.get(indexOfHand);  // get the card
        System.out.print(handCard.toString());
        this.handCards.remove(indexOfHand);  // remove card from hand
        return handCard; 
    }
    
    // selects a card to play based on the top card of the pile or a jack or any card if no matches
	public Card selectComputerCard(Card topCard) {
		
		// match card with top card
		for(int i =0; i< handCards.size(); i++) {
			if(handCards.get(i).equals(topCard)) {
				Card selectedCard = getCard(i);
				return selectedCard;
			}
		}
        
		// find and return a jack if no matches
		for(int i =0; i< handCards.size(); i++) {
			if (handCards.get(i).isJack() && topCard!=null) {
				Card selectedCard = getCard(i);
				return selectedCard;
			}
		}
		
		// if no strategic card found, return a random card
		Random ran = new Random();
		int randomCardIndex = ran.nextInt(handCards.size());
		Card selectedCard = getCard(randomCardIndex);
		return selectedCard;
    }
    
    // checks if the hand is empty
	public boolean isEmpty() {
		if (this.handCards.size() == 0) {
			return true;
		}
		return false;
	}

    // getter for cards in the hand
    public ArrayList<Card> getHandCards() {
        return this.handCards;  
    } 
}
