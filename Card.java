// Pavlos Basoukeas, AM: 5296
public class Card {
    private String suit; // color of the card : 
    					// Spade (Mpastouni)->"S", 
    					// Heart (Koupa) -> "H", 
    					// Diamond (karro) -> "D", 
    					// Club (spathi) -> "C"
    private int rank; // 2-10, 
    				// 11 for Jack (Bales), 
    				// 12 for Queen (Ntama), 
    				// 13 for King (Rhgas), 
    				// 14 for Ace (Assoas)
    
    // Constructor
    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }
    
    // Converts card details into a string representation
    public String toString() {
        String rankToStr = String.valueOf(this.rank);
        if (this.rank == 11) {
        	rankToStr = "J";
        }
        else if (this.rank == 12) {
        	rankToStr = "Q";
        }
        else if (this.rank == 13) {
        	rankToStr = "K";
        }
        else if (this.rank == 14) {
        	rankToStr = "A";
        }
        return rankToStr + this.suit;
    }
    
    // Compares this card to another card to see if their ranks are equal
    public boolean equals(Card card) {
        if (card == null) {
        	return false;
        }
    	if (this.rank == card.rank) {
        	return true;
        }else {
        	return false;
        }
    }
    
    // Checks if this card and the given card are consecutive in rank
    public boolean consecutive(Card card) {
    	if(this.rank == card.rank + 1 || this.rank + 1 == card.rank) {
    		return true;
    	}
    	return false;
    }
    
    // Checks if this card has a greater rank than the given card
    public boolean greaterThan(Card card) {
    	if(this.rank > card.rank) {
    		return true;
    	}
    	return false;
    }
    
    // Checks if this card's rank is strictly between two other cards' ranks
    public boolean between(Card[] cards2) {
    	if (this.rank > cards2[0].rank && this.rank < cards2[1].rank) {
    		return true;
    	}
    	return false;
    }
    
    // Checks if this card is a Jack
    public boolean isJack() {
    	if (this.rank == 11) {
    		return true;
    	}
    	return false;
    }
    
    // Checks if this card is a high card (rank 10 or above)
    public boolean isHighCard() {
    	if (this.rank >= 10) {
    		return true;
    	}
    	return false;
    }
    
    // Checks if this card is the Two of Clubs
    public boolean isTwoClubs() {
    	if (this.rank == 2 && this.suit.equals("C")) {
    		return true;
    	}
    	return false;
    }
    
    // Checks if this card is the Ten of Diamonds
    public boolean isTenDiamond() {
    	if (this.rank == 10 && this.suit.equals("D")) {
    		return true;
    	}
    	return false;
    }
}