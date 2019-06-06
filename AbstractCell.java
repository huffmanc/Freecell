import java.util.*;

/**
 * Abstract Cell Class
 * @author Carter Huffman + Tristan Cade + Bennett Hermann
 *
 */




public abstract class AbstractCell implements Cell {
    
	protected ArrayList<Card> cards;
	
	public AbstractCell() {
		cards = new ArrayList<Card>();
	}
	
	public Iterator<Card> iterator() {
        return cards.iterator();
	}
	/**
	* Turns the Cell into a string.
	*/
	public String toString() {
        return cards.toString();
        
	}
	/**
	* @Param needs a card to add
	* Adds a card to a cell.
	*/
	public boolean add(Card card) {
        return this.cards.add(card);
        
	}

	/**
	* Returns and removes the top card of a cell.
	*/
	public Card remove() {
    	if (cards.isEmpty()) {
    		//Raise Exception
        	return null;
        }
        else {
        	return cards.remove(cards.size() - 1);	
        }
    	}

	/**
	* Checks to see if the cell is empty.
	*/
    public boolean isEmpty() {
    	if (cards.size() == 0) {
    		return true;
    	}
    	else {
    		return false; 
    	}
    	}

    public int size(){
        return cards.size();
    	}

    	
    
	public boolean canMoveFrom(Cell source) {
		return !(source.isEmpty()) && !(source instanceof HomeCell);
	}
	
	public boolean moveFrom(Cell source) {
		if (this.canMoveFrom(source)) {
			Card card = source.remove();
			return this.add(card);
		}
		else {
			return false;
		}
	}
	
    	

	
	public Card peek() {
		return cards.get(this.size() - 1);
	}

	
	public void clear() {
		cards.clear();
	}

	public Card get(int i){
		return cards.get(i);
	}


	public boolean loserMoveFrom(Cell source) {
		if (canMoveFrom(source)) {
			Card top = source.peek();
			if (this.isEmpty()) {
				if (source instanceof FreeCell) {
					
					return true;
				}
				int pos = source.size() - 1;
			}
			else if (!(this.isEmpty())) {
				if (this.peek().greaterByOne(top) && !(this.peek().sameColor(top))) {
					
					
					return true;
				}
				int pos = source.size() - 1;
				 while ((pos != 0) && source.get(pos - 1).greaterByOne(source.get(pos)) && 
					!(source.get(pos-1).sameColor(source.get(pos)))) {
						
						if(this.peek().greaterByOne(source.get(pos)) 
								&& (!this.peek().sameColor(source.get(pos)))) {
							
							
							return true;
						}
						pos -= 1;
						}
				if(this.peek().greaterByOne(source.get(pos)) 
						&& (!this.peek().sameColor(source.get(pos)))) {
					int count = 0;
					
					
					return true;
				}
				return false;
			}

			else {
				return false;
			}
			}
		return true;
		}
	


}