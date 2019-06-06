import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.lang.*;



/**
 * Represents a TableauPanel
 * @author Carter Huffman
 *
 */
public class TableauPanel extends AbstractPanel{    
    
    private static final long serialVersionUID = 1L;
    // private Card card;
    //private Cell pile;
    public static final Color DarkGreen = new Color(0,153,0);


    /**
     * Constructor to display a given card's image.
     * @param c the card to display.
     */
    public TableauPanel(Cell c, ViewInformer view){
        super(c, view);
        //this.pile = c;
        
        setBackground(DarkGreen);
        /*setMinimumSize(new Dimension(100,100));
        pile = c;
        //addMouseListener(this);
        addMouseListener(new PanelListener());
    }

    public Cell getCell(){
        return pile;
    }
*/}

    /**
     * Paints the card's face image if a card is present, otherwise, paints the back side image.
     */
    
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        Icon image;
        
    	if (!cell.isEmpty()){
            int var = 0;
            for (int i = 0; i < cell.size(); i++) {
            Card card = cell.get(i);
            image = card.getImage();
    		int x = (getWidth() - image.getIconWidth()) / 2;
            int y = 0;
            image.paintIcon(this, g, x, y + var);
            var += 35;
            }
    	}
    	else{

            image = Card.getBack();  
    		g.setColor(Color.yellow);
    		int x = (getWidth() - image.getIconWidth()) / 2;
    		int y = 0; //(getHeight() - image.getIconHeight()) / 2;
            g.drawRect(x, y, image.getIconWidth(), image.getIconHeight());
            
        }
    }

}