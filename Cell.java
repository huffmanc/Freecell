/**
 * @ authors Bennett Hermann, Tristan Cade, Carter Huffman
 */

import java.util.*;


public interface Cell extends Iterable<Card> {

	public boolean canMoveFrom(Cell source);

	public boolean loserMoveFrom(Cell source);
	
	public boolean moveFrom(Cell source);
	
	public int size();
	
	public boolean add(Card card);
	
	public Iterator<Card> iterator();
	
	public Card remove();
	
	public String toString();
	
	public Card peek();
	
	public void clear();
	
	public boolean isEmpty();

	public Card get(int i);
	

	
}