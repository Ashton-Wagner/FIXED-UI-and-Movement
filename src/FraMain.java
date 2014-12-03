


import java.awt.Toolkit;
import javax.swing.JFrame;

public class FraMain extends JFrame {

    public FraMain() {
        add(new PanMain());

        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = 1200;
        int ySize = 700;
        setSize(xSize, ySize);
        setTitle("insert name here");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
