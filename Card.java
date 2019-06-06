import javax.swing.*;

/**
 * Represents a playing card with a suit,
 * rank, image, and face up status.
 * @author lambertk, Bennett Hermann, and Tristan Cade
 *
 */
public class Card implements Comparable<Card>{

    private Suit suit;
    private int rank;
    private boolean faceUp;
    private Icon image;
    private static Icon CARD_BACK;
    

    /**
     * Constructor.
     * @param suit the card's suit
     * @param rank the card's rank
     */
    public Card(Suit suit, int rank){
    	this.suit = suit;
    	this.rank = rank;
    	faceUp = false;
    	image = getImageFromFile(rank, suit);
    	if (CARD_BACK == null)
    		CARD_BACK = getBackFromFile();
    }

    /**
     * Returns the card's face image if its face is up or its back side image otherwise.
     * @return the card's face image or the back side image
     */
    public Icon getImage(){
    	if (faceUp)
    	    return image;
    	else
    	    return CARD_BACK;
    }

    /**
     * Returns the back side image of a card.
     * @return the back side image of a card
     */
    public static Icon getBack(){
    	if (CARD_BACK == null)
    	    new Card(Suit.spade, 1);
    	return CARD_BACK;
    }

    /**
     * Turns the card over, negating its face up status.
     */
    public void turn(){
    	faceUp = ! faceUp;
    }

    public Icon getImageFromFile(int rank, Suit suit){
    	if(FCMainView.VAL == 1){
            String fileName = "DECK/";
    	    fileName += rank;
    	    fileName += Character.toUpperCase(suit.toString().charAt(0));
            fileName += ".GIF";
           
            return new ImageIcon(getClass().getResource(fileName));
        }
        else if(FCMainView.VAL == 2){
            String fileName2 ="Deck2/";
            fileName2 += rank;
    	    fileName2 += Character.toUpperCase(suit.toString().charAt(0));
            fileName2 += ".GIF";
            
            return new ImageIcon(getClass().getResource(fileName2));
        }
        else if(FCMainView.VAL == 3){
            String fileName3 ="Deck3/";
            fileName3 += rank;
    	    fileName3 += Character.toUpperCase(suit.toString().charAt(0));
            fileName3 += ".PNG";
            
            return new ImageIcon(getClass().getResource(fileName3));
        }
        else{
            String fileName4 ="Deck4/";
            fileName4 += rank;
    	    fileName4 += Character.toUpperCase(suit.toString().charAt(0));
            fileName4 += ".PNG";
            
            return new ImageIcon(getClass().getResource(fileName4));
        }
    }

    private Icon getBackFromFile(){
    	String fileName = "DECK/CARDBACK.GIF";
    	return new ImageIcon(getClass().getResource(fileName));
    }

    /**
     * Returns the card's face up status.
     * @return true if face up or false otherwise
     */
    public boolean isFaceUp(){
       return faceUp;
    }

    /**
     * Returns the card's suit.
     * @return the card's suit
     */
    public Suit getSuit(){
        return suit;
    }
    // if the card is black, returns 0
    // if the card is red, returns 1
    /**
     * Returns 0 if the card is black and 1 if the card is red.
     */
    
    
    public boolean sameColor(Card other) {
    	if ((this.getSuit() == Suit.spade || this.getSuit()== Suit.club) 
    			&& (other.getSuit() == Suit.spade || other.getSuit()== Suit.club)){
    				return true;
    			}
    	if ((this.getSuit() == Suit.heart || this.getSuit()== Suit.diamond) 
    	    	&& (other.getSuit() == Suit.heart || other.getSuit()== Suit.diamond)){
    	    		return true;
    	    	}
    	else {
    		return false;
    	    	}
    			
    }
    
    public boolean sameSuit(Card other) {
    	if (this.getSuit() == other.getSuit()){
    		return true;
    		}
    	else {
    		return false;
    	}
    }
    
    public boolean greaterByOne(Card other) {
    	if (this.getRank() == other.getRank() + 1) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public int getColor(Card card) {
    	if (card.getSuit() == Suit.spade) {
    		return 0;
    	}
    	if (card.getSuit() == Suit.club) {
    		return 0;
    	}
    	if (card.getSuit() == Suit.diamond) {
    		return 1;
    	}
    	if (card.getSuit() == Suit.heart) {
    		return 1;
    	}
    		
    	else {
    		return 2;
    	}
    }
    		
    /**
     * Returns the card's rank
     * @return the card's rank
     */
    public int getRank(){
        return rank;
    }

    /**
     * Compares two cards with respect to rank
     * @return 0 if equal, less than 0 if less, greater than 0 if greater
     */
    public int compareTo(Card other){
        return this.rank - other.rank;
    }

    /**
     * Returns the string representation of the card (rank of suit)
     * @return the string representation of the card
     */
    public String toString(){
        return rankToString(rank) + " of " + suit;
    }

    static private String rankToString(int rank){
        if (rank >= 2 && rank <= 10) return rank + "";
        else if (rank == 11) return "Jack";
        else if (rank == 12) return "Queen";
        else if (rank == 13) return "King";
        else return "Ace";
    }
}