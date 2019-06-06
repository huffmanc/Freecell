import javax.swing.JFrame;

/**
 * Generic main method template for any GUI-based application.
 * Instantiates a model and passes it to a new view.
 * @author Carter Huffman
 *
 */
public class GUIApp{

    public static void main(String[] args){
    
        
    final JFrame view = new FCMainView();
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setSize(1020, 730);
        view.setVisible(true);
        //view.setResizable(false);
    }
}