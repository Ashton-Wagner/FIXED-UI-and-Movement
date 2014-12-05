
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionListener;

public class PanGame extends JPanel implements ActionListener {

    LoadImages loadImages = new LoadImages();
    private Yeti yeti;
    int f = 0;
    int i = 0;
    int x = 0;
    int y = 0;
    private Timer timer;

    public PanGame() {
        super();
        yeti = new Yeti();
        addKeyListener(new MovementChecker());
        setFocusable(true);
        timer = new Timer(80, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent arg0) {
        yeti.move();
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(loadImages.GetimgGameBG(),0,0,null);
        g2d.drawImage(yeti.getImage(), yeti.getX(), yeti.getY(), null);
    }

    private class MovementChecker extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent k) {
            yeti.keyReleased(k);
        }

        @Override
        public void keyPressed(KeyEvent k) {
            yeti.keyPressed(k);
        }
    }
}