/**
 * Implements a Free Cell object.
 * @Author Tristan Cade, Bennett Hermann, Carter Huffman, Garrett Cannon
 */
import java.util.*;
import javax.swing.*;


public class TableauCell extends AbstractCell {
	/**
	 * Creates a TableauCell object and returns it by creating an Array List.
	 */

	public TableauCell() {
		super();
	}
	
//	protected ArrayList<Card> cardHolder = new ArrayList<Card>();
	
	public boolean moveFrom(Cell source) {
		if (canMoveFrom(source)) {
			Card top = source.peek();
			if (this.isEmpty()) {
				if (source instanceof FreeCell) {
					source.remove();
					this.add(top);
					
					return true;
				}
				int pos = source.size() - 1;
					while ((pos != 0) && source.get(pos - 1).greaterByOne(source.get(pos)) && 
						!(source.get(pos-1).sameColor(source.get(pos)))) {
							pos -= 1;
						}
					int count = 0;
					for (int x = pos; x < source.size(); x++) {
						this.add(source.get(x));
						count += 1;
					}
					for (int k = 0; k < count; k++) {
						source.remove();
					}
			
			}
			else if (!(this.isEmpty())) {
				if (this.peek().greaterByOne(top) && !(this.peek().sameColor(top))) {
					source.remove();
					this.add(top);
					
					return true;
				}
				int pos = source.size() - 1;
				while ((pos != 0) && source.get(pos - 1).greaterByOne(source.get(pos)) && 
					!(source.get(pos-1).sameColor(source.get(pos)))) {
						
						if(this.peek().greaterByOne(source.get(pos)) 
								&& (!this.peek().sameColor(source.get(pos)))) {
							int count = 0;
							for (int x = pos; x < source.size(); x++) {
								this.add(source.get(x));
								count += 1;
							}
							for (int k = 0; k < count; k++) {
								source.remove();
							}
							
							return true;
						}
						pos -= 1;
					}
				if(this.peek().greaterByOne(source.get(pos)) 
						&& (!this.peek().sameColor(source.get(pos)))) {
					int count = 0;
					for (int x = pos; x < source.size(); x++) {
						this.add(source.get(x));
						count += 1;
					}
					for (int k = 0; k < count; k++) {
						source.remove();
					}
					
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
	

		/*

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
		*/
	}
	



			
