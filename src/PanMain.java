
import java.awt.BorderLayout;
import javax.swing.JPanel;

public class PanMain extends JPanel {
    //PanStats panstats = new PanStats();
    PanUI panUI = new PanUI();
    PanGame pangame = new PanGame();
    public PanMain() {
        setLayout(new BorderLayout());
        //setPreferredSize(new Dimension(1250,75));
        //add(panstats, BorderLayout.SOUTH);
        add(pangame, BorderLayout.CENTER);
        add(panUI, BorderLayout.SOUTH);
    }
}
