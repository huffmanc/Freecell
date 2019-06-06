import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class AbstractPanel extends JPanel{
  protected Cell cell;
  private ViewInformer view;
  
  public AbstractPanel(Cell c, ViewInformer v)
  {
    this.cell = c;
    this.view = v;
    addMouseListener(new PanelListener());
  }
  
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
  }
  
  public Cell getCell()
  {
    return this.cell;
  }
  
  private class PanelListener extends MouseAdapter{
    
    public void mousePressed(MouseEvent e)
    {
      view.panelPressed(AbstractPanel.this);
    }
  }
}
