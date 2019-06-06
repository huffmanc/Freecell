/**
 * Implements a Free Cell object.
 * @Author Tristan Cade, Bennett Hermann, Carter Huffman, Garrett Cannon
 */

import java.util.*;
import javax.swing.*;


public class FreeCell extends AbstractCell{
	/**
	 * Makes a FreeCell object by making an Array List.
	 * Returns the freecell object.
	 */

	public FreeCell() {
		super();
	}
	//Establishing rules
	
	public boolean moveFrom(Cell source) {
		if (this.canMoveFrom(source) && this.isEmpty()) {
			this.add(source.remove());
			
		}
		else {
			return false;
		
		
		}
		return true;
		
	}
	
	
	


}