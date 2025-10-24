// Pavlos Basoukeas, AM: 5296
public class Xeri {
    public static void main(String[] args) {
        // initialize players
        XeriPlayer user = new XeriPlayer("Human");  
        XeriPlayer computer = new XeriPlayer("Computer");

        // setup and shuffle card stack
        CardStack stack = new CardStack();
        stack.shuffle();  

        // initialize pile and fill with initial cards
        Pile pile = new Pile();
        pile.fill(stack);  

        System.out.println(pile.toString());  // print the current cards in the pile

        user.getCards(stack);  // user draws cards
        computer.getCards(stack);  // computer draws cards

        // flag to track who last collected cards
        boolean computerLastCollectedPlayer = false;

        while(true) {

            pile.printTopCard();  // display top card of the pile

            // user selects a card to play
            Card playerCard = user.selectCard();
            CollectedCards playerCollectedCards = pile.drop(playerCard);  // drop user card to the pile
            if(playerCollectedCards.getCards().size() > 0) {
                computerLastCollectedPlayer = false;  // user made a collection
            }
            user.collectCards(playerCollectedCards);  // user collects cards

            // check if computer is out of cards and needs to draw
            if(computer.outOfCards()) {
                computer.getCards(stack);
            }

            
            pile.printTopCard();  // display top card of the pile again

            // computer selects a card to play
            Card computerCard = computer.selectComputerCard(pile.getTopCard());
            CollectedCards computerCollectedCards = pile.drop(computerCard);  // drop computer card to the pile
            if(computerCollectedCards.getCards().size() > 0) {
                computerLastCollectedPlayer = true;  // computer made a collection
            }
            computer.collectCards(computerCollectedCards);  // computer collects cards

            // check if user is out of cards and if deck is empty
            if(user.outOfCards()) {
                if(stack.isEmpty()) {
                    // determine who gets the remaining cards in the pile
                    if(computerLastCollectedPlayer) {
                        CollectedCards lastCollectedCards = new CollectedCards(pile.getPileCards());
                        computer.collectCards(lastCollectedCards);  // computer collects remaining cards
                    } else {
                        CollectedCards lastCollectedCards = new CollectedCards(pile.getPileCards());
                        user.collectCards(lastCollectedCards);  // user collects remaining cards
                    }
                    break; 
                }
                user.getCards(stack);  // user draws new cards if deck is not empty
            }
        }

        // after game ends, compare points and determine winner
        user.compareCardCount(computer);

    }
}
