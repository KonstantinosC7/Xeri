// Konstantinos Christopoulos, AM: 4527
import java.util.ArrayList;
import java.util.Scanner;

public class XeriPlayer {
    
    private String playerName;  // name of the player
    private Hand hand;  // the hand of cards player holds
    private ArrayList<Card> AllCollectedCards = new ArrayList<>();  // cards collected by the player during the game
    private int xeriCount = 0;  // counts the number of xeri made by the player
    private int points = 0;  // total points accumulated by the player
    
    
    public XeriPlayer(String playerName) {
        this.playerName = playerName;  // initialize player with a name
    }
    
    
    public void getCards(CardStack cardStack) {
        this.hand = new Hand();  // initialize the hand
        for(int i = 0; i<6; i++) {
            this.hand.addCard(cardStack.draw());  // draw 6 cards to the player hand from the deck
        }
    }
    
    public Card selectCard() {
        this.hand.print();  // show the player hand
        System.out.print("Select Card position: ");
        Scanner intputPos = new Scanner(System.in);
        int pos = intputPos.nextInt();  // get the card position from player input
        while(pos < 0 || pos > this.hand.getHandCards().size()-1) {
            System.out.print("Select a valid Card position: ");  // try again with valid position input
            intputPos = new Scanner(System.in);
            pos = intputPos.nextInt();
        }
        System.out.print("Player " + this.playerName + " selected card: ");
        return this.hand.getCard(pos);  
    }
    
    public Card selectComputerCard(Card topCard) {
        System.out.print("Player " + this.playerName + " selected card: ");
        return this.hand.selectComputerCard(topCard);  // select a card based on the top card on the pile
    }
    
    public void collectCards(CollectedCards collectedCards) {
        if(collectedCards.isEmpty() == false) {
            for (Card card: collectedCards.getCards()) {
                this.AllCollectedCards.add(card);  // add collected cards to the player collection
            }
            if(collectedCards.getCards().size() == 2 && collectedCards.isXeri()) {
                xeriCount += 1;  // increment xeri count if a xeri is made
                System.out.println("\nPlayer " + this.playerName + " made Xeri");
            }else if (collectedCards.getCards().size() == 2 && collectedCards.isXeriWithJacks()) {
                xeriCount += 2;  // increment xeri count by two if a xeri with jacks is made
                System.out.println("\nPlayer " + this.playerName + " made Xeri with Jacks");
            }
        }
    }
    
    public void computePoints() {
        points += this.xeriCount * 10;  // calculate points from xeri
        for(Card card : this.AllCollectedCards) {
            if(card.isHighCard()) {
                this.points += 1;  // add points for high cards
            }
            if(card.isTenDiamond()) {
                this.points += 1;  // add points for ten of diamonds
            }else if(card.isTwoClubs()) {
                this.points += 1;  // add points for two of clubs
            }
        }
    }
    
    public void compareCardCount(XeriPlayer player2) {
        player2.computePoints();  // compute points for the other player
        this.computePoints();  // compute points for this player
        
        if(player2.AllCollectedCards.size() > this.AllCollectedCards.size()) {
            player2.points += 3;  // add bonus points to player with more cards
        }
        else if (player2.AllCollectedCards.size() < this.AllCollectedCards.size()) {
            this.points += 3;  // add bonus points to this player
        }
        System.out.println("Player " + this.playerName + " has " + this.points + " points, Player " + player2.playerName + " has " + player2.points + " points");
        if(player2.points > this.points) {
            System.out.println("Player " + player2.playerName + " won!");
            
        }else if(this.points > player2.points) {
            System.out.println("Player " + this.playerName + " won!");
        }else {
            System.out.println("It's a draw!");
        }
    }
    
    public boolean outOfCards() {
        System.out.println("\n\nPlayer " + this.playerName + " Turn");
        if (hand.isEmpty()) {
            return true;  // check if the player's hand is empty
        }
        return false;
    }
}
