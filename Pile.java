// Pavlos Basoukeas, AM: 5296
import java.util.ArrayList;

public class Pile {
    private ArrayList<Card> pileCards = new ArrayList<Card>(); 
    private Card topCard;  // last card played on top of the pile

    // fills the pile with the initial four cards from the card stack
    public void fill(CardStack stack) {
        for(int i = 0; i < 4; i++) {
            this.pileCards.add(stack.draw());  // draw and add card to pile
        }
        this.topCard = pileCards.get(pileCards.size() - 1);  // set the top card of the pile
    }
    
    // player plays a card
    public CollectedCards drop(Card newCard) {
        if((newCard.equals(topCard) || newCard.isJack()) && this.topCard != null) {  //  if player collects cards
            this.pileCards.add(newCard);  // add new card to the pile
            ArrayList<Card> tempCards = new ArrayList<>(this.pileCards);  // create a hard copy of pile cards
            CollectedCards collectedPlayerCards = new CollectedCards(tempCards);  // create CollectedCards object
            this.pileCards.clear();  // clear the pile
            this.topCard = null;  // reset top card
            return collectedPlayerCards;
        } else {  // if no cards are collected
            CollectedCards collectedPlayerCards = new CollectedCards();  // create empty CollectedCards object
            this.pileCards.add(newCard);  // add new card to pile
            this.topCard = newCard;  // update top card
            return collectedPlayerCards;
        }
    }
    
    // returns the current top card of the pile
    public Card getTopCard() {
        return this.topCard;
    }
    
    // prints the top card of the pile or a "-" if empty
    public void printTopCard() {
        if(this.pileCards.isEmpty()) {
            System.out.println("Top Card: -");  
        } else {
            System.out.println("Top Card: " + this.topCard);
        }
    }
    
    // returns a string  of the pile
    public String toString() {
        String returnString = "Pile Cards:";
        if (this.pileCards.isEmpty()) {
            returnString += " - "; 
            return returnString;
        }
        for (Card card : this.pileCards) {
            returnString += card.toString() + " "; 
        }
        return returnString;
    }

    // provides access to the pile of cards
    public ArrayList<Card> getPileCards() {
        return this.pileCards;
    }
}
