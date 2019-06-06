import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.lang.*;

/**
 * Represents a deck of playing cards.
 * @author Carter Huffman
 *
 */
public class CellPanel extends AbstractPanel{    
    private static final long serialVersionUID = 1L;
    //private ViewInformer view;
    //protected Cell pile;
    public static final Color DarkGreen = new Color(0,153,0);

    public CellPanel(Cell c, ViewInformer v){
        super(c, v);
        setBackground(DarkGreen);
        //this.view = v;
        //this.pile = c;
        
       // addMouseListener(new CellPanel.PanelListener(this));
    }
/*
    public void mousePressed(MouseEvent e) {
        System.out.println("check press");
        view.panelPressed(CellPanel.this);
    }
     public void mouseReleased(MouseEvent e){}
     public void mouseEntered(MouseEvent e){}
     public void mouseExited(MouseEvent e) {}
     public void mouseClicked(MouseEvent e) {
        //view.panelPressed(CellPanel.this);
     }
*/
    //public Cell getCell(){
       // return this.pile;
    //}

    /**
     * Paints the card's face image if a card is present, otherwise, paints the back side image.
     */
    public void paintComponent(Graphics g){
    
        super.paintComponent(g);
    	Icon image;
    	if (cell.isEmpty()){

            image = Card.getBack();
    		g.setColor(Color.yellow);
    		int x = (getWidth() - image.getIconWidth()) / 2;
    		int y = (getHeight() - image.getIconHeight()) / 2;
            g.drawRect(x, y, image.getIconWidth(), image.getIconHeight());
            
    	}
    	else{
            Card card = this.cell.get(this.cell.size()-1);
    		image = card.getImage();
    		int x = (getWidth() - image.getIconWidth()) / 2;
    		int y = (getHeight() - image.getIconHeight()) / 2;
            image.paintIcon(this, g, x, y);
            
        }
    }
/*
 private class PanelListener extends MouseAdapter{
    
    private CellPanel pan;
    private PanelListener(CellPanel p){
            this.pan = p;
    }
    public void mousePressed(MouseEvent e){
		CellPanel.this.view.panelPressed(this.pan);
        
	}
}
*/
}