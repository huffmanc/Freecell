/**
 * @ authors Bennett Hermann, Tristan Cade, Carter Huffman
 */

import java.util.*;

import javax.swing.*;



public class HomeCell extends AbstractCell{
	

	public HomeCell() {
		super();
	}
	

	public boolean moveFrom(Cell source) {
		if (canMoveFrom(source)) {
			Card top = source.peek();
			if (this.isEmpty() && top.getRank() == 1) {
				source.remove();
				this.add(top);
			}
			else if (!(this.isEmpty()) && top.greaterByOne(this.peek()) && top.sameSuit(this.peek())) {
				source.remove();
				this.add(top);
			}
			else {
				return false;
			}
			}
		return true;
			}
		}
	
	
	//Establishing rules
	

			
		
	