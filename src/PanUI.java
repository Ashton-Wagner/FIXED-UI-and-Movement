
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PanUI extends JPanel {

    LoadImages imgres = new LoadImages();
    Image iBG;
    Image ariNumbers[] = new Image[10];
    Image imgTime;
    Image imgScore;
    Image imgLives;
    Image imgCoins;
    Image imgTimeCount1;
    Image imgTimeCount2;
    Image imgTimeCount3;
    int Time1 = 1;
    int Time2 = 8;
    int Time3 = 0;
    Boolean bStopTimer = false;
    Boolean bTimeChanged1;
    Boolean bTimeChanged2 = false;
    Timer timer;
    Boolean BTimeReset = false;
    Boolean bLifeLost = false;
    int nLife = 3;
    int nCoins1 = 0;
    int nCoins2 = 0;
    int nScore1 = 0;
    int nScore2 = 0;
    int nScore3 = 0;

    public PanUI() {
        setPreferredSize(new Dimension(1250, 75));
        iBG = imgres.GetimgBG();
        ariNumbers = imgres.GetNumbers();
        imgTime = imgres.GetimgTime();
        imgScore = imgres.GetimgScore();
        imgLives = imgres.GetimgLives();
        imgCoins = imgres.GetimgCoins();
        timer = new Timer(1000, updateImage);
        timer.start();
    }

    public void ResetTime() {
        BTimeReset = true;
        bStopTimer = false;
    }

    public void LooseALife(Boolean _bLifeLost) {
        bLifeLost = _bLifeLost;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        ////
        g.drawImage(iBG, 0, 0, null);
        ////
        g.drawImage(imgTime, 950, 10, null);
        g.drawImage(ariNumbers[(Time1)], 950 + imgTime.getWidth(this), 10, null);
        g.drawImage(ariNumbers[(Time2)], 950 + imgTime.getWidth(this) + 30, 10, null);
        g.drawImage(ariNumbers[(Time3)], 950 + imgTime.getWidth(this) + 60, 10, null);
        ////
        g.drawImage(imgLives, 10, 10, null);
        g.drawImage(ariNumbers[(nLife)], 10 + imgLives.getWidth(this), 10, null);
        ////
        g.drawImage(imgScore, 520, 10, null);
        g.drawImage(ariNumbers[(nScore1)], 520 + imgScore.getWidth(this) + 10, 10, null);
        g.drawImage(ariNumbers[(nScore2)], 520 + imgScore.getWidth(this) + 40, 10, null);
        g.drawImage(ariNumbers[(nScore3)], 520 + imgScore.getWidth(this) + 70, 10, null);
        ////
        g.drawImage(imgCoins, 230, 10, null);
        g.drawImage(ariNumbers[(nCoins1)], 230 + imgCoins.getWidth(this) + 10, 10, null);
        g.drawImage(ariNumbers[(nCoins2)], 230 + imgCoins.getWidth(this) + 40, 10, null);
        ////
    }
    ActionListener updateImage = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            bTimeChanged1 = false;
            if (Time1 == 0 && Time2 == 0 && Time3 == 0) {
                bStopTimer = true;
                timer.stop();
            }
            if (bStopTimer != true) {
                if (Time1 == 0 && Time3 == 0) {
                    bTimeChanged2 = true;
                }
                if (Time3 == 0 && bTimeChanged1 != true) {
                    Time2 -= 1;
                    Time3 += 10;
                    bTimeChanged1 = true;
                }
                if (Time2 == 0 && bTimeChanged2 != true) {
                    Time1 -= 1;
                    Time2 += 9;
                    bTimeChanged1 = true;
                }
                if (BTimeReset == true) {
                    Time1 = 1;
                    Time2 = 8;
                    Time3 = 0;
                    BTimeReset = false;
                }
                if (bLifeLost == true) {
                    nLife--;
                    bLifeLost = false;
                }
                Time3--;
            }
            repaint();
        }
    };
}