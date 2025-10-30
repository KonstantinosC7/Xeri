// Konstantinos Christopoulos, AM: 4527
import java.util.ArrayList;

public class CollectedCards {
	private ArrayList<Card> collectedCards;  
	
	public CollectedCards() {
		this.collectedCards = new ArrayList<>(); 
	}
	
	public CollectedCards(ArrayList<Card> cards) {
		//this.collectedCards = new ArrayList<>(); 
		this.collectedCards = cards; 
	}
	
	public boolean isEmpty() {
        if(collectedCards.size() == 0) {
        	return true;
        }
        return false;
    }
	
	public boolean isXeri() {
		if(isXeriWithJacks()==false && this.collectedCards.get(collectedCards.size()-1).equals(this.collectedCards.get(collectedCards.size()-2))){
			return true;
		}
		return false;
    }
	
	public boolean isXeriWithJacks() {
		if(this.collectedCards.get(collectedCards.size()-1).isJack() && this.collectedCards.get(collectedCards.size()-2).isJack()) {
			return true;
		}
		return false;
    }
	
	public ArrayList<Card> getCards(){
		return this.collectedCards;
	}
	
	
}
