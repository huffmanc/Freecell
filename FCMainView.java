import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;




/**
 * The main window for dealing from a deck of cards.
 * @author Carter Huffman
 *
 */
public class FCMainView extends JFrame{

    
	private static final long serialVersionUID = 1L;
	public static final Color DarkGreen = new Color(0, 153, 0);
	final static boolean shouldFill = true;
	private Game game = new Game();
	private AbstractPanel frompanel;
	private ViewInformer view;
	public static int VAL = 1;
	public static Integer movecount = 0;
	public JButton button2 = new JButton("Card Design");
	public JLabel movelabel = new JLabel("Move Count: "+ movecount);
	

    public FCMainView(){
	this.view = new AppViewInformer();
	setBackground(DarkGreen);
	
//----------------Panel setup---------------------------------------------

	this.setTitle("FreeCell");
	JPanel center = new JPanel();
	JPanel toppanel = new JPanel();
	JPanel bottompanel = new JPanel();
	JPanel centertop = new JPanel();
	JPanel HomeCells = new JPanel();
	JPanel FreeCells = new JPanel();
	JPanel centerbottom = new JPanel();
	toppanel.setPreferredSize(new Dimension(1000,30));
	JLabel leftlabel = new JLabel("Free Cells");
	JLabel rightlabel = new JLabel("Home Cells");
	//JLabel movelabel = new JLabel("Move Count: "+ movecount);
	leftlabel.setHorizontalAlignment(leftlabel.CENTER);
	rightlabel.setHorizontalAlignment(rightlabel.CENTER);
	movelabel.setHorizontalAlignment(movelabel.CENTER);
	
//------------------Buttons-----------------------------------------------
	
    JButton button = new JButton("New Game");
    button.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
                
			game.reset();
			movecount = 0;
			movelabel.setText("Move Count: "+ movecount);
			FCMainView.this.repaint();
			frompanel = null;
			button2.setEnabled(true);
			
		}
	});

//------------------

	//JButton button2 = new JButton("Card Design");
    button2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            if(VAL == 1){
				VAL = 2;
				
			}    
			else if(VAL == 2){
				VAL = 3;
				
			}
			else if(VAL == 3){
				VAL = 4;
				
			}
			else{
				VAL = 1;
				
			}
			
			game.reset();
			movecount = 0;
			movelabel.setText("Move Count: "+ movecount);
			FCMainView.this.repaint();
		}

	});



//----------------Implementation--------------------------------------------------

	Container c = getContentPane();
	c.add(center, BorderLayout.CENTER);
	centertop.setLayout(new GridLayout(1,2));
	centertop.add(FreeCells);
	FreeCells.setLayout(new GridLayout(1,4));
	centertop.add(HomeCells);
	HomeCells.setLayout(new GridLayout(1,4));
	centerbottom.setLayout(new GridBagLayout());
	GridBagConstraints constraints = new GridBagConstraints();
	

	for (int i = 0; i < 8; i++) {
		Cell Tab = game.getTableauCells(i);
		TableauPanel tab1 = new TableauPanel(Tab, view);
		constraints.anchor = GridBagConstraints.PAGE_START;
		constraints.insets = new Insets(20,0,0,0);  //top padding
		constraints.ipady = 100;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridx = i;
		constraints.gridy = 0;
		centerbottom.add(tab1, constraints);
	}	
	
	for (int i = 0; i < 4; i++) {
		FreeCell Free = (FreeCell)game.getFreeCells(i);
		HomeCell Home = (HomeCell)game.getHomeCells(i);
		CellPanel free1 = new CellPanel(Free, view);
		CellPanel home1 = new CellPanel(Home, view);
		
		HomeCells.add(home1);
		FreeCells.add(free1);
	}
	
	centertop.setPreferredSize(new Dimension(1000,150));
	HomeCells.setBorder(BorderFactory.createLineBorder(Color.black, 3));
	FreeCells.setBorder(BorderFactory.createLineBorder(Color.black, 3));
	//centerbottom.setBorder(BorderFactory.createLineBorder(Color.black));
	centerbottom.setPreferredSize(new Dimension(1000,550));
	center.add(centertop, BorderLayout.NORTH);
	center.add(centerbottom, BorderLayout.SOUTH);
	center.setBackground(DarkGreen);
	centertop.setBackground(DarkGreen);
	centerbottom.setBackground(DarkGreen);
	HomeCells.setBackground(DarkGreen);
	FreeCells.setBackground(DarkGreen);
	

	c.add(toppanel, BorderLayout.NORTH);
	toppanel.setLayout(new GridLayout(1,3));
	toppanel.add(leftlabel);
	toppanel.add(movelabel);
	toppanel.add(rightlabel);
	
	c.add(bottompanel, BorderLayout.SOUTH);
	bottompanel.add(button, BorderLayout.CENTER);
	bottompanel.add(button2, BorderLayout.EAST);
	
	
//-------------------------------Mouse Stuff------------------------------------------
}


private class AppViewInformer implements ViewInformer{
	
	public void panelPressed(AbstractPanel p){

		button2.setEnabled(false);

		if (frompanel == null){
			if (p.getCell().isEmpty() || p.getCell() instanceof HomeCell) {
				JOptionPane.showMessageDialog(FCMainView.this, "invalid move");
				
				FCMainView.this.repaint();
				//frompanel = null;
			}
			else {	
			frompanel = p;
			}

		}
		else{
			//Cell pcell = p.getCell();
			//Cell frompanelcell = frompanel.getCell();
			if (game.move(frompanel.getCell(), p.getCell())) {
				frompanel.repaint();
				p.repaint();
				movecount ++;
				movelabel.setText("Move Count: "+ movecount);
				
				if (game.gameWon()){
					Icon iconz = new ImageIcon(FCMainView.class.getResource("FONZ.JPG"));
					JOptionPane.showMessageDialog(FCMainView.this, "Congratulations, You won!", "Congrats", JOptionPane.INFORMATION_MESSAGE, iconz);
				}
				if (game.gameLost()){
					Icon iconz = new ImageIcon(FCMainView.class.getResource("FONZNO.JPG"));
					JOptionPane.showMessageDialog(FCMainView.this, "You Lost!", "Sorry", JOptionPane.INFORMATION_MESSAGE, iconz);
				}
				
				frompanel = null;
			}
			else{
				JOptionPane.showMessageDialog(FCMainView.this, "invalid move");
				frompanel = null;
				
				
			}
			
		}
	
	}
	
}
}
